package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.sghvet.model.Animal;
import br.sghvet.model.Tutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AnchorPane_AgendamentoController implements Initializable {

	IControlPaciente control;

	
	@FXML
	private Pane pn_Tutor;
	@FXML
	private Pane pn_Agendamento;
	
	
//	Painel Agenda
	
	@FXML
	private TextField tx_BuscarTutor;
	@FXML
	private Label lb_PNTutorNOME;


	@FXML
	private TableView<Tutor> tv_PaneAgendamento;
	@FXML
	private TableColumn<Tutor, String> tc_AgendamentoID;
	@FXML
	private TableColumn<Tutor, String> tc_AgendamentoCPF;
	@FXML
	private TableColumn<Tutor, String> tc_AgendamentoNome;
	@FXML
	private TableColumn<Tutor, String> tc_AgendamentoTelefone;

	private ObservableList<Tutor> observableListTutor;

	// Painel Tutor

	@FXML
	private Label lb_PN_Nome;
	@FXML
	private Label lb_PN_Numero;
	@FXML
	private Label lb_PN_CPF;
	@FXML
	private Label lb_PN_Rua;
	@FXML
	private Label lb_PN_Bairro;
	@FXML
	private Label lb_PN_Cidade;
	
	
//	Painel Tutor Dados
	
	@FXML
	private TextField tx_PNTutorDados_Nome;
	@FXML
	private TextField tx_PNTutorDados_CPF;
	@FXML
	private TextField tx_PNTutorDados_Celular;
	@FXML
	private TextField tx_PNTutorDados_Sexo;
	@FXML
	private TextField tx_PNTutorDados_Rua;
	@FXML
	private TextField tx_PNTutorDados_Numero;
	@FXML
	private TextField tx_PNTutorDados_Complemento;
	@FXML
	private TextField tx_PNTutorDados_Bairro;
	@FXML
	private TextField tx_PNTutorDados_CEP;
	@FXML
	private TextField tx_PNTutorDados_Cidade;
	@FXML
	private TextField tx_PNTutorDados_Estado;
	
//	Painel Tutor Aniamal
	
	
	@FXML
	private TextField tx_PNTutorAnimais_Nome;
	@FXML
	private TextField tx_PNTutorAnimais_Idade;
	@FXML
	private TextField tx_PNTutorAnimais_Raca;
	@FXML
	private TextField tx_PNTutorAnimais_Especie;
	@FXML
	private TextField tx_PNTutorAnimais_Peso;
	@FXML
	private TextField tx_PNTutorAnimais_Pelagem;
	@FXML
	private TextField tx_PNTutorAnimais_Sexo;
	
	
//	@FXML
//	private ComboBox<String> cb_PNTutorAnimais_Animal;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		control = new ControlPaciente();
		carregarTableViewTutor();

	}

	public void carregarTableViewTutor() {

		tc_AgendamentoID.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		tc_AgendamentoCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tc_AgendamentoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tc_AgendamentoTelefone.setCellValueFactory(new PropertyValueFactory<>("contato"));

		try {
			observableListTutor = FXCollections.observableArrayList(control.buscarALLTutor());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tv_PaneAgendamento.setItems(observableListTutor);
	}

	@FXML
	public void handlerNovoTutor() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AnchorPane_NovoTutorController.class.getResource("../view/fxml_NewTutor.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();
			Stage novoTutor = new Stage();
			novoTutor.setTitle("Novo Cadastro");
			Scene scene = new Scene(page);
			novoTutor.setScene(scene);
			novoTutor.setResizable(false);
			AnchorPane_NovoTutorController controller = loader.getController();
			controller.setStage(novoTutor);
			novoTutor.showAndWait();
			carregarTableViewTutor();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void handlerNovoAnimal() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AnchorPane_NovoAnimalController.class.getResource("../view/fxml_NewAnimal.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();
			Stage novoAnimal = new Stage();
			novoAnimal.setTitle("Novo Cadastro");
			Scene scene = new Scene(page);
			novoAnimal.setScene(scene);
			novoAnimal.setResizable(false);
			AnchorPane_NovoAnimalController controller = loader.getController();
			controller.setStage(novoAnimal);
			controller.setCPFTUTOR(lb_PN_CPF.getText()); 
			novoAnimal.showAndWait();
			carregarTableViewTutor();

		} catch (IOException e) {
			// TODO Auto-generated catch block0
			e.printStackTrace();
		}

	}

	@FXML
	public void handlerPesquisar() throws Exception {

		pn_Agendamento.setVisible(false);
		pn_Tutor.setVisible(true);
//
		Tutor t = control.buscarTutor(tx_BuscarTutor.getText());
		
		lb_PNTutorNOME.setText(t.getNome());
		lb_PN_Nome.setText(t.getNome());
		lb_PN_Numero.setText(t.getContato());
		lb_PN_CPF.setText(t.getCpf());
		lb_PN_Rua.setText(t.getEndereco().getLogradouro());
		lb_PN_Bairro.setText(t.getEndereco().getBairro());
		lb_PN_Cidade.setText(t.getEndereco().getCidade());
		
		
		tx_PNTutorDados_Nome.setEditable(false);
		tx_PNTutorDados_CPF.setEditable(false);
		tx_PNTutorDados_Celular.setEditable(false);
		tx_PNTutorDados_Sexo.setEditable(false);
		tx_PNTutorDados_Rua.setEditable(false);
		tx_PNTutorDados_Numero.setEditable(false);
		tx_PNTutorDados_Complemento.setEditable(false);
		tx_PNTutorDados_Bairro.setEditable(false);
		tx_PNTutorDados_CEP.setEditable(false);
		tx_PNTutorDados_Cidade.setEditable(false);
		tx_PNTutorDados_Estado.setEditable(false);
		
		tx_PNTutorDados_Nome.setText(t.getNome());
		tx_PNTutorDados_CPF.setText(t.getCpf());
		tx_PNTutorDados_Celular.setText(t.getContato());
		tx_PNTutorDados_Sexo.setText(t.getSexo());
		tx_PNTutorDados_Rua.setText(t.getEndereco().getLogradouro());
		tx_PNTutorDados_Numero.setText(t.getEndereco().getNumero());
		tx_PNTutorDados_Complemento.setText(t.getEndereco().getComplemento());
		tx_PNTutorDados_Bairro.setText(t.getEndereco().getBairro());
		tx_PNTutorDados_CEP.setText(t.getEndereco().getCep());
		tx_PNTutorDados_Cidade.setText(t.getEndereco().getCidade());
		tx_PNTutorDados_Estado.setText(t.getEndereco().getEstado());
		
		
//	    ObservableList<String> listAnimais = FXCollections.observableArrayList(control.buscarAnimal(lb_PN_CPF.getText()));
//
//		cb_PNTutorAnimais_Animal.setItems(listAnimais);
		
		
		

	}

	@FXML
	public void handlerVoltarTutor() {

		pn_Agendamento.setVisible(true);
		pn_Tutor.setVisible(false);
	}

}
