package br.sghvet.controller;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.model.DiaDaSemana;
import br.sghvet.model.Disponibilidade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UiCadastroIntervaloController implements Initializable {

	@FXML
	private ChoiceBox choicebox_diadasemana;
	@FXML
	private TextField textfield_inicio;
	@FXML
	private TextField textfield_fim;

	private Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ObservableList<DiaDaSemana> items = FXCollections.observableArrayList(DiaDaSemana.values());
		choicebox_diadasemana.setItems(items);

	}
	
	public void handlerCadastrarHorario() {
		String inicio[] = textfield_inicio.getText().split(":");
		String fim[] = textfield_fim.getText().split(":");
		String dia = choicebox_diadasemana.getSelectionModel().getSelectedItem().toString();
		
		try {
			Fachada.getInstance().cadastrarHorario(new Disponibilidade(LocalTime.of(Integer.parseInt(inicio[0]),Integer.parseInt(inicio[1])),
					LocalTime.of(Integer.parseInt(fim[0]), Integer.parseInt(fim[1])), Fachada.getInstance().getCpfLogado(), DiaDaSemana.valueOf(dia.toUpperCase())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Stage getStage() {
		return stage;
	}

	void setStage(Stage stage) {
		this.stage = stage;
	}

}
