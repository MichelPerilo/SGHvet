package br.sghvet.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.model.Consulta;
import br.sghvet.model.ResultadoExame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
	private TextArea textarea_ectoscopia;
	@FXML 
	private TextField textfield_batcardiaco;
	@FXML 
	private TextField textfield_movrespiratorio;
	@FXML 
	private TextField textfield_pulso;
	@FXML 
	private TextField textfield_tr;
	@FXML
	private Button button_salvar;
	
	private Stage stage;
	
	private Consulta consulta;
	
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
		setConsulta(c);
		
	}
	
	public void handlerSalvar() throws Exception{
		
		try{
		
			ResultadoExame registro = new ResultadoExame(consulta.getId(), Float.parseFloat(textfield_tr.getText()), 
					Float.parseFloat(textfield_batcardiaco.getText()), Float.parseFloat(textfield_movrespiratorio.getText()),
					Float.parseFloat(textfield_pulso.getText()), textarea_ectoscopia.getText(), 
					textarea_cabecapescoco.getText(), textarea_cavtoracica.getText(), 
					textarea_cavabdominal.getText(), textarea_sislocomotor.getText(), 
					textarea_sisnervoso.getText(), textarea_diagprovavel.getText(), 
					textarea_examescomple.getText(), textarea_diagdefinitivo.getText(),
					textarea_prognostico.getText(), textarea_vacinacoes.getText(),
					textarea_vermifugacoes.getText());
					
			Fachada.getInstance().cadastrarRegistro(registro);
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText("Dados salvos com sucesso");
			alert.setTitle("Confirmação");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				// ... user chose OK
				alert.close();
				stage.close();

			} else {
				// ... user chose CANCEL or closed the dialog
			}
			
		}catch(NullPointerException e){
			
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Ocorreu um erro ao salvar");
			alert.setTitle("Erro");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				// ... user chose OK
				alert.close();
				stage.close();

			} else {
				// ... user chose CANCEL or closed the dialog
			}
			
		}
		
		
	}

	private Consulta getConsulta() {
		return consulta;
	}

	void setConsulta(Consulta c) {
		this.consulta = c;
	}

}
