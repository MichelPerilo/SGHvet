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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UiCadastroIntervaloController implements Initializable {

	@FXML
	private ChoiceBox choicebox_diadasemana;
	@FXML
	private TextField textfield_inicio;
	@FXML
	private TextField textfield_fim;
	@FXML
	private ComboBox<String> cb_HInicio;
	@FXML
	private ComboBox<String> cb_Hr_Fim;
	@FXML
	private Button btnFecharCencelar;

	private Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ObservableList<DiaDaSemana> items = FXCollections.observableArrayList(DiaDaSemana.values());
		choicebox_diadasemana.setItems(items);
		ObservableList<String> horas = FXCollections.observableArrayList("07:00", "08:00", "09:00", "10:00", "11:00",
				"12:00", "14:00", "15:00", "16:00");
		
		cb_HInicio.setItems(horas);		
		cb_Hr_Fim.setItems(horas);
	}

	public void handlerCadastrarHorario() {
		String inicio[] = cb_HInicio.getValue().split(":");
		
		String fim[] = cb_Hr_Fim.getValue().split(":");
		String dia = choicebox_diadasemana.getSelectionModel().getSelectedItem().toString();

		try {
			Fachada.getInstance().cadastrarHorario(
					new Disponibilidade(LocalTime.of(Integer.parseInt(inicio[0]), Integer.parseInt(inicio[1])),
							LocalTime.of(Integer.parseInt(fim[0]), Integer.parseInt(fim[1])),
							Fachada.getInstance().getCpfLogado(), DiaDaSemana.valueOf(dia)));
			
			btnFecharCencelar.getScene().getWindow().hide();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Stage getStage() {
		return stage;
	}

	void setStage(Stage stage) {
		this.stage = stage;
		this.stage.initStyle(StageStyle.UNDECORATED);

	}

	@FXML
	public void fechar() {
		btnFecharCencelar.getScene().getWindow().hide();
	}

}
