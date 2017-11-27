package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class UiAdministrativoController implements Initializable {
	
	@FXML
	private AnchorPane anchorpane_info;
	private Button button_gerenciamentopessoas;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void handler_gerencimaentopessoas() throws IOException{
		AnchorPane anchorpane_gerenciamentopessoas = (AnchorPane) FXMLLoader.load(getClass().getResource("../view/fxml_ui_gerenciamento_pessoas.fxml"));
	    anchorpane_info.getChildren().setAll(anchorpane_gerenciamentopessoas);
	    
	}
	
	

}
