package br.sghvet.controller;
import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Administrativo;
import br.sghvet.model.CargoAdm;
import br.sghvet.model.TipoUsuario;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import br.sghvet.model.Usuario;
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
	
	
	
	
	private Stage stage;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<TipoUsuario> items = FXCollections.observableArrayList (TipoUsuario.values());
       choicebox_setor.setItems(items);
       
       choicebox_cargo.hide();

		
	}
	
	public void setCargoList(){
		switch(choicebox_setor.getValue().toString()) {
		
			case "ADMINISTRATIVO":
				 ObservableList<CargoAdm> items = FXCollections.observableArrayList (CargoAdm.values());
			       choicebox_cargo.setItems(items);
				break;
		}
		
	}
	
	public void handler_salvar() throws Exception{
		IFachada fachada = new Fachada();
		

		//reformular para usar fachada

		switch(choicebox_setor.getValue().toString()) {
	
			case "ADMINISTRATIVO":
				try{
					Usuario user = new Usuario(textfield_cpf.getText(), TipoUsuario.ADMINISTRATIVO);
					fachada.cadastrarUsuario(user, passwordfield_senha.getText());
					Administrativo adm = new Administrativo(textfield_nome.getText(), textfield_cpf.getText(), datepicker_datanascimento.getValue(), CargoAdm.ATENDENTE, textfield_contato.getText(), textfield_email.getText());
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
			case "AUXILIAR":
		
				break;
			case "VETERINARIO":
			
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
