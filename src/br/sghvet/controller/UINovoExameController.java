package br.sghvet.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Animal;
import br.sghvet.model.RequisicaoExame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UINovoExameController implements Initializable {

	@FXML
	private ComboBox<String> cb_nomeAnimal;
	private ObservableList<String> listnomeAnimal;
	@FXML
	private TextField tx_cpftutor;
	@FXML
	private Button btnFecharCencelar;
	@FXML
	private Button btnSalvar;
	@FXML
	private Button btnbuscar;	
	@FXML
	private Label lb_prontuario;
	@FXML
    private DatePicker dt_data;
	
	Alert alert = new Alert(AlertType.WARNING);
	private Stage stage;
	private String cpfMedico;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	
	@FXML
	public void fechar() {
		btnFecharCencelar.getScene().getWindow().hide();
	}
	
	public Stage getStage() {
		return stage;
	}

	
	public void setStage(Stage stage) {
		this.stage = stage;
		this.stage.initStyle(StageStyle.UNDECORATED);
	}
	
	@FXML
	public void handlerPesquisar() throws Exception {

		if (tx_cpftutor.getText() != null && !tx_cpftutor.getText().equals(""))
			AtualizaAnimais(tx_cpftutor.getText());

	}

	
	public void AtualizaAnimais(String cpf) {

		try {

			List<Animal> listA = pegaAnimais(cpf);
			List<String> nomesA = new ArrayList<>();

			for (Animal animal : listA) {

				nomesA.add(animal.getNome());
			}

			listnomeAnimal = FXCollections.observableArrayList(nomesA);
			cb_nomeAnimal.setItems(listnomeAnimal);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List pegaAnimais(String cpf) {

		List<Animal> list = new ArrayList<>();

		try {

			list = Fachada.getInstance().buscarAnimal(cpf);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}
	
	@FXML
	public void handlerEscolheAnimal() {

		try {

			if (tx_cpftutor.getText() != null && !tx_cpftutor.getText().equals("")) {
				List<Animal> listA = pegaAnimais(tx_cpftutor.getText());

				for (Animal animal : listA) {

					if (cb_nomeAnimal.getValue().equals(animal.toString())) {

						lb_prontuario.setText(Long.toString(animal.getNumProntuario()));
					}

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@FXML
	public void salvar() {
		
		LocalDate ld = dt_data.getValue();
		RequisicaoExame rq =  new RequisicaoExame(ld, tx_cpftutor.getText(), Integer.parseInt(lb_prontuario.getText()), Fachada.getInstance().getCpfLogado(), true);
		
	try {
		Fachada.getInstance().cadastraReqExame(rq);
		Fachada.getInstance().gerarPdfRequisicao(rq);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	}


	public String getCpfMedico() {
		return cpfMedico;
	}


	public void setCpfMedico(String cpfMedico) {
		this.cpfMedico = cpfMedico;
	}
	
	
}
