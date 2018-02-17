package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.model.Animal;
import br.sghvet.model.Consulta;
import br.sghvet.model.Endereco;
import br.sghvet.model.ResultadoExame;
import br.sghvet.model.Tutor;
import br.sghvet.controller.UINovaConsultaController;
import br.sghvet.controller.UINovaSenhaController;
import br.sghvet.controller.UIHorariosViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UIAgendamentoController implements Initializable {

	// IFachada control;;
	Alert alert = new Alert(AlertType.WARNING);
	private String cpfLogado;
	@FXML
	private Button bt_Agendamento;
	private Stage horarios;

	// Painel Agenda

	@FXML
	private Pane pn_FichaCLinica2;
	@FXML
	private Pane pn_FichaCLinica1;
	@FXML
	private Pane pn_FichaCLinica3;
	@FXML
	private MenuButton Mn_buttonNomeFuncionario;

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
	private Button bt_PNTutorDadosEditar;
	@FXML
	private Button bt_PNTutorDadosSalvar;
	private Tutor tut;

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
	private Pane pnEdit;
	@FXML
	private Pane pnEdit2;
	@FXML
	private Button bt_PNTutorAnimalEditar;
	@FXML
	private Button bt_PNTutorAnimalSalvar;
	private Animal ani;

	@FXML
	private ComboBox<String> cb_Especie;
	@FXML
	private ComboBox<String> cb_RacaAnimal;
	@FXML
	private ComboBox<String> cb_PelagemAnimal;
	private ObservableList<String> listPelagemAnimalCbbx = FXCollections.observableArrayList("Dupla pelagem",
			"Peculiares", "Dura", "Arame", "Curto", "Longo", "Longo sedoso sem ondula��es");

	@FXML
	private TextField tx_PNTutorAnimais_Nome;
	@FXML
	private Label tx_PNTutorAnimais_Idade;
	@FXML
	private DatePicker dt_PNTutorAnimais_Nascimento;
	@FXML
	private Label tx_PNTutorAnimais_nascimento;
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

	@FXML
	private TextArea textarea_cabecapescoco;
	@FXML
	private TextArea textarea_cavabdominal;
	@FXML
	private TextArea textarea_cavtoracica;
	@FXML
	private TextArea textarea_diagdefinitivo;
	@FXML
	private TextArea textarea_diagprovavel;
	@FXML
	private TextArea textarea_examescomple;
	@FXML
	private TextArea textarea_prognostico;
	@FXML
	private TextArea textarea_sislocomotor;
	@FXML
	private TextArea textarea_sisnervoso;
	@FXML
	private TextArea textarea_vacinacoes;
	@FXML
	private TextArea textarea_vermifugacoes;
	@FXML
	private TextArea textarea_ectoscopia;
	@FXML
	private TextField textfield_batcardiaco;
	@FXML
	private TextField textfield_movrespiratorio;
	@FXML
	private TextField textfield_pulso;
	@FXML
	private TextField textfield_tr;

	@FXML
	private TableView<Consulta> tv_consultas2;
	@FXML
	private TableColumn<Consulta, String> tc_consulta_data;
	@FXML
	private TableColumn<Consulta, String> tc_consulta_hora;
	@FXML
	private TableColumn<Consulta, String> tc_consulta_medico;
	private ObservableList<Consulta> observableListConsulta2;

	@FXML
	private Label lb_dataSelecionada;
	@FXML
	private Label lb_HRSelecionada;
	@FXML
	private Label lb_CPFTutor;
	@FXML
	private Label lb_Animal;
	@FXML
	private Label lb_prontuario;
	@FXML
	private Label lb_Medico;

	// Painel FichaCLinica3

	// Painel Agendamento

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

	ArrayList<Label> dias = new ArrayList<>();

	@FXML
	private TableView<Consulta> tv_consultas;

	@FXML
	private TableColumn<Consulta, LocalTime> tc_consultas_hr;
	@FXML
	private TableColumn<Consulta, Integer> tc_consultas_prot;
	@FXML
	private TableColumn<Consulta, String> tc_consultas_Ani;
	@FXML
	private TableColumn<Consulta, String> tc_consultas_tut;
	private ObservableList<Consulta> observableListConsulta;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			Fachada.getInstance().carregarAgendamento();
			carregaDias();
			FuncionarioLogado(getCpfLogado());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carregarTableViewTutor();
		carregarTableViewConsulta();

	}

	@SuppressWarnings("unchecked")
	public void carregarTableViewTutor() {

		tc_AgendamentoID.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		tc_AgendamentoCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tc_AgendamentoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tc_AgendamentoTelefone.setCellValueFactory(new PropertyValueFactory<>("contato"));

		try {
			observableListTutor = FXCollections.observableArrayList(Fachada.getInstance().buscarALLTutor());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tv_PaneAgendamento.setItems(observableListTutor);
	}

	@SuppressWarnings("unchecked")
	public void carregarTableViewConsulta() {

		tc_consultas_hr.setCellValueFactory(new PropertyValueFactory<>("horario"));
		tc_consultas_prot.setCellValueFactory(new PropertyValueFactory<>("prontuario"));
		tc_consultas_Ani.setCellValueFactory(new PropertyValueFactory<>("nomeAnimal"));
		tc_consultas_tut.setCellValueFactory(new PropertyValueFactory<>("nomeTutor"));

		try {
			observableListConsulta = FXCollections.observableArrayList(Fachada.getInstance().buscarALLConsulta());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tv_consultas.setItems(observableListConsulta);
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

		if (tx_BuscarTutor.getText() != null && !tx_BuscarTutor.getText().equals(""))
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
	    limpaAnimal();
		carregarTableViewTutor();
		tv_consultas2.setItems(null);
		

	}

	@FXML
	public void handlerEditarTutor() {

		bt_PNTutorDadosEditar.setVisible(false);
		bt_PNTutorDadosSalvar.setVisible(true);

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
	public void handlerDeletaTutor() {

		try {
			Fachada.getInstance().deletarTutor(tut);
			handlerVoltarTutor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void handlerSalvarEditTutor() {

		try {

			bt_PNTutorDadosEditar.setVisible(true);
			bt_PNTutorDadosSalvar.setVisible(false);

			Endereco e = new Endereco(tx_PNTutorDados_Rua.getText(), tx_PNTutorDados_Bairro.getText(),
					tx_PNTutorDados_CEP.getText(), tx_PNTutorDados_Numero.getText(),
					tx_PNTutorDados_Complemento.getText(), tx_PNTutorDados_Cidade.getText(),
					tx_PNTutorDados_Estado.getText(), tx_PNTutorDados_CPF.getText());
			Tutor t = new Tutor(tx_PNTutorDados_Nome.getText(), tx_PNTutorDados_CPF.getText(),
					tx_PNTutorDados_Sexo.getText(), tx_PNTutorDados_Celular.getText(), e);
			Fachada.getInstance().atualizarTutor(t);
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
			alert.setHeaderText(e1.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	public void handlerEditarAnimal() {

		pnEdit.setVisible(true);
		pnEdit2.setVisible(true);
		bt_PNTutorAnimalEditar.setVisible(false);
		bt_PNTutorAnimalSalvar.setVisible(true);
		cb_PelagemAnimal.setItems(listPelagemAnimalCbbx);
		AtualizaEspecie();

		tx_PNTutorAnimais_Nome.setEditable(true);
		tx_PNTutorAnimais_Peso.setEditable(true);
		tx_PNTutorAnimais_Sexo.setEditable(true);

	}

	public void AtualizaEspecie() {

		try {

			ObservableList<String> listEsp = FXCollections
					.observableArrayList(Fachada.getInstance().buscarALLEspeciel());
			cb_Especie.setItems(listEsp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void AtualizaRaca() {

		cb_RacaAnimal.setItems(null);
		try {

			if (cb_Especie.getValue().equals("CACHORRO")) {
				ObservableList<String> listC = FXCollections.observableArrayList(Fachada.getInstance().buscarRaca(1));
				cb_RacaAnimal.setItems(listC);
			}

			if (cb_Especie.getValue().equals("GATO")) {
				ObservableList<String> listG = FXCollections.observableArrayList(Fachada.getInstance().buscarRaca(2));
				cb_RacaAnimal.setItems(listG);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void handlerSalvarEditAnimal() {

		pnEdit.setVisible(false);
		pnEdit2.setVisible(false);
		bt_PNTutorAnimalEditar.setVisible(true);
		bt_PNTutorAnimalSalvar.setVisible(false);

		LocalDate dataNew;
		String raca;
		String especie;
		String pelo;
		if (dt_PNTutorAnimais_Nascimento.getValue() == null) {

			String[] Convertedate = tx_PNTutorAnimais_nascimento.getText().split("/");
			dataNew = LocalDate.of(Integer.parseInt(Convertedate[2]), Integer.parseInt(Convertedate[1]),
					Integer.parseInt(Convertedate[0]));

		} else {
			dataNew = dt_PNTutorAnimais_Nascimento.getValue();
		}

		if (cb_Especie.getValue() == null) {

			especie = tx_PNTutorAnimais_Especie.getText();

		} else {

			especie = cb_Especie.getValue();

		}
		if (cb_RacaAnimal.getValue() == null) {
			raca = tx_PNTutorAnimais_Raca.getText();

		} else {
			raca = cb_RacaAnimal.getValue();
		}
		if (cb_PelagemAnimal.getValue() == null) {

			pelo = tx_PNTutorAnimais_Pelagem.getText();

		} else {

			pelo = cb_PelagemAnimal.getValue();

		}

		Animal a = new Animal(dataNew, tx_PNTutorAnimais_Nome.getText(), especie, tx_PNTutorAnimais_Sexo.getText(),
				lb_PN_CPF.getText(), raca, pelo, Double.parseDouble(tx_PNTutorAnimais_Peso.getText()));
		a.setNumProntuario(Long.parseLong(tx_PNTutorAnimais_Prontuario.getText()));

		try {
			Fachada.getInstance().atualizarAnimal(a);

			tx_PNTutorAnimais_Nome.setEditable(false);
			tx_PNTutorAnimais_Raca.setEditable(false);
			tx_PNTutorAnimais_Especie.setEditable(false);
			tx_PNTutorAnimais_Peso.setEditable(false);
			tx_PNTutorAnimais_Pelagem.setEditable(false);
			tx_PNTutorAnimais_Sexo.setEditable(false);
			AtualizaAnimais(tx_PNTutorDados_CPF.getText());
			alert.setHeaderText("SALVO COM SUCESSO");
			alert.showAndWait();

		} catch (Exception e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}

	}

	@FXML
	public void handlerDeletaAnimal() {

		try {
			tx_PNTutorAnimais_Nome.setText("");
			tx_PNTutorAnimais_Idade.setText("");
			tx_PNTutorAnimais_Raca.setText("");
			tx_PNTutorAnimais_Especie.setText("");
			tx_PNTutorAnimais_Peso.setText("");
			tx_PNTutorAnimais_Pelagem.setText("");
			tx_PNTutorAnimais_Sexo.setText("");
			tx_PNTutorAnimais_Prontuario.setText("");
			limpaAnimal();
			tv_consultas2.setItems(null);
			Fachada.getInstance().deletarAnimal(ani);
			carregarTableViewConsulta();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void limpaAnimal() {
		
				
		lb_dataSelecionada.setText("");
		lb_HRSelecionada.setText("");
		lb_CPFTutor.setText("");
		lb_Animal.setText("");
		lb_prontuario.setText("");
		lb_Medico.setText("");

		textarea_cabecapescoco.setText("");
		textarea_cavabdominal.setText("");
		textarea_cavtoracica.setText("");
		textarea_diagdefinitivo.setText("");
		textarea_diagprovavel.setText("");
		textarea_examescomple.setText("");
		textarea_sislocomotor.setText("");
		textarea_vacinacoes.setText("");
		textarea_vermifugacoes.setText("");
		textarea_ectoscopia.setText("");
		textfield_batcardiaco.setText("");
		textfield_pulso.setText("");
		textfield_tr.setText("");
		textarea_prognostico.setText("");
		textfield_movrespiratorio.setText("");
		textarea_sisnervoso.setText("");
		
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
			t = Fachada.getInstance().buscarTutor(cpf);
			this.tut = t;

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

			list = Fachada.getInstance().buscarAnimal(cpf);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	@FXML
	public void handlerEscolheAnimal() {

		if (cb_PNTutorAnimais_Animal.getValue() != null) {
			try {

				List<Animal> listA = pegaAnimais(tx_PNTutorDados_CPF.getText());

				for (Animal animal : listA) {

					this.ani = animal;

					if (cb_PNTutorAnimais_Animal.getValue().equals(animal.toString())) {

						tx_PNTutorAnimais_Nome.setText(animal.getNome());
						tx_PNTutorAnimais_Idade.setText(String.valueOf(animal.getIdade()));
						DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						tx_PNTutorAnimais_nascimento.setText(animal.getDataNascimento().format(formatador));
						tx_PNTutorAnimais_Raca.setText(animal.getRa�a());
						tx_PNTutorAnimais_Especie.setText(animal.getEspecie());
						tx_PNTutorAnimais_Peso.setText(String.valueOf(animal.getPeso()));
						tx_PNTutorAnimais_Pelagem.setText(animal.getPelagem());
						tx_PNTutorAnimais_Sexo.setText(animal.getSexo());
						tx_PNTutorAnimais_Prontuario.setText(String.valueOf(animal.getNumProntuario()));

						carregaTabelaConsultas2();
						break;

					}

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void carregaTabelaConsultas2() {

		tc_consulta_data.setCellValueFactory(new PropertyValueFactory<>("dia"));
		tc_consulta_hora.setCellValueFactory(new PropertyValueFactory<>("horario"));
		tc_consulta_medico.setCellValueFactory(new PropertyValueFactory<>("nomeMedico"));

		try {

			List<Consulta> filtro = new ArrayList<>();
			List<Consulta> allConsultas = Fachada.getInstance().buscarConsultaPro(Integer.parseInt(tx_PNTutorAnimais_Prontuario.getText()));

			for (Consulta c : allConsultas) {

				if (cb_PNTutorAnimais_Animal.getValue().equals(c.getNomeAnimal())) {
					filtro.add(c);
					System.out.println(c.getNomeAnimal());
				}

			}

			observableListConsulta2 = FXCollections.observableArrayList(filtro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tv_consultas2.setItems(observableListConsulta2);
	}

	@FXML
	public void clicarMouseItemListViewConsultas2() throws IOException {
		
		limpaAnimal();
		Consulta c = tv_consultas2.getSelectionModel().getSelectedItem();
		selecionarRegistro(c);
		

	}

	public void selecionarRegistro(Consulta consulta) {

		try {
			ResultadoExame registro;
			registro = Fachada.getInstance().buscarRegistro(consulta);
			
			if(registro != null) {

			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			lb_dataSelecionada.setText(consulta.getDia().format(formatador));
			lb_HRSelecionada.setText(consulta.getHorario().toString());
			lb_CPFTutor.setText(consulta.getNomeTutor());
			lb_Animal.setText(consulta.getNomeAnimal());
			lb_prontuario.setText(String.valueOf(consulta.getProntuario()));
			lb_Medico.setText(consulta.getNomeMedico());

			textarea_cabecapescoco.setText(registro.getCabecaPescoco());
			textarea_cavabdominal.setText(registro.getCavidadeAbdominal());
			textarea_cavtoracica.setText(registro.getCavidadeToracica());
			textarea_diagdefinitivo.setText(registro.getDiagnosticoDefinitivo());
			textarea_diagprovavel.setText(registro.getDiagnosticoProvavel());
			textarea_examescomple.setText(registro.getExamesComplementares());
			textarea_sislocomotor.setText(registro.getSistemaLocomotor());
			textarea_vacinacoes.setText(registro.getVacinacoes());
			textarea_vermifugacoes.setText(registro.getVermifugacoes());
			textarea_ectoscopia.setText(registro.getEctoscopia());
			textfield_batcardiaco.setText(String.valueOf(registro.getBatimentoPorMin()));
			textfield_pulso.setText(String.valueOf(registro.getPulso()));
			textfield_tr.setText(String.valueOf(registro.getTemp()));
			textarea_prognostico.setText(registro.getPrognostico());
			textfield_movrespiratorio.setText(String.valueOf(registro.getMovRespPorMin()));
			textarea_sisnervoso.setText(registro.getSistemaNervoso());
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

		tx_PNTutorAnimais_Nome.setText("");
		tx_PNTutorAnimais_Idade.setText("");
		tx_PNTutorAnimais_Raca.setText("");
		tx_PNTutorAnimais_Especie.setText("");
		tx_PNTutorAnimais_Peso.setText("");
		tx_PNTutorAnimais_Pelagem.setText("");
		tx_PNTutorAnimais_Sexo.setText("");
		tx_PNTutorAnimais_Prontuario.setText("");
	    limpaAnimal();
	    tv_consultas2.setItems(null);
		pn_FichaCLinica1.setVisible(true);
		pn_FichaCLinica3.setVisible(false);
		pn_FichaCLinica2.setVisible(false);
	

	}

	public void carregaDias() {

		dias.add(lb_PN_Agendamento01);
		dias.add(lb_PN_Agendamento02);
		dias.add(lb_PN_Agendamento03);
		dias.add(lb_PN_Agendamento04);
		dias.add(lb_PN_Agendamento05);
		dias.add(lb_PN_Agendamento06);
		dias.add(lb_PN_Agendamento07);
		dias.add(lb_PN_Agendamento08);
		dias.add(lb_PN_Agendamento09);
		dias.add(lb_PN_Agendamento10);
		dias.add(lb_PN_Agendamento11);
		dias.add(lb_PN_Agendamento12);
		dias.add(lb_PN_Agendamento13);
		dias.add(lb_PN_Agendamento14);
		dias.add(lb_PN_Agendamento15);
		dias.add(lb_PN_Agendamento16);
		dias.add(lb_PN_Agendamento17);
		dias.add(lb_PN_Agendamento18);
		dias.add(lb_PN_Agendamento19);
		dias.add(lb_PN_Agendamento20);
		dias.add(lb_PN_Agendamento21);
		dias.add(lb_PN_Agendamento22);
		dias.add(lb_PN_Agendamento23);
		dias.add(lb_PN_Agendamento24);
		dias.add(lb_PN_Agendamento25);
		dias.add(lb_PN_Agendamento26);
		dias.add(lb_PN_Agendamento27);
		dias.add(lb_PN_Agendamento28);
		dias.add(lb_PN_Agendamento29);
		dias.add(lb_PN_Agendamento30);
		dias.add(lb_PN_Agendamento31);
		dias.add(lb_PN_Agendamento32);
		dias.add(lb_PN_Agendamento33);
		dias.add(lb_PN_Agendamento34);
		dias.add(lb_PN_Agendamento35);
		dias.add(lb_PN_Agendamento36);
		dias.add(lb_PN_Agendamento37);
		dias.add(lb_PN_Agendamento38);
		dias.add(lb_PN_Agendamento39);
		dias.add(lb_PN_Agendamento40);
		dias.add(lb_PN_Agendamento41);
		dias.add(lb_PN_Agendamento42);
		dias.add(lb_PN_Agendamento_MesAtual);

		Calendar c = new GregorianCalendar();
		DateFormatSymbols symbols = new DateFormatSymbols();
		String[] nomeMes = symbols.getMonths();		
		String s = symbols.getWeekdays()[Calendar.DAY_OF_MONTH];
		
		

		int dayM = 0;
		switch (s) {
		
		

		case "Domingo":
			dayM = 0;
			break;

		case "Segunda-feira":

			dayM = 1;
			break;
		case "Ter�a-feira":

			dayM = 2;
			break;
		case "Quarta-feira":

			dayM = 3;
			break;
		case "Quinta-feira":

			dayM = 4;
			break;
		case "Sexta-feria":

			dayM = 5;
			break;
		case "S�bado":

			dayM = 6;
			break;

		default:
			break;

		}

		for (int diaA = 1; diaA <= c.getActualMaximum(Calendar.DAY_OF_MONTH); diaA++) {

			dias.get(dayM).setText(Integer.toString(diaA));
			++dayM;

		}

		dias.get(42).setText(nomeMes[c.get(Calendar.MONTH)]);

	}

	@FXML
	public void handlerNovoAgendamento01() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento01.getText()));
	}

	@FXML
	public void handlerNovoAgendamento02() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento02.getText()));
	}

	@FXML
	public void handlerNovoAgendamento03() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento03.getText()));
	}

	@FXML
	public void handlerNovoAgendamento04() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento04.getText()));
	}

	@FXML
	public void handlerNovoAgendamento05() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento05.getText()));
	}

	@FXML
	public void handlerNovoAgendamento06() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento06.getText()));
	}

	@FXML
	public void handlerNovoAgendamento07() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento07.getText()));
	}

	@FXML
	public void handlerNovoAgendamento08() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento08.getText()));
	}

	@FXML
	public void handlerNovoAgendamento09() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento09.getText()));
	}

	@FXML
	public void handlerNovoAgendamento10() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento10.getText()));
	}

	@FXML
	public void handlerNovoAgendamento11() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento12.getText()));
	}

	@FXML
	public void handlerNovoAgendamento12() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento12.getText()));
	}

	@FXML
	public void handlerNovoAgendamento13() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento13.getText()));
	}

	@FXML
	public void handlerNovoAgendamento14() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento14.getText()));
	}

	@FXML
	public void handlerNovoAgendamento15() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento15.getText()));
	}

	@FXML
	public void handlerNovoAgendamento16() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento16.getText()));
	}

	@FXML
	public void handlerNovoAgendamento17() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento17.getText()));
	}

	@FXML
	public void handlerNovoAgendamento18() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento18.getText()));
	}

	@FXML
	public void handlerNovoAgendamento19() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento19.getText()));
	}

	@FXML
	public void handlerNovoAgendamento20() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento20.getText()));
	}

	@FXML
	public void handlerNovoAgendamento21() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento21.getText()));
	}

	@FXML
	public void handlerNovoAgendamento22() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento22.getText()));
	}

	@FXML
	public void handlerNovoAgendamento23() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento23.getText()));
	}

	@FXML
	public void handlerNovoAgendamento24() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento24.getText()));
	}

	@FXML
	public void handlerNovoAgendamento25() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento25.getText()));
	}

	@FXML
	public void handlerNovoAgendamento26() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento26.getText()));
	}

	@FXML
	public void handlerNovoAgendamento27() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento27.getText()));
	}

	@FXML
	public void handlerNovoAgendamento28() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento28.getText()));
	}

	@FXML
	public void handlerNovoAgendamento29() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento29.getText()));
	}

	@FXML
	public void handlerNovoAgendamento30() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento30.getText()));
	}

	@FXML
	public void handlerNovoAgendamento31() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento31.getText()));
	}

	@FXML
	public void handlerNovoAgendamento32() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento32.getText()));
	}

	@FXML
	public void handlerNovoAgendamento33() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento33.getText()));
	}

	@FXML
	public void handlerNovoAgendamento34() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento34.getText()));
	}

	@FXML
	public void handlerNovoAgendamento35() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento35.getText()));
	}

	@FXML
	public void handlerNovoAgendamento36() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento36.getText()));
	}

	@FXML
	public void handlerNovoAgendamento37() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento37.getText()));
	}

	@FXML
	public void handlerNovoAgendamento38() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento38.getText()));
	}

	@FXML
	public void handlerNovoAgendamento39() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento39.getText()));
	}

	@FXML
	public void handlerNovoAgendamento40() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento40.getText()));
	}

	@FXML
	public void handlerNovoAgendamento41() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento41.getText()));
	}

	@FXML
	public void handlerNovoAgendamento42() {

		NovoAgendamento(Integer.parseInt(lb_PN_Agendamento42.getText()));
	}

	public void NovoAgendamento(int dia) {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(UINovaConsultaController.class.getResource("../view/fxml_NovaConsulta.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();
			Stage novoStage = new Stage();
			novoStage.setTitle("Novo Consulta");
			Scene scene = new Scene(page);
			novoStage.setScene(scene);
			novoStage.setResizable(false);
			UINovaConsultaController controller = loader.getController();
			// PASSANDO ATRIBUTOS

			LocalDate hoje = LocalDate.now();
			LocalDate dtSelect = LocalDate.of(hoje.getYear(), hoje.getMonth(), dia);

			controller.setDataSelecionada(dtSelect);
			controller.setStage(novoStage);
			novoStage.showAndWait();
			carregarTableViewConsulta();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void handlerTrovaSenha() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(UINovaSenhaController.class.getResource("../view/fxml_NewSenha.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();
			Stage novoStage = new Stage();
			novoStage.setTitle("Nova Senha");
			Scene scene = new Scene(page);
			novoStage.setScene(scene);
			novoStage.setResizable(false);
			UINovaSenhaController controller = loader.getController();
			controller.setStage(novoStage);
			novoStage.showAndWait();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public String getCpfLogado() {
		return cpfLogado;
	}

	public void setCpfLogado(String cpfLogado) {

		System.out.println(cpfLogado);
		this.cpfLogado = cpfLogado;
	}

	public void FuncionarioLogado(String cpf) {

		try {
			String nome = Fachada.getInstance().buscaAdm(Fachada.getInstance().getCpfLogado()).getNome();
			System.out.println(nome);
			Mn_buttonNomeFuncionario.setText(nome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void logoff() {
		try {

			Stage stageCLose = (Stage) bt_Agendamento.getScene().getWindow(); // Obtendo a janela atual
			stageCLose.close(); // Fechando o Stage
			Fachada.getInstance().desconectar();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(UiLoginController.class.getResource("../view/fxml_ui_login.fxml"));
			VBox page = (VBox) loader.load();
			Stage TelaInicial = new Stage();
			Scene scene = new Scene(page);
			TelaInicial.setScene(scene);
			UiLoginController controller = loader.getController();
			controller.setStage(TelaInicial);
			TelaInicial.showAndWait();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void clicarMouseItemListViewConsulta() throws IOException {
		Consulta c = tv_consultas.getSelectionModel().getSelectedItem();
		fazBuscaConsulta(c);

	}

	public void fazBuscaConsulta(Consulta consulta) {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(UINovaConsultaController.class.getResource("../view/fxml_NovaConsulta.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();
			Stage novoStage = new Stage();
			novoStage.setTitle("Novo Consulta");
			Scene scene = new Scene(page);
			novoStage.setScene(scene);
			novoStage.setResizable(false);
			UINovaConsultaController controller = loader.getController();
			// PASSANDO ATRIBUTOS

			controller.pn_Agendamento1.setVisible(false);
			controller.pn_Agendamento2.setVisible(true);
			controller.setConsulta(consulta);
			controller.setStage(novoStage);

			novoStage.showAndWait();
			carregarTableViewConsulta();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
