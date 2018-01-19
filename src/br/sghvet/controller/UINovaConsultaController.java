package br.sghvet.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Animal;
import br.sghvet.model.Consulta;
import br.sghvet.model.Disponibilidade;
import br.sghvet.model.Veterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.LocalDateStringConverter;

public class UINovaConsultaController implements Initializable {

	@FXML
	private Label lb_dataSelecionada;

	@FXML
	private ComboBox<String> cb_horariosDIsponiveis;
	private ObservableList<String> horas = FXCollections.observableArrayList("07:00", "08:00", "09:00", "10:00",
			"11:00", "12:00", "14:00", "15:00", "16:00");

	@FXML
	private Label lb_prontuario;

	@FXML
	private ComboBox<String> cb_nomeAnimal;
	private ObservableList<String> listnomeAnimal;

	@FXML
	private TextField tx_cpftutor;

	@FXML
	private Button btnFecharCencelar;

	@FXML
	private ComboBox<String> cb_medicoResponsavel;
	private ObservableList<String> listmedicoResponsavel;

	@FXML
	private Button bt_cancellar;

	Alert alert = new Alert(AlertType.WARNING);

	private Stage stage;
	private LocalDate DataSelecionada;
	private String cpfMedico;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		SetCB();
		Fachada.getInstance();

	}

	@FXML
	public void handlerAgendar() {
		Consulta consulta = null;
		if (cb_horariosDIsponiveis.getValue() != null && !cb_horariosDIsponiveis.equals("")) {
			String[] horas = cb_horariosDIsponiveis.getValue().split(":");
			LocalTime lt = LocalTime.of(Integer.parseInt(horas[0]), Integer.parseInt(horas[1]));
			consulta = new Consulta(getDataSelecionada(), lt, tx_cpftutor.getText(),
					Integer.parseInt(lb_prontuario.getText()), getCpfMedico());

		}

		try {
			Fachada.getInstance().cadastrarConsulta(consulta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void fechar() {
		btnFecharCencelar.getScene().getWindow().hide();
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
		this.stage.initStyle(StageStyle.UNDECORATED);
	}

	public void setDataSelecionada(LocalDate data) {

		this.DataSelecionada = data;
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.lb_dataSelecionada.setText(DataSelecionada.format(formatador));

	}

	public LocalDate getDataSelecionada() {

		return this.DataSelecionada;
	}

	@FXML
	public void handlerPesquisar() throws Exception {

		if (tx_cpftutor.getText() != null && !tx_cpftutor.getText().equals(""))
			System.out.println(tx_cpftutor.getText() );
			AtualizaAnimais(tx_cpftutor.getText());

	}

	
	@FXML
	public void AtualizaAnimais(String cpf) {

		try {

			List<Animal> listA = pegaAnimais(cpf);
			List<String> nomesA = new ArrayList<>();

			for (Animal animal : listA) {

				nomesA.add(animal.getNome());
			}

			listnomeAnimal = FXCollections.observableArrayList(nomesA);
			cb_nomeAnimal.setItems(listnomeAnimal);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List pegaAnimais(String cpf) {

		List<Animal> list = new ArrayList<>();

		try {

			list = Fachada.getInstance().buscarAnimal(cpf);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	public void handlerEscolheAnimal() {

		try {

			if (tx_cpftutor.getText() != null && !tx_cpftutor.getText().equals("")) {
				List<Animal> listA = pegaAnimais(tx_cpftutor.getText());

				for (Animal animal : listA) {

					if (cb_nomeAnimal.getValue().equals(animal.toString())) {

						lb_prontuario.setText(Long.toString(animal.getNumProntuario()));
					}

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void SetCB() {

		cb_horariosDIsponiveis.setItems(horas);

	}

	@FXML
	public void handlerDisponivel() throws Exception {

		if (cb_horariosDIsponiveis.getValue() != null && !cb_horariosDIsponiveis.equals(""))
			AtualizaVeterinario(cb_horariosDIsponiveis.getValue());

	}

	public void AtualizaVeterinario(String horario) {

		try {

			List<Disponibilidade> listA = ListaMedicos(horario);
			List<String> nomesA = new ArrayList<>();

			for (Disponibilidade dis : listA) {

				nomesA.add(Fachada.getInstance().buscaVeterinario(dis.getCpfVet()).getNome());
			}

			listmedicoResponsavel = FXCollections.observableArrayList(nomesA);
			cb_medicoResponsavel.setItems(listmedicoResponsavel);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private List<Disponibilidade> ListaMedicos(String horario) {

		List<Disponibilidade> list = new ArrayList<>();

		try {

			list = Fachada.getInstance().buscaDisponibilidade(horario);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	@FXML
	public void handleEscolheMedico() {

		try {

			if (cb_horariosDIsponiveis.getValue() != null && !cb_horariosDIsponiveis.equals("")) {
				List<Disponibilidade> listA = ListaMedicos(cb_horariosDIsponiveis.getValue());

				for (Disponibilidade dis : listA) {

					if (cb_medicoResponsavel.getValue()
							.equals(Fachada.getInstance().buscaVeterinario(dis.getCpfVet()))) {

						setCpfMedico(dis.getCpfVet());
					}

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getCpfMedico() {
		return cpfMedico;
	}

	public void setCpfMedico(String cpfMedico) {
		this.cpfMedico = cpfMedico;
	}

}
