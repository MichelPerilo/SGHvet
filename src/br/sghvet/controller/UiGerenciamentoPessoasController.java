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

public class UiGerenciamentoPessoasController implements Initializable {

	@FXML
	private Button button_novocadastro;
	@FXML
	private ComboBox<TipoUsuario> cb_tipo;
	@FXML
	private javafx.scene.control.Label lb_Funcionario;

//    Administrativo
	
	@FXML
    private ScrollPane PN_sp1;
	@FXML
	private TableView<Administrativo> tv_funcionarios;
	@FXML
	TableColumn <Administrativo,String> tccpfFunc;
	@FXML
	TableColumn <Administrativo,String>tcnome;
	@FXML
	TableColumn <Administrativo,String>tcsetor;
	@FXML
	TableColumn <Administrativo,String>tcemail;
	@FXML
	TableColumn <Administrativo,String>tccont;	
	
//	Auxiliar
	
	@FXML
    private ScrollPane PN_sp2;
	@FXML
	private TableView<Auxiliar> tv_funcionarios2;
	@FXML
	TableColumn <Auxiliar,String> tccpfFunc2;
	@FXML
	TableColumn <Auxiliar,String>tcnome2;
	@FXML
	TableColumn <Auxiliar,String>tcsetor2;
	@FXML
	TableColumn <Auxiliar,String>tcemail2;
	@FXML
	TableColumn <Auxiliar,String>tccont2;	
	
//	veterinario
	
	@FXML
    private ScrollPane PN_sp3;
	
	@FXML
	private TableView<Veterinario> tv_funcionarios3;
	@FXML
	TableColumn <Veterinario,String> tccpfFunc3;
	@FXML
	TableColumn <Veterinario,String>tcnome3;
	@FXML
	TableColumn <Veterinario,String>tcsetor3;
	@FXML
	TableColumn <Veterinario,String>tcemail3;
	@FXML
	TableColumn <Veterinario,String>tccont3;	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	


		try {
			lb_Funcionario.setText(Fachada.getInstance().buscaAdm(Fachada.getInstance().getCpfLogado()).getNome());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObservableList<TipoUsuario> items = FXCollections.observableArrayList(TipoUsuario.values());
		cb_tipo.setItems(items);

	}

	public void setFiltro() throws Exception {
		switch ((TipoUsuario) cb_tipo.getValue()) {

		case ADMINISTRATIVO:
			carregaTBADM();
				
			break;
		case AUXILIAR:
			
			carregaTBAUX();

			break;
		case VETERINARIO:

			carregaVET();
			
			break;
		default:

			break;
		}
	}
	
	
	public void carregaTBADM() {
		
		PN_sp1.setVisible(true);
		PN_sp2.setVisible(false);
		PN_sp3.setVisible(false);
		tccpfFunc.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tcnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tcsetor.setCellValueFactory(new PropertyValueFactory<>("setor"));
		tcemail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tccont.setCellValueFactory(new PropertyValueFactory<>("contato"));

		
		ObservableList<Administrativo> adms;
		try {
			adms = FXCollections.observableArrayList(Fachada.getInstance().buscaTodosAdm());
			tv_funcionarios.setItems(adms);		
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void carregaTBAUX() {
		
		PN_sp1.setVisible(false);
		PN_sp2.setVisible(true);
		PN_sp3.setVisible(false);
		tccpfFunc2.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tcnome2.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tcsetor2.setCellValueFactory(new PropertyValueFactory<>("setor"));
		tcemail2.setCellValueFactory(new PropertyValueFactory<>("email"));
		tccont2.setCellValueFactory(new PropertyValueFactory<>("contato"));

		
		try {
			ObservableList<Auxiliar> aux = FXCollections.observableArrayList(Fachada.getInstance().buscaTodosAuxiliar());
			tv_funcionarios2.setItems(aux);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
	public void carregaVET() {
		
		PN_sp1.setVisible(false);
		PN_sp2.setVisible(false);
		PN_sp3.setVisible(true);
		tccpfFunc3.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tcnome3.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tcsetor3.setCellValueFactory(new PropertyValueFactory<>("setor"));
		tcemail3.setCellValueFactory(new PropertyValueFactory<>("email"));
		tccont3.setCellValueFactory(new PropertyValueFactory<>("contato"));			
		try {
			ObservableList<Veterinario> vet = FXCollections.observableArrayList(Fachada.getInstance().buscaTodosVeterinario());
			tv_funcionarios3.setItems(vet);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	@FXML
	public void clicarMouseItemListViewFuncionario() throws IOException {
		
	TipoUsuario tp = null;
		
		switch ((TipoUsuario) cb_tipo.getValue()) {

		case ADMINISTRATIVO:
			
			Administrativo adm = tv_funcionarios.getSelectionModel().getSelectedItem();
			abrirPNView(tp.ADMINISTRATIVO ,adm);
			carregaTBADM();
			break;
		case AUXILIAR:
			
			Auxiliar aux = tv_funcionarios2.getSelectionModel().getSelectedItem();
			abrirPNView(tp.AUXILIAR ,aux);
			carregaTBAUX();
			break;
		case VETERINARIO:

			Veterinario vet = tv_funcionarios3.getSelectionModel().getSelectedItem();
			abrirPNView(tp.VETERINARIO ,vet);
			carregaVET();

			break;
		default:

			break;
		}
		
	
	}
	
	public void abrirPNView(TipoUsuario tp, Object obj) throws IOException {
		
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(	UiCadastroFuncionarioController.class.getResource("../view/fxml_ui_cadastro_funcionario.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage Funcionario = new Stage();
		Scene scene = new Scene(page);
		Funcionario.setScene(scene);
		Funcionario.setResizable(false);
		UiCadastroFuncionarioController controller = loader.getController();
		controller.carregaDados(tp, obj);
		controller.setStage(Funcionario);

		Funcionario.showAndWait();
		
	}
	
	
	
	


	@FXML
	public void handler_NovoCadastro() throws IOException {
		
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
		carregaTBADM();
		carregaTBAUX();
		carregaVET();

	}

	
}
