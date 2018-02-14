package br.sghvet.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.model.Cirurgia;
import br.sghvet.model.MembroCirurgia;
import br.sghvet.model.Veterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UiTabelaCirurgiaXEquipe implements Initializable{
	
	
	@FXML
	private TableView<Cirurgia> tv_cirurgia;
	@FXML
	TableColumn <Cirurgia,String> tc_data;
	@FXML
	TableColumn <Cirurgia,String>tc_inicio;
	@FXML
	TableColumn <Cirurgia,String>tc_termino;
	@FXML
	TableColumn <Cirurgia,String>tc_tipo;
	@FXML
	TableColumn <Cirurgia,String>tc_especialidade;
	@FXML
	TableColumn <Cirurgia,String>tc_prontuario;
	
	
	@FXML
	private TableView<Veterinario> tv_equipe;
	@FXML
	TableColumn <Veterinario,String> cl_vet_nome;
	@FXML
	TableColumn <Veterinario,String>cl_vet_cargo;
	@FXML
	TableColumn <Veterinario,String>cl_vet_email;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		try {
			setTvCirurgia();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void setTvCirurgia() throws Exception {
		
		tc_data.setCellValueFactory(new PropertyValueFactory<>("data"));
		tc_inicio.setCellValueFactory(new PropertyValueFactory<>("hora_inicio"));
		tc_termino.setCellValueFactory(new PropertyValueFactory<>("hora_fim"));
		tc_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tc_especialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
		tc_prontuario.setCellValueFactory(new PropertyValueFactory<>("prontuario_id"));

		
		ObservableList<Cirurgia> cirurgias = FXCollections.observableArrayList(Fachada.getInstance().buscarALLCirurgia());
			tv_cirurgia.setItems(cirurgias);		
					
		
	}

public void clickcirurgia() throws Exception{
	Cirurgia c1 = (Cirurgia) tv_cirurgia.getSelectionModel().getSelectedItem();
	setTvVet(c1);
}

public void setTvVet(Cirurgia cirurgia) throws Exception{
	cl_vet_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
	cl_vet_cargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
	cl_vet_email.setCellValueFactory(new PropertyValueFactory<>("email"));
	
	ArrayList<Veterinario> vetes = new ArrayList();
	
	for (MembroCirurgia membro : Fachada.getInstance().buscarMembros(cirurgia.getCod_cirurgia())){
	
		vetes.add(Fachada.getInstance().buscaVeterinario(membro.getMembro_cpf()));
	
		
	}
	
	ObservableList<Veterinario> vets = FXCollections.observableArrayList(vetes);
	tv_equipe.setItems(vets);
}



}
