package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class UiClinicoController implements Initializable{
	@FXML
	private AnchorPane anchorpane_info;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void handler_AtendimentosDoDia() throws IOException{
		AnchorPane anchorpane_atendimentos_do_dia = (AnchorPane) FXMLLoader.load(getClass().getResource("../view/fxml_ui_atendimentos_do_dia.fxml"));
	    anchorpane_info.getChildren().setAll(anchorpane_atendimentos_do_dia);
	    
	}
}
