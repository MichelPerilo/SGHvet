package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Administrativo;
import br.sghvet.model.Auxiliar;
import br.sghvet.model.CargoAdm;
import br.sghvet.model.CargoAuxiliar;
import br.sghvet.model.CargoVeterinario;
import br.sghvet.model.Cirurgia;
import br.sghvet.model.Consulta;
import br.sghvet.model.TipoUsuario;
import br.sghvet.model.Tutor;
import br.sghvet.model.Veterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UiGerenciamentoCirurgiaController implements Initializable {

	@FXML
	private Button button_novocadastro;


	
	@FXML
    private ScrollPane PN_sp1;
	@FXML
	private TableView<Cirurgia> tv_cirurgia;
	@FXML
	TableColumn <Cirurgia,String> tc_data;
	@FXML
	TableColumn <Cirurgia,String>tc_inicio;
	@FXML
	TableColumn <Cirurgia,String>tc_termino;
	@FXML
	TableColumn <Cirurgia,String>tc_tipo;
	@FXML
	TableColumn <Cirurgia,String>tc_especialidade;
	@FXML
	TableColumn <Cirurgia,String>tc_prontuario;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		try {
			setTvCirurgia();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void setTvCirurgia() throws Exception {
		
		PN_sp1.setVisible(true);
		tc_data.setCellValueFactory(new PropertyValueFactory<>("data"));
		tc_inicio.setCellValueFactory(new PropertyValueFactory<>("hora_inicio"));
		tc_termino.setCellValueFactory(new PropertyValueFactory<>("hora_fim"));
		tc_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tc_especialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
		tc_prontuario.setCellValueFactory(new PropertyValueFactory<>("prontuario_id"));

		
		ObservableList<Cirurgia> cirurgias = FXCollections.observableArrayList(Fachada.getInstance().buscarALLCirurgia());
			tv_cirurgia.setItems(cirurgias);		
					
		
	}
	
	
	
	
	public void clickcirurgia() throws Exception {
		
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(
				UiCadastroFuncionarioController.class.getResource("../view/fxml_ui_cadastro_cirurgia.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage cadastroCirurgia = new Stage();
		cadastroCirurgia.setTitle("Procedimento Cirurgico");
		Scene scene = new Scene(page);
		cadastroCirurgia.setScene(scene);
		// cadastroFuncionario.getIcons().add(new
		// Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
		cadastroCirurgia.setResizable(false);

		UiCadastroCirurgiaController controller = loader.getController();
		controller.setStage(cadastroCirurgia);
		controller.carregarDados((Cirurgia) tv_cirurgia.getSelectionModel().getSelectedItem());
		cadastroCirurgia.showAndWait();
		setTvCirurgia();
		
	}
	


	@FXML
	public void handler_NovoCadastro() throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(
				UiCadastroFuncionarioController.class.getResource("../view/fxml_ui_cadastro_cirurgia.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage cadastroCirurgia = new Stage();
		cadastroCirurgia.setTitle("Procedimento Cirurgico");
		Scene scene = new Scene(page);
		cadastroCirurgia.setScene(scene);
		// cadastroFuncionario.getIcons().add(new
		// Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
		cadastroCirurgia.setResizable(false);

		UiCadastroCirurgiaController controller = loader.getController();
		controller.setStage(cadastroCirurgia);

		cadastroCirurgia.showAndWait();
		setTvCirurgia();
		

	}


}
