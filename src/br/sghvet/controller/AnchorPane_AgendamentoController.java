package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AnchorPane_AgendamentoController implements Initializable {

	@FXML
	private Button ButtonPesquisar;
	@FXML
	private Button btNovoTutor;
	@FXML
	private Button ButtonVoltarTutor;
	@FXML
	private Button btSalvarNovoAnimal;
	@FXML
	private Pane PN_Tutor;
	@FXML
	private Pane PN_Agendamento;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	public void handlerNovoTutor() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AnchorPane_NovoTutorController.class.getResource("../view/fxml_NewTutor.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();
			Stage novoTutor = new Stage();
			novoTutor.setTitle("Novo Cadastro");
			Scene scene = new Scene(page);
			novoTutor.setScene(scene);
			novoTutor.setResizable(false);
			AnchorPane_NovoTutorController controller = loader.getController();
			controller.setStage(novoTutor);
			novoTutor.showAndWait();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void handlerNovoAnimal() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AnchorPane_NovoAnimalController.class.getResource("../view/fxml_NewAnimal.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();
			Stage novoAnimal = new Stage();
			novoAnimal.setTitle("Novo Cadastro");
			Scene scene = new Scene(page);
			novoAnimal.setScene(scene);
			// novoTutor.getIcons().add(new
			// Image(getClass().getResourceAsStream("../assets/imgs/simgeh.png")));
			novoAnimal.setResizable(false);

			AnchorPane_NovoAnimalController controller = loader.getController();
			controller.setStage(novoAnimal);

			novoAnimal.showAndWait();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void handlerPesquisar() {

		PN_Agendamento.setVisible(false);
		PN_Tutor.setVisible(true);

	}

	@FXML
	public void handlerVoltarTutor() {

		PN_Agendamento.setVisible(true);
		PN_Tutor.setVisible(false);
	}

}
