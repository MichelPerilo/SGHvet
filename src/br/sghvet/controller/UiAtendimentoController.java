package br.sghvet.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.model.Consulta;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UiAtendimentoController implements Initializable {
	
	@FXML
	private Label label_data_consulta;
	@FXML
	private Label label_horario_consulta;
	@FXML
	private Label label_id_consulta;
	@FXML
	private Label label_nome_paciente;
	@FXML
	private Label label_nome_tutor;
	@FXML 
	private TextArea textarea_cabecapescoco;
	@FXML 
	private TextArea textarea_cavabdominal;
	@FXML 
	private TextArea textarea_cavtoracica;
	@FXML 
	private TextArea textarea_diagdefinitivo;
	@FXML 
	private TextArea textarea_diagprovavel;
	@FXML 
	private TextArea textarea_examescomple;
	@FXML 
	private TextArea textarea_prognostico;
	@FXML 
	private TextArea textarea_sislocomotor;
	@FXML 
	private TextArea textarea_sisnervoso;
	@FXML 
	private TextArea textarea_vacinacoes;
	@FXML 
	private TextArea textarea_vermifugacoes;
	@FXML 
	private TextField textfield_batcardiaco;
	@FXML 
	private TextField textfield_movrespiratorio;
	@FXML 
	private TextField textfield_pulso;
	@FXML 
	private TextField textfield_tr;
	
	private Stage stage;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	private Stage getStage() {
		return stage;
	}
	 

	void setStage(Stage stage) {
		this.stage = stage;
	}
	
	void setDados(Consulta c){
		
		label_data_consulta.setText(c.getDia().toString());
		label_horario_consulta.setText(c.getHorario().toString());
		label_id_consulta.setText(Integer.toString(c.getId()));
		label_nome_paciente.setText(c.getNomeAnimal());
		label_nome_tutor.setText(c.getNomeTutor()); 
	}

}
