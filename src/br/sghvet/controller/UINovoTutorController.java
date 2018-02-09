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
import javafx.stage.StageStyle;

public class UINovoTutorController implements Initializable {

	private Stage stage;
	Alert alert = new Alert(AlertType.WARNING);

	// Cadastro Tutor

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
	private ComboBox<String> cb_SexoTutor;
	@FXML
	private ComboBox<String> cb_Estado;

	@FXML
	private Button btSalvarCadastroTutor;

	@FXML
	private Button btnFecharCadastroTutor;

	// Cadastro Animal

	@FXML
	private ComboBox<String> cb_Sexo;

	// Animal

	@FXML
	private TextField tx_NomeAnimal;
	@FXML
	private ComboBox<String> cb_Especie;
	@FXML
	private ComboBox<String> cb_RacaAnimal;
	@FXML
	private ComboBox<String> cb_PelagemAnimal;
	private ObservableList<String> listPelagemAnimalCbbx = FXCollections.observableArrayList("Dupla pelagem",
			"Peculiares", "Dura", "Arame", "Curto", "Longo", "Longo sedoso sem ondulações");
	@FXML
	private TextField tx_Peso;
	@FXML
	private TextField tx_Idade;

	private ObservableList<String> listEstadosCbbx = FXCollections.observableArrayList("AC", "AL", "AP", "AM", "BA",
			"CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR",
			"SC", "SP", "SE", "TO");
	private ObservableList<String> listSexoAnimaisCbbx = FXCollections.observableArrayList("M", "F");
	private ObservableList<String> listSexoTutorCbbx = FXCollections.observableArrayList("M", "F");

	@FXML
	private Button btSalvarCadastroTutorAnimal;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		try {

			Fachada.getInstance().carregarAgendamento();
			AtualizaEspecie();

		} catch (Exception e) {

			e.printStackTrace();
		}

		SetCB();

	}

	@FXML
	public void fechar() {
		btnFecharCadastroTutor.getScene().getWindow().hide();
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
		this.stage.initStyle(StageStyle.UNDECORATED);
	}
	
	
	public void AtualizaEspecie() {

		try {

			ObservableList<String> listEsp = FXCollections
					.observableArrayList(Fachada.getInstance().buscarALLEspeciel());
			cb_Especie.setItems(listEsp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void AtualizaRaca() {
		
		cb_RacaAnimal.setItems(null);
		try {

			if (cb_Especie.getValue().equals("CACHORRO")) {
				ObservableList<String> listC = FXCollections.observableArrayList(Fachada.getInstance().buscarRaca(1));
				cb_RacaAnimal.setItems(listC);
			}

			if (cb_Especie.getValue().equals("GATO")) {
				ObservableList<String> listG = FXCollections.observableArrayList(Fachada.getInstance().buscarRaca(2));
				cb_RacaAnimal.setItems(listG);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@FXML
	public void handlerNovoAnimal() {

		tx_NomeAnimal.setText("");
		tx_Peso.setText("");
		tx_Idade.setText("");
	
		cb_Sexo.setEditable(true);
		tx_NomeAnimal.setEditable(true);
		cb_RacaAnimal.setEditable(true);
		cb_Especie.setEditable(true);
		cb_PelagemAnimal.setEditable(true);
		tx_Peso.setEditable(true);
		tx_Idade.setEditable(true);

	}

	@FXML
	public void handlerSalvarNovoAnimal() {

		Animal a = new Animal(tx_NomeAnimal.getText(), cb_Especie.getValue(), cb_Sexo.getValue(),
				Integer.parseInt(tx_Idade.getText()), tx_CPF.getText(), cb_RacaAnimal.getValue(), cb_PelagemAnimal.getValue(),
				Double.parseDouble(tx_Peso.getText()));
		cb_Sexo.setEditable(false);
		tx_NomeAnimal.setEditable(false);
		cb_Especie.setEditable(false);
		cb_RacaAnimal.setEditable(false);
		cb_PelagemAnimal.setEditable(false);
		tx_Peso.setEditable(false);
		tx_Idade.setEditable(false);
		try {

			Fachada.getInstance().cadastrarAnimal(a);
			alert.setHeaderText("ANIMAL SALVO COM SUCESSO");
			alert.showAndWait();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void handlerSalvarNovoTutor() {

		try {
			Endereco end = new Endereco(tx_Rua.getText(), tx_Bairro.getText(), tx_CEP.getText(), tx_Numero.getText(),
					tx_Complemento.getText(), tx_Cidade.getText(), cb_Estado.getValue(), tx_CPF.getText());
			Tutor t = new Tutor(tx_NomeTutor.getText(), tx_CPF.getText(), cb_SexoTutor.getValue(), tx_Celular.getText(),
					end);

			Fachada.getInstance().cadastrarTutor(t);
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
			alert.setHeaderText(e.getMessage());
			alert.showAndWait();
		}

	}

	private void SetCB() {

		cb_Estado.setItems(listEstadosCbbx);
		cb_Sexo.setItems(listSexoAnimaisCbbx);
		cb_SexoTutor.setItems(listSexoTutorCbbx);
		cb_PelagemAnimal.setItems(listPelagemAnimalCbbx);

	}

}
