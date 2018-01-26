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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UiAdministrativoController implements Initializable {

	@FXML
	private AnchorPane anchorpane_info;
	private Button button_gerenciamentopessoas;
	@FXML
	private Button bt_logoff;
	@FXML
	private ImageView img_boasvindas;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
//		animacao() ;
	}

	public void handler_GerenciamentoPessoas() throws IOException {
		AnchorPane anchorpane_gerenciamentopessoas = (AnchorPane) FXMLLoader
				.load(getClass().getResource("../view/fxml_ui_gerenciamento_pessoas.fxml"));
		anchorpane_info.getChildren().setAll(anchorpane_gerenciamentopessoas);

	}
	
	@FXML
	public void logoff() {
		try {

			Stage stageCLose = (Stage) bt_logoff.getScene().getWindow(); // Obtendo a janela atual
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
	
	
	public void animacao() {
		long i = 0;
		
		while(i <100000000) {
			++i;
		}
		
		img_boasvindas.setVisible(false);	
		
	}

}
