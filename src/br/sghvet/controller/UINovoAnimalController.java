package br.sghvet.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.DatePicker;
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
	private ComboBox<String> cb_Especie;
	@FXML
	private ComboBox<String> cb_RacaAnimal;
	@FXML
	private ComboBox<String> cb_PelagemAnimal;
	private ObservableList<String> listPelagemAnimalCbbx = FXCollections.observableArrayList("Dupla pelagem",
			"Peculiares", "Dura", "Arame", "Curto", "Longo", "Longo sedoso sem ondulações");
	@FXML
	private TextField tx_PesoAnimal;
	@FXML
	private DatePicker  dt_IdadeAnimal;
	@FXML
	private Button btnFecharCadastroAnimal;
	@FXML
	private ComboBox<String> cb_SexoAnimal;
	private ObservableList<String> listSexoAnimaisCbbx = FXCollections.observableArrayList("M", "F");

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		try {

			SetCB();
			Fachada.getInstance().carregarAgendamento();
			AtualizaEspecie();

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
		cb_PelagemAnimal.setItems(listPelagemAnimalCbbx);

	}

	@FXML
	public void handlerSalvarNovoAnimal() {

		Animal a = new Animal(dt_IdadeAnimal.getValue(), tx_NomeAnimal.getText(), cb_Especie.getValue(), cb_SexoAnimal.getValue(),
				 getCPF(), cb_RacaAnimal.getValue(),
				cb_PelagemAnimal.getValue(), Double.parseDouble(tx_PesoAnimal.getText()));

		try {
			Fachada.getInstance().cadastrarAnimal(a);
			alert.setHeaderText("ANIMAL CADASTRADO COM SUCESSO");
			alert.showAndWait();

			tx_NomeAnimal.setEditable(false);
			cb_Especie.setEditable(false);
			cb_SexoAnimal.setEditable(false);
			dt_IdadeAnimal.setEditable(false);
			cb_RacaAnimal.setEditable(false);
			cb_PelagemAnimal.setEditable(false);
			tx_PesoAnimal.setEditable(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}
