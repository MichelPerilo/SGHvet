package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class UIModoAdministradorController implements Initializable {

	@FXML
	private AnchorPane achorPrincioal;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void handler_ADMINISTRATIVO() throws IOException {

		AnchorPane anchorpane_administrativo = (AnchorPane) FXMLLoader
				.load(getClass().getResource("../view/fxml_ui_administrativo.fxml"));
		achorPrincioal.getChildren().setAll(anchorpane_administrativo);

	}

	public void handler_ATENDENTE() throws IOException {

		AnchorPane secretaria = (AnchorPane) FXMLLoader.load(getClass().getResource("../view/fxml_Agendamento.fxml"));
		achorPrincioal.getChildren().setAll(secretaria);

	}

	public void handler_CLINICO() throws IOException {

		AnchorPane anchorpane_clinico = (AnchorPane) FXMLLoader
				.load(getClass().getResource("../view/fxml_ui_clinico.fxml"));
		achorPrincioal.getChildren().setAll(anchorpane_clinico);

	}

	public void handler_CIRURGIAO() {

		//

	}

	public void handler_LABORATORIO() {

		//

	}

	public void handler_FARMACIA() throws IOException {

		AnchorPane anchorpane_farmacia = (AnchorPane) FXMLLoader
				.load(getClass().getResource("../view/fxml_Farmaco.fxml"));
		achorPrincioal.getChildren().setAll(anchorpane_farmacia);

	}

}
