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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UiCadastroFuncionarioController implements Initializable {
	

	@FXML
	public TextField textfield_nome;
	@FXML
	public TextField textfield_cpf;
	@FXML
	public TextField textfield_contato;
	@FXML
	public TextField textfield_email;
	@FXML
	public DatePicker datepicker_datanascimento;
	@FXML
	public ChoiceBox choicebox_setor;
	@FXML
	public ChoiceBox choicebox_cargo;
	@FXML
	protected Button button_salvar;
	@FXML
	public PasswordField passwordfield_senha;
	@FXML
	protected TextField textfield_nomeusuario;
	@FXML
	public TextField textfield_crmv;
	@FXML
	public Label label_titulo;
	@FXML
	private Button button_salvar2;
	@FXML
	private Label label_senha;
	
	
	
	private Stage stage;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<TipoUsuario> items = FXCollections.observableArrayList (TipoUsuario.values());
       getChoicebox_setor().setItems(items);
       
		
	}
	
	public void setCargoList(){
		switch((TipoUsuario) getChoicebox_setor().getValue()) {
		
			case ADMINISTRATIVO :
				getTextfield_crmv().setVisible(false);
				 ObservableList<CargoAdm> itemsadm = FXCollections.observableArrayList (CargoAdm.values());
			       getChoicebox_cargo().setItems(itemsadm);
				break;
			case AUXILIAR :
				getTextfield_crmv().setVisible(false);
				ObservableList<CargoAuxiliar> itemsauxiliar = FXCollections.observableArrayList (CargoAuxiliar.values());
			       getChoicebox_cargo().setItems(itemsauxiliar);
				break;
			case VETERINARIO :
				getTextfield_crmv().setVisible(true);
				ObservableList<CargoVeterinario> itemsveterinario = FXCollections.observableArrayList (CargoVeterinario.values());
			       getChoicebox_cargo().setItems(itemsveterinario);
				break;
		}
		
	}
	
	public void handler_fechar(){
		this.stage.close();
	}
	
	public void handler_atualizar(){
		IFachada fachada = new Fachada();
		
		switch((TipoUsuario)getChoicebox_setor().getValue()) {
		
		case ADMINISTRATIVO :
			try{
				/*Usuario user = new Usuario(getTextfield_cpf().getText(), TipoUsuario.ADMINISTRATIVO);
				fachada.atualizarUsuario(user);*/
				Administrativo adm = new Administrativo(getTextfield_nome().getText(), getTextfield_cpf().getText(), getDatepicker_datanascimento().getValue(), (CargoAdm) getChoicebox_cargo().getValue() , getTextfield_contato().getText(), getTextfield_email().getText());
				fachada.atualizaAdm(adm);
				
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    	alert.setHeaderText("Dados atualizados com sucesso");
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
		    	alert.setHeaderText("Erro ao atualizar dados");
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
			/*Usuario user = new Usuario(getTextfield_cpf().getText(), TipoUsuario.AUXILIAR);
			fachada.atualizarUsuario(user);*/
			Auxiliar aux = new Auxiliar(getTextfield_nome().getText(), getTextfield_cpf().getText(), getDatepicker_datanascimento().getValue(), (CargoAuxiliar) getChoicebox_cargo().getValue() , getTextfield_contato().getText(), getTextfield_email().getText());
			fachada.atualizarAuxiliar(aux);
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	alert.setHeaderText("Dados atualizados com sucesso");
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
		    	alert.setHeaderText("Erro ao atualizar dados");
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
				/*Usuario user = new Usuario(getTextfield_cpf().getText(), TipoUsuario.VETERINARIO);
				fachada.atualizarUsuario(user);*/
				 Veterinario vet = new Veterinario(getTextfield_nome().getText(), getTextfield_cpf().getText(), getDatepicker_datanascimento().getValue(), (CargoVeterinario) getChoicebox_cargo().getValue() , getTextfield_contato().getText(), getTextfield_email().getText(), getTextfield_crmv().getText());
				fachada.atualizarVeterinario(vet);
				
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    	alert.setHeaderText("Dados atualizados com sucesso");
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
			    	alert.setHeaderText("Erro ao atualizar dados");
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
	
	
	public void handler_salvar() throws Exception{
		IFachada fachada = new Fachada();
		

		//reformular para usar fachada

		switch((TipoUsuario)getChoicebox_setor().getValue()) {
	
			case ADMINISTRATIVO :
				try{
					Usuario user = new Usuario(getTextfield_cpf().getText(), TipoUsuario.ADMINISTRATIVO);
					fachada.cadastrarUsuario(user, getPasswordfield_senha().getText());
					Administrativo adm = new Administrativo(getTextfield_nome().getText(), getTextfield_cpf().getText(), getDatepicker_datanascimento().getValue(), (CargoAdm) getChoicebox_cargo().getValue() , getTextfield_contato().getText(), getTextfield_email().getText());
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
				Usuario user = new Usuario(getTextfield_cpf().getText(), TipoUsuario.AUXILIAR);
				fachada.cadastrarUsuario(user, getPasswordfield_senha().getText());
				Auxiliar aux = new Auxiliar(getTextfield_nome().getText(), getTextfield_cpf().getText(), getDatepicker_datanascimento().getValue(), (CargoAuxiliar) getChoicebox_cargo().getValue() , getTextfield_contato().getText(), getTextfield_email().getText());
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
					Usuario user = new Usuario(getTextfield_cpf().getText(), TipoUsuario.VETERINARIO);
					fachada.cadastrarUsuario(user, getPasswordfield_senha().getText());
					 Veterinario vet = new Veterinario(getTextfield_nome().getText(), getTextfield_cpf().getText(), getDatepicker_datanascimento().getValue(), (CargoVeterinario) getChoicebox_cargo().getValue() , getTextfield_contato().getText(), getTextfield_email().getText(), getTextfield_crmv().getText());
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
	
		this.stage = novoFuncionarioStage;
		this.stage.initStyle(StageStyle.UNDECORATED);
		
		
	}


	private Stage getStage() {
		return stage;
	}

	protected TextField getTextfield_nome() {
		return textfield_nome;
	}

	protected void setTextfield_nome(TextField textfield_nome) {
		this.textfield_nome = textfield_nome;
	}

	protected TextField getTextfield_cpf() {
		return textfield_cpf;
	}

	protected void setTextfield_cpf(TextField textfield_cpf) {
		this.textfield_cpf = textfield_cpf;
	}

	protected TextField getTextfield_contato() {
		return textfield_contato;
	}

	protected void setTextfield_contato(TextField textfield_contato) {
		this.textfield_contato = textfield_contato;
	}

	protected TextField getTextfield_email() {
		return textfield_email;
	}

	protected void setTextfield_email(TextField textfield_email) {
		this.textfield_email = textfield_email;
	}

	protected DatePicker getDatepicker_datanascimento() {
		return datepicker_datanascimento;
	}

	protected void setDatepicker_datanascimento(DatePicker datepicker_datanascimento) {
		this.datepicker_datanascimento = datepicker_datanascimento;
	}

	protected ChoiceBox getChoicebox_setor() {
		return choicebox_setor;
	}

	protected void setChoicebox_setor(ChoiceBox choicebox_setor) {
		this.choicebox_setor = choicebox_setor;
	}

	protected ChoiceBox getChoicebox_cargo() {
		return choicebox_cargo;
	}

	protected void setChoicebox_cargo(ChoiceBox choicebox_cargo) {
		this.choicebox_cargo = choicebox_cargo;
	}

	protected PasswordField getPasswordfield_senha() {
		return passwordfield_senha;
	}

	protected void setPasswordfield_senha(PasswordField passwordfield_senha) {
		this.passwordfield_senha = passwordfield_senha;
	}

	protected TextField getTextfield_crmv() {
		return textfield_crmv;
	}

	protected void setTextfield_crmv(TextField textfield_crmv) {
		this.textfield_crmv = textfield_crmv;
	}

	public Label getLabel_titulo() {
		return label_titulo;
	}

	public void setLabel_titulo(Label label_titulo) {
		this.label_titulo = label_titulo;
	}

	protected Button getButton_salvar2() {
		return button_salvar2;
	}

	protected void setButton_salvar2(Button button_salvar2) {
		this.button_salvar2 = button_salvar2;
	}

	public Label getLabel_senha() {
		return label_senha;
	}

	public void setLabel_senha(Label label_senha) {
		this.label_senha = label_senha;
	}
	

}
