package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Disponibilidade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UiDisponibilidadeMedicaController implements Initializable {

	@FXML
	private ListView listview_horarios;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		atualizaDsiponibilidade();

	}

	public void atualizaDsiponibilidade() {

		try {
			ObservableList<Disponibilidade> disp;
			disp = FXCollections
					.observableArrayList(Fachada.getInstance().buscaHorarios(Fachada.getInstance().getCpfLogado()));
			listview_horarios.setItems(disp);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@FXML
	public void handler_NovoIntervalo() throws IOException {
		showUiNovoIntervalo();

	}

	public void showUiNovoIntervalo() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(UiCadastroIntervaloController.class.getResource("../view/fxml_ui_cadastro_intervalo.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage cadastroIntervalo = new Stage();
		cadastroIntervalo.setTitle("Novo Intervalo");
		Scene scene = new Scene(page);
		cadastroIntervalo.setScene(scene);
		// cadastroFuncionario.getIcons().add(new
		// Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
		cadastroIntervalo.setResizable(false);

		UiCadastroIntervaloController controller = loader.getController();
		controller.setStage(cadastroIntervalo);

		cadastroIntervalo.showAndWait();
		
		atualizaDsiponibilidade();
	}

}
