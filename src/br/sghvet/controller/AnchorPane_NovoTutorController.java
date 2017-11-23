package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.model.Animal;
import br.sghvet.model.Endereco;
import br.sghvet.model.Tutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPane_NovoTutorController  implements Initializable{

	private Stage stage;
	IControlPaciente control; 	

	
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
	private Button btNovoAnimal;
	
	@FXML
	private ComboBox<String> cb_NomeAnimais;
	@FXML
    private ComboBox<String> cb_Sexo;
	
	@FXML
	private TextField tx_NomeAnimal;	
	@FXML
	private TextField tx_ProntuarioCadastroTutor;
	@FXML
	private TextField tx_Raca;
	@FXML
	private TextField tx_Pelagem;
	@FXML
	private TextField tx_Peso;
	@FXML
	private TextField tx_Idade;   
    
    
    @FXML
    private Button btSalvarCadastroTutorAnimal;    
    
    
    private ObservableList<String> listEstadosCbbx = FXCollections.observableArrayList("AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO");
    private ObservableList<String> listSexoAnimaisCbbx = FXCollections.observableArrayList("Macho","Femia");
    private ObservableList<String> listSexoTutorCbbx = FXCollections.observableArrayList("M","F");


    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	
    	
    	control = new ControlPaciente();    
    	cb_NomeAnimais.setEditable(false);
    	cb_Sexo.setEditable(false);
    	tx_NomeAnimal.setEditable(false);	
    	tx_ProntuarioCadastroTutor.setEditable(false);
    	tx_Raca.setEditable(false);
    	tx_Pelagem.setEditable(false);
    	tx_Peso.setEditable(false);
    	tx_Idade.setEditable(false);
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
    	
    	cb_NomeAnimais.setEditable(true);
    	
    	
    	tx_NomeAnimal.setText("");	
    	tx_ProntuarioCadastroTutor.setText("");
    	tx_Raca.setText("");
    	tx_Pelagem.setText("");
    	tx_Peso.setText("");
    	tx_Idade.setText("");
    	  
    	
    	cb_Sexo.setEditable(true);
    	tx_NomeAnimal.setEditable(true);	
    	tx_ProntuarioCadastroTutor.setEditable(true);
    	tx_Raca.setEditable(true);
    	tx_Pelagem.setEditable(true);
    	tx_Peso.setEditable(true);
    	tx_Idade.setEditable(true);
    	
        	       	     
    }
    
    
    @FXML
    public void handlerSalvarNovoAnimal() { 	
    	
    	
    	Animal a = new Animal(tx_NomeAnimal.getText(), tx_Raca.getText(), tx_Pelagem.getText(), tx_Peso.getText(), tx_CPF.getText(), cb_Sexo.getValue(), tx_Idade.getText(),"0000");
    	
    }
    
    
    @FXML
    private void handlerSalvarNovoTutor() {    	
    	
    	Endereco end = new Endereco(tx_Rua.getText(), tx_Bairro.getText(),tx_CEP.getText(),tx_Numero.getText(),tx_Complemento.getText(),tx_Cidade.getText(),cb_Estado.getValue(),tx_CPF.getText());
    	Tutor t = new Tutor(tx_NomeTutor.getText(), tx_CPF.getText(), cb_SexoTutor.getValue(), tx_Numero.getText(), end);
    	try {
			
    		control.cadastrarTutor(t);
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
