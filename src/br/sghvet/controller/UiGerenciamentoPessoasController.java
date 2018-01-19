package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.CargoAdm;
import br.sghvet.model.CargoAuxiliar;
import br.sghvet.model.CargoVeterinario;
import br.sghvet.model.TipoUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UiGerenciamentoPessoasController implements Initializable {

	@FXML
	private Button button_novocadastro;
	@FXML
	private ListView listview_funcionarios;
	@FXML
	private ChoiceBox choicebox_setor;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		ObservableList<TipoUsuario> items = FXCollections.observableArrayList(TipoUsuario.values());
		choicebox_setor.setItems(items);

	}

	public void setLisView() throws Exception {
		switch ((TipoUsuario) choicebox_setor.getValue()) {

		case ADMINISTRATIVO:
			listview_funcionarios.setItems(null);
			ObservableList<Object> adms = FXCollections.observableArrayList(Fachada.getInstance().buscaTodosAdm());
			listview_funcionarios.setItems(adms);
			break;
		case AUXILIAR:
			listview_funcionarios.setItems(null);
			ObservableList<Object> auxs = FXCollections.observableArrayList(Fachada.getInstance().buscaTodosAuxiliar());
			listview_funcionarios.setItems(auxs);

			break;
		case VETERINARIO:
			listview_funcionarios.setItems(null);
			ObservableList<Object> vets = FXCollections
					.observableArrayList(Fachada.getInstance().buscaTodosVeterinario());
			listview_funcionarios.setItems(vets);
			break;
		default:

			break;
		}
	}

	@FXML
	public void handler_NovoCadastro() throws IOException {
		showUiNovoCadastro();

	}

	public void showUiNovoCadastro() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(
				UiCadastroFuncionarioController.class.getResource("../view/fxml_ui_cadastro_funcionario.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage cadastroFuncionario = new Stage();
		cadastroFuncionario.setTitle("Novo Funcionario");
		Scene scene = new Scene(page);
		cadastroFuncionario.setScene(scene);
		// cadastroFuncionario.getIcons().add(new
		// Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
		cadastroFuncionario.setResizable(false);

		UiCadastroFuncionarioController controller = loader.getController();
		controller.setStage(cadastroFuncionario);

		cadastroFuncionario.showAndWait();
	}

}
