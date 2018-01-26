package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UiClinicoController implements Initializable {

	@FXML
	private AnchorPane anchorpane_info;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void handler_AtendimentosDoDia() throws IOException {
		AnchorPane anchorpane_atendimentos_do_dia = (AnchorPane) FXMLLoader
				.load(getClass().getResource("../view/fxml_ui_atendimentos_do_dia.fxml"));
		anchorpane_info.getChildren().setAll(anchorpane_atendimentos_do_dia);

	}

	public void handler_DisponibilidadeMedica() throws IOException {
		AnchorPane anchorpane_disponibilidade_medica = (AnchorPane) FXMLLoader
				.load(getClass().getResource("../view/fxml_ui_disponibilidade_medica.fxml"));
		anchorpane_info.getChildren().setAll(anchorpane_disponibilidade_medica);

	}

	@FXML
	public void handlerMarcacaoExame() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(UINovoExameController.class.getResource("../view/fxml_marcacao_Exame.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();
			Stage novoStage = new Stage();
			Scene scene = new Scene(page);
			novoStage.setScene(scene);
			novoStage.setResizable(false);
			UINovoExameController controller = loader.getController();
			controller.setStage(novoStage);
			novoStage.showAndWait();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
