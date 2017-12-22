package br.sghvet.controller;


import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Animal;
import br.sghvet.model.Endereco;
import br.sghvet.model.Tutor;
import exceptions.ConectionException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class UINovoTutorController  implements Initializable{

	private Stage stage;
	IFachada control; 	
	Alert alert = new Alert(AlertType.WARNING);

	
//	Cadastro Tutor
	
	@FXML
	private TextField tx_NomeTutor;
	@FXML
	private TextField tx_CPF;
	@FXML
	private TextField tx_Celular;
	@FXML
	private TextField tx_Rua;
	@FXML
	private TextField tx_Numero;
	@FXML
	private TextField tx_Complemento;
	@FXML
	private TextField tx_Bairro;
	@FXML
	private TextField tx_CEP;
	@FXML
	private TextField tx_Cidade;
	
	@FXML
	private ComboBox<String > cb_SexoTutor;	
	@FXML
	private ComboBox<String> cb_Estado;
			
	@FXML
	private Button	btSalvarCadastroTutor;
	
	
//	Cadastro Animal
		
	@FXML
    private ComboBox<String> cb_Sexo;
	
	
//	Animal
	
	@FXML
	private TextField tx_NomeAnimal;
	@FXML
	private TextField tx_Especie;
	@FXML
	private TextField tx_Raca;
	@FXML
	private TextField tx_Pelagem;
	@FXML
	private TextField tx_Peso;
	@FXML
	private TextField tx_Idade;   
    
    
  
    
    
    private ObservableList<String> listEstadosCbbx = FXCollections.observableArrayList("AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO");
    private ObservableList<String> listSexoAnimaisCbbx = FXCollections.observableArrayList("M","F");
    private ObservableList<String> listSexoTutorCbbx = FXCollections.observableArrayList("M","F");
    


    @FXML
    private Button btSalvarCadastroTutorAnimal;  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	
    	
    	try {
    		
			control = new Fachada();
			control.carregarAgendamento();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}    
    	
    	
    	SetCB() ;
 	
       
    }    

   
    public Stage getStage() {
        return stage;
    }

    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
	
   
    @FXML
    public void handlerNovoAnimal() {
    	
    	
    	
    	
    	tx_NomeAnimal.setText("");	
    	tx_Raca.setText("");
    	tx_Pelagem.setText("");
    	tx_Peso.setText("");
    	tx_Idade.setText("");
    	tx_Especie.setText("");
    	  
    	
    	cb_Sexo.setEditable(true);
    	tx_NomeAnimal.setEditable(true);	
    	tx_Raca.setEditable(true);
    	tx_Especie.setEditable(true);
    	tx_Pelagem.setEditable(true);
    	tx_Peso.setEditable(true);
    	tx_Idade.setEditable(true);
    	
        	       	     
    }
    
    
    @FXML
    public void handlerSalvarNovoAnimal() { 	
    	
    	
    	Animal a = new Animal(tx_NomeAnimal.getText(), tx_Especie.getText(),cb_Sexo.getValue(),Integer.parseInt(tx_Idade.getText()), tx_CPF.getText(),tx_Raca.getText(),tx_Pelagem.getText(),Double.parseDouble(tx_Peso.getText()));
    	cb_Sexo.setEditable(false);
    	tx_NomeAnimal.setEditable(false);	
    	tx_Especie.setEditable(false);
    	tx_Raca.setEditable(false);
    	tx_Pelagem.setEditable(false);
    	tx_Peso.setEditable(false);
    	tx_Idade.setEditable(false);
    	try {
			    	
	    	control.cadastrarAnimal(a);
	    	alert.setHeaderText("ANIMAL SALVO COM SUCESSO");
		    alert.showAndWait();
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @FXML
    private void handlerSalvarNovoTutor() {    	
    	
    	Endereco end = new Endereco(tx_Rua.getText(), tx_Bairro.getText(),tx_CEP.getText(),tx_Numero.getText(),tx_Complemento.getText(),tx_Cidade.getText(),cb_Estado.getValue(),tx_CPF.getText());
    	Tutor t = new Tutor(tx_NomeTutor.getText(), tx_CPF.getText(), cb_SexoTutor.getValue(), tx_Celular.getText(), end);
    	try {
			
    		control.cadastrarTutor(t);
    		alert.setHeaderText("TUTOR SALVO COM SUCESSO");
		    alert.showAndWait();
    		tx_NomeTutor.setEditable(false);
    		tx_CPF.setEditable(false);
    		tx_Celular.setEditable(false);
    		tx_Rua.setEditable(false);
    		tx_Numero.setEditable(false);
    		tx_Complemento.setEditable(false);
    		tx_Bairro.setEditable(false);
    		tx_CEP.setEditable(false);
    		tx_Cidade.setEditable(false);
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   	
    	
    }
    
    private void SetCB() {
    	
    	cb_Estado.setItems(listEstadosCbbx);
    	cb_Sexo.setItems(listSexoAnimaisCbbx);
    	cb_SexoTutor.setItems(listSexoTutorCbbx);
    	
    }  
       
    
}
