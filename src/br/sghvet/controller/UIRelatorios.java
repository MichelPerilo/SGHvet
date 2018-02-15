package br.sghvet.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.model.Animal;
import br.sghvet.model.Consulta;
import br.sghvet.model.Tutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;

public class UIRelatorios implements Initializable {

	@FXML
	private BarChart<?, ?> consultas_X_animais;

	@FXML
	private CategoryAxis x;

	@FXML
	private NumberAxis y;

	@FXML
	private Pane pn_relatorio1;

	@FXML
	private Pane pn_relatorio2;

	@FXML
	private Pane pn_relatorio3;

	@FXML
	private DatePicker dt_inicio;

	@FXML
	private DatePicker dt_fim;

	@FXML
	private ComboBox<String> cb_nomeTutor;
	private ObservableList<String> listaNomes;
	private List<Tutor> listaT;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Fachada.getInstance();

	}

	public void handleRelatorio1() {

		pn_relatorio1.setVisible(true);
		pn_relatorio2.setVisible(false);
		pn_relatorio3.setVisible(false);
		carregarTutor();

	}

	public void handleRelatorio2() {

		pn_relatorio1.setVisible(false);
		pn_relatorio2.setVisible(true);
		pn_relatorio3.setVisible(false);

	}

	public void handleRelatorio3() {

		pn_relatorio1.setVisible(false);
		pn_relatorio2.setVisible(false);
		pn_relatorio3.setVisible(true);

	}

	public void carregarTutor() {

		List<String> tutores = new ArrayList<>();

		try {

			listaT = Fachada.getInstance().buscarALLTutor();
			for (Tutor t : listaT) {
				tutores.add(t.getNome());
			}

			listaNomes = FXCollections.observableArrayList(tutores);
			cb_nomeTutor.setItems(listaNomes);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String achaTutor() {
		String cpf = null;

		for (Tutor t : listaT) {
			if (cb_nomeTutor.getValue() != null && cb_nomeTutor.getValue().equals(t.getNome())) {
				cpf = t.getCpf();
			}
		}
		return cpf;
	}

	@FXML
	public void handleGerarRelatorio1() throws Exception {

		String cpf = achaTutor();

		List<Consulta> consultas = Fachada.getInstance().buscarRelatorio1(dt_inicio.getValue(), dt_fim.getValue(), cpf);
		List<Animal> animais = Fachada.getInstance().buscarAnimal(cpf);
		consultas_X_animais.getData().clear();
		XYChart.Series set = new XYChart.Series<>();

		for (Animal a : animais) {
			int qtd = 0;
			for (Consulta c : consultas) {
				if (a.getNumProntuario() == c.getProntuario()) {
					++qtd;
				}
			}

			set.getData().add(new XYChart.Data(a.getNome(), qtd));
		}

		consultas_X_animais.getData().addAll(set);

	}

}
