package br.sghvet.controller;

import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.model.CargoAuxiliar;
import br.sghvet.model.Cirurgia;
import br.sghvet.model.MembroCirurgia;
import br.sghvet.model.SalaDeCirurgia;
import br.sghvet.model.TipoCirurgia;
import br.sghvet.model.Veterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UiCadastroCirurgiaController implements Initializable{

	@FXML
	private ComboBox combobox_tipo;
	@FXML
	private ComboBox combobox_sala;
	@FXML 
	private ComboBox combobox_membro1;
	@FXML
	private ComboBox combobox_membro2;
	@FXML
	private ComboBox combobox_membro3;
	@FXML
	private ComboBox combobox_membro4;
	@FXML
	private TextField textfield_inicio;
	@FXML
	private TextField textfield_fim;
	@FXML
	private TextField textfield_prontuario;
	@FXML
	private TextField textfield_especialidade;
	@FXML
	private DatePicker datepicker_data;
	
	@FXML
	private Button botaosalvar;
	@FXML
	private Button botaoatualizar;
	@FXML
	private Button botaoexcluir;
	
	private int codigo_cirurgia;
	
	private int id_m1;
	private int id_m2;
	private int id_m3;
	private int id_m4;

	private Stage stage;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		ObservableList<TipoCirurgia> tipocirur = FXCollections.observableArrayList(TipoCirurgia.values());
		combobox_tipo.setItems(tipocirur);
		
		ObservableList<SalaDeCirurgia> salacirur = FXCollections.observableArrayList(SalaDeCirurgia.values());
		combobox_sala.setItems(salacirur);
		
		ObservableList<Veterinario> vets;
		try {
			vets = FXCollections.observableArrayList(Fachada.getInstance().buscaTodosVeterinario());
			combobox_membro1.setItems(vets);
			combobox_membro2.setItems(vets);
			combobox_membro3.setItems(vets);
			combobox_membro4.setItems(vets);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	// (TipoCirurgia tipo, String especialidade, LocalDate data, LocalTime hora_inicio, LocalTime hora_fim, SalaDeCirurgia sala, int prontuario)
	public void handler_salvar() throws Exception{
		
		Random ger = new Random();
		int cod_cirur = ger.nextInt(100000);
		Cirurgia c1 = new Cirurgia((TipoCirurgia)combobox_tipo.getValue(), textfield_especialidade.getText() ,datepicker_data.getValue(), LocalTime.parse(textfield_inicio.getText()), LocalTime.parse(textfield_fim.getText()), (SalaDeCirurgia) combobox_sala.getValue(), Integer.parseInt(textfield_prontuario.getText()), cod_cirur );
		Fachada.getInstance().cadastrarCirurgia(c1);
		MembroCirurgia m1,m2,m3,m4;
		m1 = new MembroCirurgia(cod_cirur, ((Veterinario) combobox_membro1.getValue()).getCpf());
		m2 = new MembroCirurgia(cod_cirur, ((Veterinario) combobox_membro2.getValue()).getCpf());
		m3 = new MembroCirurgia(cod_cirur, ((Veterinario) combobox_membro3.getValue()).getCpf());
		m4 = new MembroCirurgia(cod_cirur, ((Veterinario) combobox_membro4.getValue()).getCpf());
		Fachada.getInstance().cadastrarMembroCirurgia(m1);
		Fachada.getInstance().cadastrarMembroCirurgia(m2);
		Fachada.getInstance().cadastrarMembroCirurgia(m3);
		Fachada.getInstance().cadastrarMembroCirurgia(m4);
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("Novo Procedimento Cadastrado");
		alert.setTitle("Confirmação");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			// ... user chose OK
			alert.close();
			stage.close();

		} else {
			// ... user chose CANCEL or closed the dialog
		}
		
		
	}
	
	public void carregarDados(Cirurgia cirurgia) throws Exception{
		combobox_tipo.setValue(cirurgia.getTipo());
		textfield_especialidade.setText(cirurgia.getEspecialidade()); 
		datepicker_data.setValue(cirurgia.getData()); 
		textfield_inicio.setText(cirurgia.getHora_inicio().toString()); 
		textfield_fim.setText(cirurgia.getHora_fim().toString()); 
		combobox_sala.setValue(cirurgia.getSala()); 
		textfield_prontuario.setText(String.valueOf(cirurgia.getProntuario_id())); 
		setCodigo_cirurgia(cirurgia.getCod_cirurgia());
		carregarEquipe(Fachada.getInstance().buscarMembros(cirurgia.getCod_cirurgia()));
		botaosalvar.setVisible(false);
		botaoatualizar.setVisible(true);
		botaoexcluir.setVisible(true);
		
		 
	}
	
	private void carregarEquipe(List<MembroCirurgia> list) throws Exception{
		Veterinario m1, m2, m3, m4;
		
		combobox_membro1.setValue(Fachada.getInstance().buscaVeterinario(list.get(0).getMembro_cpf()));
		setId_m1(list.get(0).getId());
		combobox_membro2.setValue(Fachada.getInstance().buscaVeterinario(list.get(1).getMembro_cpf()));
		setId_m2(list.get(1).getId());
		combobox_membro3.setValue(Fachada.getInstance().buscaVeterinario(list.get(2).getMembro_cpf()));
		setId_m3(list.get(2).getId());
		combobox_membro4.setValue(Fachada.getInstance().buscaVeterinario(list.get(3).getMembro_cpf()));
		setId_m4(list.get(3).getId());
	}
	
	public void handler_atualizar() throws Exception{
		
		Cirurgia c1 = new Cirurgia((TipoCirurgia)combobox_tipo.getValue(), textfield_especialidade.getText() ,datepicker_data.getValue(), LocalTime.parse(textfield_inicio.getText()), LocalTime.parse(textfield_fim.getText()), (SalaDeCirurgia) combobox_sala.getValue(), Integer.parseInt(textfield_prontuario.getText()), getCodigo_cirurgia() );
		Fachada.getInstance().atualizarCirurgia(c1);
		MembroCirurgia m1,m2,m3,m4;
		m1 = new MembroCirurgia(getCodigo_cirurgia(), ((Veterinario) combobox_membro1.getValue()).getCpf());
		m2 = new MembroCirurgia(getCodigo_cirurgia(), ((Veterinario) combobox_membro2.getValue()).getCpf());
		m3 = new MembroCirurgia(getCodigo_cirurgia(), ((Veterinario) combobox_membro3.getValue()).getCpf());
		m4 = new MembroCirurgia(getCodigo_cirurgia(), ((Veterinario) combobox_membro4.getValue()).getCpf());
		m1.setId(getId_m1());
		m2.setId(getId_m2());
		m3.setId(getId_m3());
		m4.setId(getId_m4());
		Fachada.getInstance().atualizarMembroCirurgia(m1);
		Fachada.getInstance().atualizarMembroCirurgia(m2);
		Fachada.getInstance().atualizarMembroCirurgia(m3);
		Fachada.getInstance().atualizarMembroCirurgia(m4);
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("Dados atualizados");
		alert.setTitle("Confirmação");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			// ... user chose OK
			alert.close();
			stage.close();

		} else {
			// ... user chose CANCEL or closed the dialog
		}
		
	}
	
	public void handler_fechar(){
		stage.close();
	}
	
	public void handler_excluir() throws Exception{
		MembroCirurgia m1,m2,m3,m4;
		m1 = new MembroCirurgia(getCodigo_cirurgia(), ((Veterinario) combobox_membro1.getValue()).getCpf());
		m2 = new MembroCirurgia(getCodigo_cirurgia(), ((Veterinario) combobox_membro2.getValue()).getCpf());
		m3 = new MembroCirurgia(getCodigo_cirurgia(), ((Veterinario) combobox_membro3.getValue()).getCpf());
		m4 = new MembroCirurgia(getCodigo_cirurgia(), ((Veterinario) combobox_membro4.getValue()).getCpf());
		m1.setId(getId_m1());
		m2.setId(getId_m2());
		m3.setId(getId_m3());
		m4.setId(getId_m4());
		Fachada.getInstance().removerMembroCirurgia(m1);
		Fachada.getInstance().removerMembroCirurgia(m2);
		Fachada.getInstance().removerMembroCirurgia(m3);
		Fachada.getInstance().removerMembroCirurgia(m4);
		Cirurgia c1 = new Cirurgia((TipoCirurgia)combobox_tipo.getValue(), textfield_especialidade.getText() ,datepicker_data.getValue(), LocalTime.parse(textfield_inicio.getText()), LocalTime.parse(textfield_fim.getText()), (SalaDeCirurgia) combobox_sala.getValue(), Integer.parseInt(textfield_prontuario.getText()), getCodigo_cirurgia() );
		Fachada.getInstance().removerCirurgia(c1);
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("Cirurgia Cancelada");
		alert.setTitle("Confirmação");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			// ... user chose OK
			alert.close();
			stage.close();

		} else {
			// ... user chose CANCEL or closed the dialog
		}
	}


	private Stage getStage() {
		return stage;
	}


	void setStage(Stage stage) {
		this.stage = stage;
	}

	private int getCodigo_cirurgia() {
		return codigo_cirurgia;
	}

	private void setCodigo_cirurgia(int codigo_cirurgia) {
		this.codigo_cirurgia = codigo_cirurgia;
	}

	private int getId_m1() {
		return id_m1;
	}

	private void setId_m1(int id_m1) {
		this.id_m1 = id_m1;
	}

	private int getId_m2() {
		return id_m2;
	}

	private void setId_m2(int id_m2) {
		this.id_m2 = id_m2;
	}

	private int getId_m3() {
		return id_m3;
	}

	private void setId_m3(int id_m3) {
		this.id_m3 = id_m3;
	}

	private int getId_m4() {
		return id_m4;
	}

	private void setId_m4(int id_m4) {
		this.id_m4 = id_m4;
	}

}
