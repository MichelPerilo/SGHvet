package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UiClinicoController implements Initializable {

	@FXML
	private AnchorPane anchorpane_info;
	@FXML
	private Button logoff;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
	
	
	@FXML
	public void logoff() {
		try {

			Stage stageCLose = (Stage) logoff.getScene().getWindow(); // Obtendo a janela atual
			stageCLose.close(); // Fechando o Stage
			Fachada.getInstance().desconectar();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(UiLoginController.class.getResource("../view/fxml_ui_login.fxml"));
			VBox page = (VBox) loader.load();
			Stage TelaInicial = new Stage();
			Scene scene = new Scene(page);
			TelaInicial.setScene(scene);
			UiLoginController controller = loader.getController();
			controller.setStage(TelaInicial);
			TelaInicial.showAndWait();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	
	public void handler_TutorxAnimal() throws IOException{
		AnchorPane anchorpane_tutorxanimal = (AnchorPane) FXMLLoader
				.load(getClass().getResource("../view/fxml_ui_tabela_tutorxanimal.fxml"));
		anchorpane_info.getChildren().setAll(anchorpane_tutorxanimal);

	}
	
	public void handler_AnimalxConsulta() throws IOException{
		AnchorPane anchorpane_animalxconsulta = (AnchorPane) FXMLLoader
				.load(getClass().getResource("../view/fxml_ui_tabela_animalxconsulta.fxml"));
		anchorpane_info.getChildren().setAll(anchorpane_animalxconsulta);
	}
	
	public void handler_CirurgiaxEquipe() throws IOException{
		AnchorPane anchorpane_cirurgiaxequipe = (AnchorPane) FXMLLoader
				.load(getClass().getResource("../view/fxml_ui_tabela_cirurgiaxequipe.fxml"));
		anchorpane_info.getChildren().setAll(anchorpane_cirurgiaxequipe);
	}
	
	public void handler_Cirurgia() throws IOException{
		AnchorPane anchorpane_cirurgia = (AnchorPane) FXMLLoader
				.load(getClass().getResource("../view/fxml_ui_gerenciamento_cirurgia.fxml"));
		anchorpane_info.getChildren().setAll(anchorpane_cirurgia);
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
