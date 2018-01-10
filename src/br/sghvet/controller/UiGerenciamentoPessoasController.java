package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UiGerenciamentoPessoasController implements Initializable{

	@FXML
	private Button button_novocadastro;
	@FXML
	private ListView listview_funcionarios;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		/*
		ObservableList<Object> items = FXCollections.observableArrayList ();
		listview_funcionarios.setItems(arg0);
		*/
		
	}
	
	@FXML
	public void handler_NovoCadastro() throws IOException{
		showUiNovoCadastro();
	    
	}
	
	    
	 public void showUiNovoCadastro() throws IOException{
		 FXMLLoader loader = new FXMLLoader();
	     loader.setLocation(UiCadastroFuncionarioController.class.getResource("../view/fxml_ui_cadastro_funcionario.fxml"));
	     AnchorPane page = (AnchorPane) loader.load();
	     Stage cadastroFuncionario = new Stage();
	     cadastroFuncionario.setTitle("Novo Funcionario");
	     Scene scene = new Scene(page);
	     cadastroFuncionario.setScene(scene);
	     //cadastroFuncionario.getIcons().add(new Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
	     cadastroFuncionario.setResizable(false);
	        
	     UiCadastroFuncionarioController controller = loader.getController();
	     controller.setStage(cadastroFuncionario);
	        
	     cadastroFuncionario.showAndWait();
	 }

}
