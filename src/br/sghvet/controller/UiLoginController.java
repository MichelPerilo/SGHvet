package br.sghvet.controller;

import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Administrativo;
import br.sghvet.model.CargoAdm;
import br.sghvet.model.TipoUsuario;
import br.sghvet.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
	@FXML
	private AnchorPane anchorpane_principal;
	



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
		
		 
		  
		try {
			
			 IFachada fachada = new Fachada();
			 fachada.conectar();
			 Usuario  user = fachada.loginUsuario(textfield_cpf.getText(), passwordfield_senha.getText());
			 
			switch(user.getTipo()){
			
				case ADMINISTRATIVO:
					
					if(user.getCargo() == CargoAdm.ATENDENTE) {
						
						AnchorPane  secretaria = (AnchorPane) FXMLLoader.load(getClass().getResource("../view/fxml_Agendamento.fxml"));
						anchorpane_principal.getChildren().setAll(secretaria);
					}else {
					
					AnchorPane anchorpane_administrativo = (AnchorPane) FXMLLoader.load(getClass().getResource("../view/fxml_ui_administrativo.fxml"));
				    anchorpane_principal.getChildren().setAll(anchorpane_administrativo);
					}
					
					break;
					
				default:
								
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	 
	 
	 

}
