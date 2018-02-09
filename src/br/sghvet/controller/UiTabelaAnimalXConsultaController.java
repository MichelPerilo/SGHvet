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

public class UiTabelaAnimalXConsultaController implements Initializable{

	@FXML
	private TableView tv_consulta;
	@FXML
	private TableColumn cl_consulta_data;
	@FXML
	private TableColumn cl_consulta_hora;
	@FXML
	private TableColumn cl_consulta_vet;

	
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
		cl_animal_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cl_animal_especie.setCellValueFactory(new PropertyValueFactory<>("especie"));
		cl_animal_raca.setCellValueFactory(new PropertyValueFactory<>("raca"));
		cl_animal_sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		cl_animal_idade.setCellValueFactory(new PropertyValueFactory<>("idade"));

		
		ObservableList<Animal> animais = FXCollections.observableArrayList(Fachada.getInstance().allAnimals());
		
		tv_animal.setItems(animais);
	}
	
	public void tableViewClick() throws Exception{
		Animal a =  (Animal) tv_animal.getSelectionModel().getSelectedItem();
		setTVConsulta(a);
	}
	
	public void setTVConsulta(Animal animal) throws Exception{
		cl_consulta_data.setCellValueFactory(new PropertyValueFactory<>("dia"));
		cl_consulta_hora.setCellValueFactory(new PropertyValueFactory<>("horario"));
		cl_consulta_vet.setCellValueFactory(new PropertyValueFactory<>("nomeMedico"));
		
		
		ObservableList<Consulta> consultas = FXCollections.observableArrayList(Fachada.getInstance().buscarConsultaPro((int) animal.getNumProntuario()));
		
		tv_consulta.setItems(consultas);
	}

}
