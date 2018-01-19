package br.sghvet.controller;

import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Administrativo;
import br.sghvet.model.CargoAdm;
import br.sghvet.model.TipoUsuario;
import br.sghvet.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
			
			 Usuario  user = Fachada.getInstance().loginUsuario(textfield_cpf.getText(), passwordfield_senha.getText());
			 
			switch(user.getTipo()){
			
				case ADMINISTRATIVO:
					
					if((Fachada.getInstance().buscaAdm(user.getCpf()).getCargo()) == CargoAdm.ATENDENTE) {
						
//						AnchorPane  secretaria = (AnchorPane) FXMLLoader.load(getClass().getResource("../view/fxml_Agendamento.fxml"));
//						anchorpane_principal.getChildren().setAll(secretaria);
						
						
						
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(UIAgendamentoController.class.getResource("../view/fxml_Agendamento.fxml"));
						AnchorPane page;
						page = (AnchorPane) loader.load();
						Stage stage = new Stage();
						stage.setTitle("Secretaria");
						Scene scene = new Scene(page);
						stage.setScene(scene);
						UIAgendamentoController controller = loader.getController();
						controller.setCpfLogado(textfield_cpf.getText());
						controller.setStage(stage);
						stage.showAndWait();
										
						
						
					}else {
					
					AnchorPane anchorpane_administrativo = (AnchorPane) FXMLLoader.load(getClass().getResource("../view/fxml_ui_administrativo.fxml"));
				    anchorpane_principal.getChildren().setAll(anchorpane_administrativo);
					}
					
					break;
					
				case VETERINARIO:
					AnchorPane anchorpane_clinico = (AnchorPane) FXMLLoader.load(getClass().getResource("../view/fxml_ui_clinico.fxml"));
				    anchorpane_principal.getChildren().setAll(anchorpane_clinico);
					
					break;
				case AUXILIAR:
					
					
					break; 
					
				default:
								
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	 
	 
	 

}
