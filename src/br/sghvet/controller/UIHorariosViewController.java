package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.facade.IFachada;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UIHorariosViewController implements Initializable {

	private Stage stage;

	Alert alert = new Alert(AlertType.WARNING);

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
		this.stage.initStyle(StageStyle.UNDECORATED);
	}

	

}
