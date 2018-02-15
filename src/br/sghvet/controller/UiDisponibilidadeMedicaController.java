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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UiDisponibilidadeMedicaController implements Initializable {

	@FXML
	private ListView<Disponibilidade> listview_horarios;
	@FXML
	private Button bt_atualizar;

	@FXML
	private Button bt_deletar;

	private Disponibilidade disp;

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
		Scene scene = new Scene(page);
		cadastroIntervalo.setScene(scene);
		cadastroIntervalo.setResizable(false);

		UiCadastroIntervaloController controller = loader.getController();
		controller.setStage(cadastroIntervalo);

		cadastroIntervalo.showAndWait();

		atualizaDsiponibilidade();
	}

	@FXML
	public void handler_AtualizaIntervalo() throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(UiCadastroIntervaloController.class.getResource("../view/fxml_ui_cadastro_intervalo.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage cadastroIntervalo = new Stage();
		Scene scene = new Scene(page);
		cadastroIntervalo.setScene(scene);
		cadastroIntervalo.setResizable(false);

		UiCadastroIntervaloController controller = loader.getController();
		controller.setStage(cadastroIntervalo);
		controller.setDisp(disp);

		cadastroIntervalo.showAndWait();

		atualizaDsiponibilidade();
		bt_atualizar.setVisible(false);
		bt_deletar.setVisible(false);

	}

	@FXML
	public void clickerIntem() {

		disp = listview_horarios.getSelectionModel().getSelectedItem();
		bt_atualizar.setVisible(true);
		bt_deletar.setVisible(true);
	}
	
	@FXML
	public void handler_DeletarIntervalo() throws IOException {
		
		try {
			Fachada.getInstance().deletarHorario(disp);
			bt_atualizar.setVisible(false);
			bt_deletar.setVisible(false);
			atualizaDsiponibilidade();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
