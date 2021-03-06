package br.sghvet.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Animal;
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

public class UINovoAnimalController implements Initializable {

	private Stage stage;
	private String cpf;
	Alert alert = new Alert(AlertType.WARNING);


	@FXML
	private TextField tx_NomeAnimal;
	@FXML
	private TextField tx_Especie;
	@FXML
	private TextField tx_RacaAnimal;
	@FXML
	private TextField tx_PelagemAnimal;
	@FXML
	private TextField tx_PesoAnimal;
	@FXML
	private TextField tx_IdadeAnimal;
	@FXML
	private Button btnFecharCadastroAnimal;
	@FXML
	private ComboBox<String> cb_SexoAnimal;
	private ObservableList<String> listSexoAnimaisCbbx = FXCollections.observableArrayList("M","F");

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		try {

			SetCB();
			Fachada.getInstance().carregarAgendamento();
			
			

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	@FXML
	public void fechar() {
    	btnFecharCadastroAnimal.getScene().getWindow().hide();
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
		this.stage.initStyle(StageStyle.UNDECORATED);
	}

	public void setCPFTUTOR(String cpf) {

		this.cpf = cpf;

	}

	public String getCPF() {

		return cpf;
	}

	private void SetCB() {

		cb_SexoAnimal.setItems(listSexoAnimaisCbbx);

	}

	@FXML
	public void handlerSalvarNovoAnimal() {

		Animal a = new Animal(tx_NomeAnimal.getText(), tx_Especie.getText(), cb_SexoAnimal.getValue(),
				Integer.parseInt(tx_IdadeAnimal.getText()), getCPF(), tx_RacaAnimal.getText(),
				tx_PelagemAnimal.getText(), Double.parseDouble(tx_PesoAnimal.getText()));

		try {
			Fachada.getInstance().cadastrarAnimal(a);
			alert.setHeaderText("ANIMAL CADASTRADO COM SUCESSO");
			alert.showAndWait();

			tx_NomeAnimal.setEditable(false);
			tx_Especie.setEditable(false);
			cb_SexoAnimal.setEditable(false);
			tx_IdadeAnimal.setEditable(false);
			tx_RacaAnimal.setEditable(false);
			tx_PelagemAnimal.setEditable(false);
			tx_PesoAnimal.setEditable(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
