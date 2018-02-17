package br.sghvet.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.model.Cirurgia;
import br.sghvet.model.RequisicaoExame;
import br.sghvet.model.TipoExame;
import br.sghvet.model.TipoUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UiGerenciamentoExameController implements Initializable{

	
	@FXML
    private ScrollPane PN_sp1;
	@FXML
	private TableView<RequisicaoExame> tv_exame;
	@FXML
	TableColumn <RequisicaoExame,String> tc_tipo;
	@FXML
	TableColumn <RequisicaoExame,String>tc_hora;
	@FXML
	TableColumn <RequisicaoExame,String>tc_data;
	@FXML
	TableColumn <RequisicaoExame,String>tc_obs;
	@FXML
	TableColumn <RequisicaoExame,String>tc_vet;
	@FXML
	TableColumn <RequisicaoExame,String>tc_prontuario;
	@FXML
	TableColumn <RequisicaoExame,String>tc_natureza;
	
	
	@FXML
	private ComboBox combobox_tipo;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		ObservableList<Object> items = FXCollections.observableArrayList(TipoExame.values());
		combobox_tipo.setItems(items);
		
		
	}
	
	
	public void setTipo() throws Exception{
			switch ((TipoExame) combobox_tipo.getValue()) {

			case IMAGEM:
				setTvExameImg();
					
				break;
			case LABORATORIAL:
				
				setTvExameLab();

				break;
			default:

				break;
			}
		}
	
	
	
	private void setTvExameImg() throws Exception {
		PN_sp1.setVisible(true);
		
		tc_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tc_hora.setCellValueFactory(new PropertyValueFactory<>("hora"));
		tc_data.setCellValueFactory(new PropertyValueFactory<>("data"));
		tc_obs.setCellValueFactory(new PropertyValueFactory<>("observacoes"));
		tc_vet.setCellValueFactory(new PropertyValueFactory<>("cpf_vet"));
		tc_prontuario.setCellValueFactory(new PropertyValueFactory<>("prontuario"));
		tc_natureza.setCellValueFactory(new PropertyValueFactory<>("natureza"));

		

		
		ObservableList<RequisicaoExame> exames = FXCollections.observableArrayList(Fachada.getInstance().buscarALLExameImagem());
			tv_exame.setItems(exames);		
		
	}


	public void setTvExameLab() throws Exception {
		
		PN_sp1.setVisible(true);
		
		tc_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tc_hora.setCellValueFactory(new PropertyValueFactory<>("hora"));
		tc_data.setCellValueFactory(new PropertyValueFactory<>("data"));
		tc_obs.setCellValueFactory(new PropertyValueFactory<>("observacoes"));
		tc_vet.setCellValueFactory(new PropertyValueFactory<>("cpf_vet"));
		tc_prontuario.setCellValueFactory(new PropertyValueFactory<>("prontuario"));
		tc_natureza.setCellValueFactory(new PropertyValueFactory<>("natureza"));

		

		
		ObservableList<RequisicaoExame> exames = FXCollections.observableArrayList(Fachada.getInstance().buscarALLExameLab());
			tv_exame.setItems(exames);		
					
	}
	
	@FXML
	public void handler_NovoCadastro() throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(
				UiCadastroExameController.class.getResource("../view/fxml_ui_cadastro_exame.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage cadastroexame = new Stage();
		cadastroexame.setTitle("Exame");
		Scene scene = new Scene(page);
		cadastroexame.setScene(scene);
		// cadastroFuncionario.getIcons().add(new
		// Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
		cadastroexame.setResizable(false);

		UiCadastroExameController controller = loader.getController();
		controller.setStage(cadastroexame);

		cadastroexame.showAndWait();
		setTvExameLab();
		setTvExameImg();
		

	}
	
	@FXML
	public void clickExame() throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(
				UiCadastroExameController.class.getResource("../view/fxml_ui_cadastro_exame.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage cadastroexame = new Stage();
		cadastroexame.setTitle("Exame");
		Scene scene = new Scene(page);
		cadastroexame.setScene(scene);
		// cadastroFuncionario.getIcons().add(new
		// Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
		cadastroexame.setResizable(false);

		UiCadastroExameController controller = loader.getController();
		controller.setStage(cadastroexame);
		controller.carregarDados((RequisicaoExame) tv_exame.getSelectionModel().getSelectedItem());

		cadastroexame.showAndWait();
		setTvExameLab();
		setTvExameImg();
		

	}



}
