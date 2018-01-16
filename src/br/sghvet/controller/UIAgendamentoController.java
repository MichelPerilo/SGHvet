package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.fabric.xmlrpc.base.Array;

import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Animal;
import br.sghvet.model.Endereco;
import br.sghvet.model.Tutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UIAgendamentoController implements Initializable {

	IFachada control;;
	Alert alert = new Alert(AlertType.WARNING);

	// Painel Agenda
	
	
	
	@FXML
	private Pane pn_FichaCLinica2;
	@FXML
	private Pane pn_FichaCLinica1;
	@FXML
	private Pane pn_FichaCLinica3;

	// Painel FichaCLinica1
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

	// Painel FichaCLinica2

	@FXML
	private Label lb_PN_Nome;
	@FXML
	private Label lb_PN_Numero;
	@FXML
	private Label lb_PN_CPF;
	@FXML
	private Label lb_PN_Sexo;
	@FXML
	private Label lb_PN_Rua;
	@FXML
	private Label lb_PN_Bairro;
	@FXML
	private Label lb_PN_Cidade;

	// Painel FichaCLinica2 Dados

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

	// Painel FichaCLinica2 Aniamal

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
	@FXML
	private TextField tx_PNTutorAnimais_Prontuario;

	@FXML
	private ComboBox<String> cb_PNTutorAnimais_Animal;
	private ObservableList<String> listAnimais;
	
	
	// Painel FichaCLinica3 
	
//	Painel Agendamento
	
	@FXML
	private Label lb_PN_Agendamento01;

    @FXML
    private Label lb_PN_Agendamento02;

    @FXML
    private Label lb_PN_Agendamento03;

    @FXML
    private Label lb_PN_Agendamento04;

    @FXML
    private Label lb_PN_Agendamento05;

    @FXML
    private Label lb_PN_Agendamento06;

    @FXML
    private Label lb_PN_Agendamento07;

    @FXML
    private Label lb_PN_Agendamento08;

    @FXML
    private Label lb_PN_Agendamento09;

    @FXML
    private Label lb_PN_Agendamento10;

    @FXML
    private Label lb_PN_Agendamento11;

    @FXML
    private Label lb_PN_Agendamento12;

    @FXML
    private Label lb_PN_Agendamento13;

    @FXML
    private Label lb_PN_Agendamento14;

    @FXML
    private Label lb_PN_Agendamento15;

    @FXML
    private Label lb_PN_Agendamento16;

    @FXML
    private Label lb_PN_Agendamento17;

    @FXML
    private Label lb_PN_Agendamento18;

    @FXML
    private Label lb_PN_Agendamento19;

    @FXML
    private Label lb_PN_Agendamento20;

    @FXML
    private Label lb_PN_Agendamento21;

    @FXML
    private Label lb_PN_Agendamento22;

    @FXML
    private Label lb_PN_Agendamento23;

    @FXML
    private Label lb_PN_Agendamento24;

    @FXML
    private Label lb_PN_Agendamento25;

    @FXML
    private Label lb_PN_Agendamento26;

    @FXML
    private Label lb_PN_Agendamento27;

    @FXML
    private Label lb_PN_Agendamento28;

    @FXML
    private Label lb_PN_Agendamento29;

    @FXML
    private Label lb_PN_Agendamento30;

    @FXML
    private Label lb_PN_Agendamento31;

    @FXML
    private Label lb_PN_Agendamento32;

    @FXML
    private Label lb_PN_Agendamento33;

    @FXML
    private Label lb_PN_Agendamento34;

    @FXML
    private Label lb_PN_Agendamento35;

    @FXML
    private Label lb_PN_Agendamento36;

    @FXML
    private Label lb_PN_Agendamento37;

    @FXML
    private Label lb_PN_Agendamento38;

    @FXML
    private Label lb_PN_Agendamento39;

    @FXML
    private Label lb_PN_Agendamento40;

    @FXML
    private Label lb_PN_Agendamento41;

    @FXML
    private Label lb_PN_Agendamento42;

    @FXML
    private Label lb_PN_Agendamento_MesAtual;

   


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			control = new Fachada();
			control.carregarAgendamento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carregarTableViewTutor();

	}

	@SuppressWarnings("unchecked")
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
			loader.setLocation(UINovoTutorController.class.getResource("../view/fxml_NewTutor.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();
			Stage novoTutor = new Stage();
			novoTutor.setTitle("Novo Cadastro");
			Scene scene = new Scene(page);
			novoTutor.setScene(scene);
			novoTutor.setResizable(false);
			UINovoTutorController controller = loader.getController();
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
			loader.setLocation(UINovoAnimalController.class.getResource("../view/fxml_NewAnimal.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();
			Stage novoAnimal = new Stage();
			novoAnimal.setTitle("Novo Cadastro");
			Scene scene = new Scene(page);
			novoAnimal.setScene(scene);
			novoAnimal.setResizable(false);
			UINovoAnimalController controller = loader.getController();
			controller.setStage(novoAnimal);
			controller.setCPFTUTOR(tx_PNTutorDados_CPF.getText());
			novoAnimal.showAndWait();
			AtualizaAnimais(tx_PNTutorDados_CPF.getText());

		} catch (IOException e) {
			// TODO Auto-generated catch block0
			e.printStackTrace();
		}

	}

	@FXML
	public void handlerPesquisar() throws Exception {

		fazBusca(tx_BuscarTutor.getText());

	}

	@FXML
	public void handlerVoltarTutor() {

		pn_FichaCLinica1.setVisible(true);
		pn_FichaCLinica2.setVisible(false);
		tx_PNTutorAnimais_Nome.setText("");
		tx_PNTutorAnimais_Idade.setText("");
		tx_PNTutorAnimais_Raca.setText("");
		tx_PNTutorAnimais_Especie.setText("");
		tx_PNTutorAnimais_Peso.setText("");
		tx_PNTutorAnimais_Pelagem.setText("");
		tx_PNTutorAnimais_Sexo.setText("");
		tx_PNTutorAnimais_Prontuario.setText("");

	}

	@FXML
	public void handlerEditarTutor() {

		tx_PNTutorDados_Nome.setEditable(true);
		tx_PNTutorDados_CPF.setEditable(true);
		tx_PNTutorDados_Celular.setEditable(true);
		tx_PNTutorDados_Sexo.setEditable(true);
		tx_PNTutorDados_Rua.setEditable(true);
		tx_PNTutorDados_Numero.setEditable(true);
		tx_PNTutorDados_Complemento.setEditable(true);
		tx_PNTutorDados_Bairro.setEditable(true);
		tx_PNTutorDados_CEP.setEditable(true);
		tx_PNTutorDados_Cidade.setEditable(true);
		tx_PNTutorDados_Estado.setEditable(true);

	}

	@FXML
	public void handlerSalvarEditTutor() {

		Endereco e = new Endereco(tx_PNTutorDados_Rua.getText(), tx_PNTutorDados_Bairro.getText(),
				tx_PNTutorDados_CEP.getText(), tx_PNTutorDados_Numero.getText(), tx_PNTutorDados_Complemento.getText(),
				tx_PNTutorDados_Cidade.getText(), tx_PNTutorDados_Estado.getText(), tx_PNTutorDados_CPF.getText());
		Tutor t = new Tutor(tx_PNTutorDados_Nome.getText(), tx_PNTutorDados_CPF.getText(),
				tx_PNTutorDados_Sexo.getText(), tx_PNTutorDados_Celular.getText(), e);

		try {
			control.atualizarTutor(t);
			alert.setHeaderText("SALVO COM SUCESSO");
			alert.showAndWait();
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
			carregarTableViewTutor();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}

	@FXML
	public void handlerEditarAnimal() {

		tx_PNTutorAnimais_Nome.setEditable(true);
		tx_PNTutorAnimais_Idade.setEditable(true);
		tx_PNTutorAnimais_Raca.setEditable(true);
		tx_PNTutorAnimais_Especie.setEditable(true);
		tx_PNTutorAnimais_Peso.setEditable(true);
		tx_PNTutorAnimais_Pelagem.setEditable(true);
		tx_PNTutorAnimais_Sexo.setEditable(true);

	}

	@FXML
	public void handlerSalvarEditAnimal() {

		Animal a = new Animal(tx_PNTutorAnimais_Nome.getText(), tx_PNTutorAnimais_Especie.getText(),
				tx_PNTutorAnimais_Sexo.getText(), Integer.parseInt(tx_PNTutorAnimais_Idade.getText()),
				lb_PN_CPF.getText(), tx_PNTutorAnimais_Raca.getText(), tx_PNTutorAnimais_Pelagem.getText(),
				Double.parseDouble(tx_PNTutorAnimais_Peso.getText()));
		a.setNumProntuario(Long.parseLong(tx_PNTutorAnimais_Prontuario.getText()));

		try {
			control.atualizarAnimal(a);
			tx_PNTutorAnimais_Nome.setEditable(false);
			tx_PNTutorAnimais_Idade.setEditable(false);
			tx_PNTutorAnimais_Raca.setEditable(false);
			tx_PNTutorAnimais_Especie.setEditable(false);
			tx_PNTutorAnimais_Peso.setEditable(false);
			tx_PNTutorAnimais_Pelagem.setEditable(false);
			tx_PNTutorAnimais_Sexo.setEditable(false);
			AtualizaAnimais(lb_PN_CPF.getText());
			alert.setHeaderText("SALVO COM SUCESSO");
			alert.showAndWait();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void clicarMouseItemListViewTuor() throws IOException {
		Tutor t = tv_PaneAgendamento.getSelectionModel().getSelectedItem();

		fazBusca(t.getCpf());

	}

	public void fazBusca(String cpf) {

		pn_FichaCLinica1.setVisible(false);
		pn_FichaCLinica2.setVisible(true);
		AtualizaAnimais(cpf);
		Tutor t;
		try {
			t = control.buscarTutor(cpf);

			lb_PNTutorNOME.setText(t.getNome());
			lb_PN_Nome.setText("Nome: " + t.getNome());
			lb_PN_Numero.setText("Fone: " + t.getContato());
			lb_PN_CPF.setText("CPF: " + t.getCpf());
			lb_PN_Sexo.setText("Sexo: " + t.getSexo());
			lb_PN_Rua.setText("Rua: " + t.getEndereco().getLogradouro());
			lb_PN_Bairro.setText("Bairro: " + t.getEndereco().getBairro());
			lb_PN_Cidade.setText("Cidade: " + t.getEndereco().getCidade());

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

			tx_PNTutorAnimais_Nome.setEditable(false);
			tx_PNTutorAnimais_Idade.setEditable(false);
			tx_PNTutorAnimais_Raca.setEditable(false);
			tx_PNTutorAnimais_Especie.setEditable(false);
			tx_PNTutorAnimais_Peso.setEditable(false);
			tx_PNTutorAnimais_Pelagem.setEditable(false);
			tx_PNTutorAnimais_Sexo.setEditable(false);
			tx_PNTutorAnimais_Prontuario.setEditable(false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public void AtualizaAnimais(String cpf) {

		try {

			List<Animal> listA = pegaAnimais(cpf);
			List<String> nomesA = new ArrayList<>();

			for (Animal animal : listA) {

				nomesA.add(animal.getNome());
			}

			listAnimais = FXCollections.observableArrayList(nomesA);
			cb_PNTutorAnimais_Animal.setItems(listAnimais);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List pegaAnimais(String cpf) {

		List<Animal> list = new ArrayList<>();

		try {

			list = control.buscarAnimal(cpf);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	@FXML
	public void handlerEscolheAnimal() {

		try {

			List<Animal> listA = pegaAnimais(tx_PNTutorDados_CPF.getText());

			for (Animal animal : listA) {

				if (cb_PNTutorAnimais_Animal.getValue().equals(animal.toString())) {

					tx_PNTutorAnimais_Nome.setText(animal.getNome());
					tx_PNTutorAnimais_Idade.setText(String.valueOf(animal.getIdade()));
					tx_PNTutorAnimais_Raca.setText(animal.getRaça());
					tx_PNTutorAnimais_Especie.setText(animal.getEspecie());
					tx_PNTutorAnimais_Peso.setText(String.valueOf(animal.getPeso()));
					tx_PNTutorAnimais_Pelagem.setText(animal.getPelagem());
					tx_PNTutorAnimais_Sexo.setText(animal.getSexo());
					tx_PNTutorAnimais_Prontuario.setText(String.valueOf(animal.getNumProntuario()));
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@FXML
	public void handleAgendamento() {
		
		pn_FichaCLinica3.setVisible(true);
		pn_FichaCLinica1.setVisible(false);
		pn_FichaCLinica2.setVisible(false);
		
	}
	
	@FXML
	public void handlePaciente() {
		
		
		pn_FichaCLinica1.setVisible(true);
		pn_FichaCLinica3.setVisible(false);
		
	}
	
	
	

}
