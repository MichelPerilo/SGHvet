package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UiDisponibilidadeMedicaController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void handler_NovoIntervalo() throws IOException{
		showUiNovoIntervalo();
	    
	}
	
	    
	 public void showUiNovoIntervalo() throws IOException{
		 FXMLLoader loader = new FXMLLoader();
	     loader.setLocation(UiCadastroIntervaloController.class.getResource("../view/fxml_ui_cadastro_intervalo.fxml"));
	     AnchorPane page = (AnchorPane) loader.load();
	     Stage cadastroIntervalo = new Stage();
	     cadastroIntervalo.setTitle("Novo Intervalo");
	     Scene scene = new Scene(page);
	     cadastroIntervalo.setScene(scene);
	     //cadastroFuncionario.getIcons().add(new Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
	     cadastroIntervalo.setResizable(false);
	        
	     UiCadastroIntervaloController controller = loader.getController();
	     controller.setStage(cadastroIntervalo);
	        
	     cadastroIntervalo.showAndWait();
	 }

}
