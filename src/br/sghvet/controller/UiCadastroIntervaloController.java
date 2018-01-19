package br.sghvet.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.model.DiaDaSemana;
import br.sghvet.model.TipoUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UiCadastroIntervaloController implements Initializable{
	
	@FXML
	private ChoiceBox choicebox_diadasemana;
	@FXML 
	private TextField textfield_inicio;
	@FXML
	private TextField textfield_fim;

	
	private Stage stage;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		ObservableList<DiaDaSemana> items = FXCollections.observableArrayList (DiaDaSemana.values());
	       choicebox_diadasemana.setItems(items);
		
	}
	private Stage getStage() {
		return stage;
	}
	void setStage(Stage stage) {
		this.stage = stage;
	}

}
