package br.sghvet.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 */
public class UiLoginController implements Initializable{
	
	@FXML
	private AnchorPane login_component;
	@FXML 
	private Button button_entrar;
	@FXML
	private PasswordField passwordfield_senha; 
	@FXML
	private TextField textfield_cpf;
	



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		DropShadow dropShadow = new DropShadow();
		 dropShadow.setRadius(10.0);
		 dropShadow.setOffsetX(1.0);
		 dropShadow.setOffsetY(1.0);
		 dropShadow.setColor(Color.color (0.4, 0.4, 0.4, 0.4));
		 
		 login_component.setEffect(dropShadow);
		
	}
	
	public void handler_entrar(){
		
		
		  IControleLogin login = new ControleLogin();
		try {
			login.loginUsuario(textfield_cpf.getText(), passwordfield_senha.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	 
	 

}
