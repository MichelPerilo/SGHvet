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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
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
	}

}
