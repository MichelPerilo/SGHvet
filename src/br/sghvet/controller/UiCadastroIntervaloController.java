package br.sghvet.controller;

import java.net.URL;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.DiaDaSemana;
import br.sghvet.model.Disponibilidade;
import br.sghvet.model.TipoUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UiCadastroIntervaloController implements Initializable{
	
	@FXML
	private ChoiceBox choicebox_diadasemana;
	@FXML 
	private TextField textfield_inicio;
	@FXML
	private TextField textfield_fim;
	@FXML
	private TextField textfield_cpf;
	
	private LocalTime inicio, fim;

	
	private Stage stage;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		ObservableList<DiaDaSemana> items = FXCollections.observableArrayList (DiaDaSemana.values());
	       choicebox_diadasemana.setItems(items);
		
	}
	
	public void handler_atualizar(){
		
	}
	
	public void handler_salvar() throws Exception{
		IFachada fachada = new Fachada();
		try{
			inicio.parse(textfield_inicio.getText());
			fim.parse(textfield_inicio.getText());
			Disponibilidade disp = new Disponibilidade(inicio, fim, textfield_cpf.getText(), (DiaDaSemana) choicebox_diadasemana.getValue());
			fachada.cadastrarHorario(disp);
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	alert.setHeaderText("Intervalo criado com sucesso");
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
	    	alert.setHeaderText("Erro ao criar intervalo");
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
		
	}
	
	private Stage getStage() {
		return stage;
	}
	void setStage(Stage stage) {
		this.stage = stage;
	}

}
