package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.model.Administrativo;
import br.sghvet.model.Consulta;
import br.sghvet.model.Veterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UiAtendimentosDoDiaController implements Initializable{
	

	@FXML
	private DatePicker datepicker_data;
	@FXML
	private TableView<Consulta> tableview_atendimentos;
	@FXML
	TableColumn <Consulta,String> tablecolumn_horario;
	@FXML
	TableColumn <Consulta,String> tablecolumn_paciente;
	@FXML
	TableColumn <Consulta,String> tablecolumn_tutor;
	

    @FXML
    private Label lb_idConsulta_Farmaco;
    @FXML
    private Pane pn_Consulta_Farmaco;
    @FXML
    private Label lb_Nome_Farmaco;
    @FXML
    private Button bt_newSolicitation;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		datepicker_data.setValue(LocalDate.now());
		
		try {
			setTableView(LocalDate.now());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setDatePicker() throws Exception{
		setTableView(datepicker_data.getValue());
	}
	
	public void setTableView(LocalDate data) throws Exception{
		tablecolumn_horario.setCellValueFactory(new PropertyValueFactory<>("horario"));
		tablecolumn_paciente.setCellValueFactory(new PropertyValueFactory<>("nomeAnimal"));
		tablecolumn_tutor.setCellValueFactory(new PropertyValueFactory<>("nomeTutor"));
		

		
		ObservableList<Consulta> consultas = FXCollections.observableArrayList(Fachada.getInstance().buscarConsultasDoDia(Fachada.getInstance().getCpfLogado(), data));
		
		tableview_atendimentos.setItems(consultas);
	}
	
	public void tableViewClick() throws IOException{
		pn_Consulta_Farmaco.setVisible(false);
		Consulta c =  tableview_atendimentos.getSelectionModel().getSelectedItem();
		showAtendimento(c);
	}
	
	public void showAtendimento(Consulta c) throws IOException{
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(	UiAtendimentoController.class.getResource("../view/fxml_ui_atendimento.fxml"));
		ScrollPane page = (ScrollPane) loader.load();
		Stage atendimento = new Stage();
		Scene scene = new Scene(page);
		atendimento.setScene(scene);
		atendimento.setResizable(false);
		UiAtendimentoController controller = loader.getController();
		controller.setStage(atendimento);
		controller.setDados(c);
		
		atendimento.showAndWait();
		
		pn_Consulta_Farmaco.setVisible(true);
		lb_idConsulta_Farmaco.setText(String.valueOf(c.getId()));
		lb_Nome_Farmaco.setText(c.getNomeAnimal());
		
		try {
			setTableView(datepicker_data.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void solicitaFarmaco() throws IOException{
		
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(	UIRequisicaoFarmacoController.class.getResource("../view/fxml_requisicao_farmaco.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage solicitaFarma = new Stage();
		Scene scene = new Scene(page);
		solicitaFarma.setScene(scene);
		solicitaFarma.setResizable(false);
		UIRequisicaoFarmacoController controller = loader.getController();
		controller.setStage(solicitaFarma);
		controller.setIDconsultaNewRequisição(Integer.parseInt(lb_idConsulta_Farmaco.getText()));
				
		solicitaFarma.showAndWait();
		bt_newSolicitation.setDisable(true);
		bt_newSolicitation.setText("SOLICITAÇÃO REALIZADA COM SUCESSO");
		
		
	}

}
