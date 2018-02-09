package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.model.Animal;
import br.sghvet.model.Consulta;
import br.sghvet.model.Tutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UiTabelaTutorXAnimalController implements Initializable{

	@FXML
	private TableView tv_tutor;
	@FXML
	private TableColumn cl_tutor_cpf;
	@FXML
	private TableColumn cl_tutor_nome;
	@FXML
	private TableColumn cl_tutor_sexo;
	@FXML
	private TableColumn cl_tutor_contato;
	
	/**/
	
	@FXML
	private TableView tv_animal;
	@FXML
	private TableColumn cl_animal_nome;
	@FXML
	private TableColumn cl_animal_especie;
	@FXML
	private TableColumn cl_animal_raca;
	@FXML
	private TableColumn cl_animal_sexo;
	@FXML
	private TableColumn cl_animal_idade;
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		try {
			setTVTutor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void setTVTutor() throws Exception{
		cl_tutor_cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		cl_tutor_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cl_tutor_sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		cl_tutor_contato.setCellValueFactory(new PropertyValueFactory<>("contato"));
		
		ObservableList<Tutor> tutores = FXCollections.observableArrayList(Fachada.getInstance().buscarALLTutor());
		
		tv_tutor.setItems(tutores);
	}
	
	public void tableViewClick() throws Exception{
		Tutor t =  (Tutor) tv_tutor.getSelectionModel().getSelectedItem();
		setTVAnimal(t);
	}
	
	public void setTVAnimal(Tutor tutor) throws Exception{
		cl_animal_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cl_animal_especie.setCellValueFactory(new PropertyValueFactory<>("especie"));
		cl_animal_raca.setCellValueFactory(new PropertyValueFactory<>("raca"));
		cl_animal_sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		cl_animal_idade.setCellValueFactory(new PropertyValueFactory<>("idade"));

		
		ObservableList<Animal> animais = FXCollections.observableArrayList(Fachada.getInstance().buscarAnimal(tutor.getCpf()));
		
		tv_animal.setItems(animais);
	}

}
