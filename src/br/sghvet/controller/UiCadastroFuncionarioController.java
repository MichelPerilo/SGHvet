package br.sghvet.controller;
import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Administrativo;
import br.sghvet.model.Auxiliar;
import br.sghvet.model.CargoAdm;
import br.sghvet.model.CargoAuxiliar;
import br.sghvet.model.CargoVeterinario;
import br.sghvet.model.TipoUsuario;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import br.sghvet.model.Usuario;
import br.sghvet.model.Veterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
	@FXML
	private PasswordField passwordfield_senha;
	@FXML
	private TextField textfield_nomeusuario;
	@FXML
	private TextField textfield_crmv;
	
	
	
	
	private Stage stage;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<TipoUsuario> items = FXCollections.observableArrayList (TipoUsuario.values());
       choicebox_setor.setItems(items);
       
		
	}
	
	public void setCargoList(){
		switch((TipoUsuario) choicebox_setor.getValue()) {
		
			case ADMINISTRATIVO :
				textfield_crmv.setVisible(false);
				 ObservableList<CargoAdm> itemsadm = FXCollections.observableArrayList (CargoAdm.values());
			       choicebox_cargo.setItems(itemsadm);
				break;
			case AUXILIAR :
				textfield_crmv.setVisible(false);
				ObservableList<CargoAuxiliar> itemsauxiliar = FXCollections.observableArrayList (CargoAuxiliar.values());
			       choicebox_cargo.setItems(itemsauxiliar);
				break;
			case VETERINARIO :
				textfield_crmv.setVisible(true);
				ObservableList<CargoVeterinario> itemsveterinario = FXCollections.observableArrayList (CargoVeterinario.values());
			       choicebox_cargo.setItems(itemsveterinario);
				break;
		}
		
	}
	
	public void handler_salvar() throws Exception{
		IFachada fachada = new Fachada();
		

		//reformular para usar fachada

		switch((TipoUsuario)choicebox_setor.getValue()) {
	
			case ADMINISTRATIVO :
				try{
					Usuario user = new Usuario(textfield_cpf.getText(), TipoUsuario.ADMINISTRATIVO);
					fachada.cadastrarUsuario(user, passwordfield_senha.getText());
					Administrativo adm = new Administrativo(textfield_nome.getText(), textfield_cpf.getText(), datepicker_datanascimento.getValue(), (CargoAdm) choicebox_cargo.getValue() , textfield_contato.getText(), textfield_email.getText());
					fachada.cadastraAdm(user, adm);
					
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
			    	alert.setHeaderText("Novo Cadastro Efetuado");
			        alert.setTitle("Confirmação");
			    	
			    	Optional<ButtonType> result = alert.showAndWait();
			    	if (result.get() == ButtonType.OK){
			    	    // ... user chose OK
			    		alert.close();
			    		stage.close();
			    		
			    	} else {
			    	    // ... user chose CANCEL or closed the dialog
			    	}
		    	
				}catch(Exception integrityexception){
					
					Alert alert = new Alert(Alert.AlertType.ERROR);
			    	alert.setHeaderText("Ocorreu um erro na tentatica de cadastro");
			        alert.setTitle("Erro");
			    	
			    	Optional<ButtonType> result = alert.showAndWait();
			    	if (result.get() == ButtonType.OK){
			    	    // ... user chose OK
			    		alert.close();
			    		stage.close();
			    		
			    	} else {
			    	    // ... user chose CANCEL or closed the dialog
			    	}
					
				}
				
				
				break;
			case AUXILIAR :
				try{
				Usuario user = new Usuario(textfield_cpf.getText(), TipoUsuario.AUXILIAR);
				fachada.cadastrarUsuario(user, passwordfield_senha.getText());
				Auxiliar aux = new Auxiliar(textfield_nome.getText(), textfield_cpf.getText(), datepicker_datanascimento.getValue(), (CargoAuxiliar) choicebox_cargo.getValue() , textfield_contato.getText(), textfield_email.getText());
				fachada.cadastrarAuxiliar(user, aux);
				
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    	alert.setHeaderText("Novo Cadastro Efetuado");
		        alert.setTitle("Confirmação");
		    	
		    	Optional<ButtonType> result = alert.showAndWait();
		    	if (result.get() == ButtonType.OK){
		    	    // ... user chose OK
		    		alert.close();
		    		stage.close();
		    		
		    	} else {
		    	    // ... user chose CANCEL or closed the dialog
		    	}
		    	
				}catch(Exception integrityexception){
					
					Alert alert = new Alert(Alert.AlertType.ERROR);
			    	alert.setHeaderText("Ocorreu um erro na tentatica de cadastro");
			        alert.setTitle("Erro");
			    	
			    	Optional<ButtonType> result = alert.showAndWait();
			    	if (result.get() == ButtonType.OK){
			    	    // ... user chose OK
			    		alert.close();
			    		stage.close();
			    		
			    	} else {
			    	    // ... user chose CANCEL or closed the dialog
			    	}
					
				} 
		
				break;
			case VETERINARIO :
				try{
					Usuario user = new Usuario(textfield_cpf.getText(), TipoUsuario.VETERINARIO);
					fachada.cadastrarUsuario(user, passwordfield_senha.getText());
					 Veterinario vet = new Veterinario(textfield_nome.getText(), textfield_cpf.getText(), datepicker_datanascimento.getValue(), (CargoVeterinario) choicebox_cargo.getValue() , textfield_contato.getText(), textfield_email.getText(), textfield_crmv.getText());
					fachada.cadastrarVeterinario(user, vet);
					
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
			    	alert.setHeaderText("Novo Cadastro Efetuado");
			        alert.setTitle("Confirmação");
			    	
			    	Optional<ButtonType> result = alert.showAndWait();
			    	if (result.get() == ButtonType.OK){
			    	    // ... user chose OK
			    		alert.close();
			    		stage.close();
			    		
			    	} else {
			    	    // ... user chose CANCEL or closed the dialog
			    	}
			    	
					}catch(Exception integrityexception){
						
						Alert alert = new Alert(Alert.AlertType.ERROR);
				    	alert.setHeaderText("Ocorreu um erro na tentatica de cadastro");
				        alert.setTitle("Erro");
				    	
				    	Optional<ButtonType> result = alert.showAndWait();
				    	if (result.get() == ButtonType.OK){
				    	    // ... user chose OK
				    		alert.close();
				    		stage.close();
				    		
				    	} else {
				    	    // ... user chose CANCEL or closed the dialog
				    	}
						
					} 
			
				break;
			
			default:
			
				break;
		}
		
	}


	public void setStage(Stage novoFuncionarioStage) {
		// TODO Auto-generated method stub
		this.stage = novoFuncionarioStage;
		
	}


	private Stage getStage() {
		return stage;
	}
	

}
