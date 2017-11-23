package br.sghvet.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.model.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnchorPane_NovoAnimalController implements Initializable{
	
private Stage stage;
private String cpf;
IControlPaciente control;


@FXML
private TextField tx_NomeAnimal;
@FXML
private TextField tx_RacaAnimal;
@FXML
private TextField tx_PelagemAnimal;
@FXML
private TextField tx_PesoAnimal;
@FXML
private TextField tx_IdadeAnimal;
@FXML
private TextField tx_ProntuarioAnimal;



@FXML
private ComboBox<String> cb_SexoAnimal;
private ObservableList<String> listSexoAnimaisCbbx = FXCollections.observableArrayList("Macho","Femia");


	

@Override
public void initialize(URL url, ResourceBundle rb) {
	
	control = new ControlPaciente();	
	tx_ProntuarioAnimal.setEditable(false);
	SetCB() ;
   
}    


public Stage getStage() {
    return stage;
}


public void setStage(Stage stage) {
    this.stage = stage;
}


public void setCPFTUTOR(String cpf) {
	this.cpf = cpf;
	
}

private void SetCB() {
	
	
	cb_SexoAnimal.setItems(listSexoAnimaisCbbx);
	
	
}

public String getCPF() {
	
	return cpf;
}



@FXML
public void handlerSalvarNovoAnimal() { 	
	
	
	Animal a = new Animal(tx_NomeAnimal.getText(), tx_RacaAnimal.getText(), tx_PelagemAnimal.getText(), tx_PesoAnimal.getText(), this.getCPF(), cb_SexoAnimal.getValue(), tx_IdadeAnimal.getText(),"0000");
	try {
		control.cadastrarAnimal(a);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}