package br.sghvet.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class UiCadastroFuncionarioController implements Initializable {
	
	@FXML
	private TextField textfield_nome;
	@FXML
	private TextField textfield_cpf;
	@FXML
	private TextField textfield_contato;
	@FXML 
	private TextField textfield_email;
	@FXML
	private DatePicker datepicker_datanascimento;
	@FXML
	private ChoiceBox choicebox_setor;
	@FXML
	private ChoiceBox choicebox_cargo;
	@FXML
	private Button button_salvar;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String[] setores = {"Administrativo", "Auxiliar", "Veterinario"};
        ObservableList<String> items = FXCollections.observableArrayList (setores);
       choicebox_setor.setItems(items);

		
	}
	
	
	public void handler_salvar(){
		IControlFuncionario funcionario = new ControlFuncionario();
		
		switch(choicebox_setor.getValue().toString()){
			case "Administrativo":
				
				
				break;
			case "Auxiliar":
		
				break;
			case "Veterinario":
			
				break;
			
			default:
			
				break;
		}
		
	}

}
