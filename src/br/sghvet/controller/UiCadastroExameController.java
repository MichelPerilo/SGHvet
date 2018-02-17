package br.sghvet.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.model.NaturezaImagem;
import br.sghvet.model.NaturezaLaboratorial;
import br.sghvet.model.RequisicaoExame;
import br.sghvet.model.TipoExame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UiCadastroExameController implements Initializable {

	
	@FXML
	private Button botaosalvar;
	@FXML
	private Button botaoexcluir;
	@FXML
	private Button botaoatualizar;
	
	
	
	
	@FXML
	private ComboBox combobox_tipo;
	@FXML
	private ComboBox combobox_natureza;
	@FXML
	private TextField textfield_prontuario;
	@FXML
	private TextField textfield_cpf;
	@FXML
	private TextArea textarea_obs;
	@FXML
	private DatePicker datepicker_data;
	@FXML
	private TextField textfield_hora;
	
	private Stage stage;
	
	private int id_exame;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		ObservableList<Object> items = FXCollections.observableArrayList(TipoExame.values());
		combobox_tipo.setItems(items);
	}
	
	public void setTipo() throws Exception{
		switch ((TipoExame) combobox_tipo.getValue()) {

		case IMAGEM:
			ObservableList<Object> items = FXCollections.observableArrayList(NaturezaImagem.values());
			combobox_natureza.setItems(items);
				
			break;
		case LABORATORIAL:
			ObservableList<Object> itemsa = FXCollections.observableArrayList(NaturezaLaboratorial.values());
			combobox_natureza.setItems(itemsa);
			

			break;
		default:

			break;
		}
	}
	
	public void handler_fechar(){
		getStage().close();
	}
	
	//(TipoExame tipo, String natureza, String observacoes, int prontuario, LocalTime hora, LocalDate data, String cpf_vet,boolean realizado)
	
	public void handler_salvar() throws Exception{
		RequisicaoExame r1 = new RequisicaoExame((TipoExame)combobox_tipo.getValue(), combobox_natureza.getValue().toString(), textarea_obs.getText(), Integer.parseInt(textfield_prontuario.getText()), LocalTime.parse(textfield_hora.getText()), datepicker_data.getValue(), textfield_cpf.getText(), false );
		
		Fachada.getInstance().cadastraReqExame(r1);
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("Exame Marcado");
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
	
	public void carregarDados(RequisicaoExame r1){
		
		
		combobox_tipo.setValue(r1.getTipo());
		
		if (r1.getTipo().equals(TipoExame.IMAGEM)){
			ObservableList<Object> items = FXCollections.observableArrayList(NaturezaImagem.values());
			combobox_natureza.setItems(items);
			
			combobox_natureza.setValue(NaturezaImagem.valueOf(r1.getNatureza().toUpperCase()));
		}else{
			ObservableList<Object> itemsa = FXCollections.observableArrayList(NaturezaLaboratorial.values());
			combobox_natureza.setItems(itemsa);
			
			combobox_natureza.setValue(NaturezaLaboratorial.valueOf(r1.getNatureza().toUpperCase()));
		}
		
		
		textfield_prontuario.setText(Integer.toString(r1.getProntuario()));
		textfield_cpf.setText(r1.getCpf_vet());
		textarea_obs.setText(r1.getObservacoes());
		datepicker_data.setValue(r1.getData());
		textfield_hora.setText(r1.getHora().toString());
		setId_exame(r1.getId());
		botaosalvar.setVisible(false);
		botaoatualizar.setVisible(true);
		botaoexcluir.setVisible(true);
		
	}
	
	public void handler_atualizar() throws Exception{
		RequisicaoExame r1 = new RequisicaoExame((TipoExame)combobox_tipo.getValue(), combobox_natureza.getValue().toString(), textarea_obs.getText(), Integer.parseInt(textfield_prontuario.getText()), LocalTime.parse(textfield_hora.getText()), datepicker_data.getValue(), textfield_cpf.getText(), false );
		r1.setId(getId_exame());
		Fachada.getInstance().atualizaReqExame(r1);
		
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
	
	public void handler_excluir() throws Exception{
		RequisicaoExame r1 = new RequisicaoExame((TipoExame)combobox_tipo.getValue(), combobox_natureza.getValue().toString(), textarea_obs.getText(), Integer.parseInt(textfield_prontuario.getText()), LocalTime.parse(textfield_hora.getText()), datepicker_data.getValue(), textfield_cpf.getText(), false );
		r1.setId(getId_exame());
		Fachada.getInstance().deletarReqExame(r1);
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("Exame Cancelado");
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

	private int getId_exame() {
		return id_exame;
	}

	private void setId_exame(int id_exame) {
		this.id_exame = id_exame;
	}
	
	
	
	
	
	

}
