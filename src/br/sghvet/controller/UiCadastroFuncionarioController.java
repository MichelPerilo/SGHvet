package br.sghvet.controller;

import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Administrativo;
import br.sghvet.model.Auxiliar;
import br.sghvet.model.CargoAdm;
import br.sghvet.model.CargoAuxiliar;
import br.sghvet.model.CargoVeterinario;
import br.sghvet.model.TipoUsuario;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import br.sghvet.model.Usuario;
import br.sghvet.model.Veterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UiCadastroFuncionarioController implements Initializable {

	// Cadastrar

	@FXML
	Pane Pn1;

	@FXML
	private TextField textfield_nome;
	@FXML
	private TextField textfield_cpf;
	@FXML
	private TextField textfield_contato;
	@FXML
	private TextField textfield_email;
	@FXML
	private DatePicker datepicker_datanascimento;
	@FXML
	private ComboBox<Object> choicebox_setor;
	@FXML
	private ComboBox<Object> choicebox_cargo;
	@FXML
	private Button button_sar;
	@FXML
	private PasswordField passwordfield_senha;
	@FXML
	private TextField textfield_nomeusuario;
	@FXML
	private TextField textfield_crmv;

	// Atualizar ou deletar

	@FXML
	private Pane Pn2;

	@FXML
	private TextField textfield_nome1;

	@FXML
	private TextField textfield_cpf1;

	@FXML
	private DatePicker datepicker_datanascimento1;

	@FXML
	private TextField textfield_contato1;

	@FXML
	private TextField textfield_email1;

	@FXML
	private PasswordField passwordfield_senha1;

	@FXML
	private PasswordField passwordfield_confirmsenha1;
	@FXML
	private Button bt_atualizar;

	private Stage stage;
	private TipoUsuario tipo;
	private Object objeto;
	Alert alert = new Alert(AlertType.INFORMATION);


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Object> items = FXCollections.observableArrayList(TipoUsuario.values());
		choicebox_setor.setItems(items);

	}

	@FXML
	public void setCargoList() {

		if (choicebox_setor.getValue() != null) {
			switch ((TipoUsuario) choicebox_setor.getValue()) {

			case ADMINISTRATIVO:
				textfield_crmv.setVisible(false);
				ObservableList<Object> itemsadm = FXCollections.observableArrayList(CargoAdm.values());
				choicebox_cargo.setItems(itemsadm);
				break;
			case AUXILIAR:
				textfield_crmv.setVisible(false);
				ObservableList<Object> itemsauxiliar = FXCollections.observableArrayList(CargoAuxiliar.values());
				choicebox_cargo.setItems(itemsauxiliar);
				break;
			case VETERINARIO:
				textfield_crmv.setVisible(true);
				ObservableList<Object> itemsveterinario = FXCollections.observableArrayList(CargoVeterinario.values());
				choicebox_cargo.setItems(itemsveterinario);
				break;
			}
		}

	}

	public void handler_salvar() throws Exception {

		// reformular para usar fachada

		switch ((TipoUsuario) choicebox_setor.getValue()) {

		case ADMINISTRATIVO:
			try {
				Usuario user = new Usuario(textfield_cpf.getText(), TipoUsuario.ADMINISTRATIVO);
				Fachada.getInstance().cadastrarUsuario(user, passwordfield_senha.getText());
				Administrativo adm = new Administrativo(textfield_nome.getText(), textfield_cpf.getText(),
						datepicker_datanascimento.getValue(), (CargoAdm) choicebox_cargo.getValue(),
						textfield_contato.getText(), textfield_email.getText());
				Fachada.getInstance().cadastraAdm(user, adm);

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Novo Cadastro Efetuado");
				alert.setTitle("Confirmação");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					// ... user chose OK
					alert.close();
					stage.close();

				} else {
					// ... user chose CANCEL or closed the dialog
				}

			} catch (Exception integrityexception) {

							
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText("Ocorreu um erro na tentativa de cadastro");
				alert.setTitle("Erro");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					// ... user chose OK
					alert.close();
					stage.close();

				} else {
					// ... user chose CANCEL or closed the dialog
				}
				
			}

			break;
		case AUXILIAR:
			try {
				Usuario user = new Usuario(textfield_cpf.getText(), TipoUsuario.AUXILIAR);
				Fachada.getInstance().cadastrarUsuario(user, passwordfield_senha.getText());
				Auxiliar aux = new Auxiliar(textfield_nome.getText(), textfield_cpf.getText(),
						datepicker_datanascimento.getValue(), (CargoAuxiliar) choicebox_cargo.getValue(),
						textfield_contato.getText(), textfield_email.getText());
				Fachada.getInstance().cadastrarAuxiliar(user, aux);

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Novo Cadastro Efetuado");
				alert.setTitle("Confirmação");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					// ... user chose OK
					alert.close();
					stage.close();

				} else {
					// ... user chose CANCEL or closed the dialog
				}

			} catch (Exception integrityexception) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText("Ocorreu um erro na tentativa de cadastro");
				alert.setTitle("Erro");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					// ... user chose OK
					alert.close();
					stage.close();

				} else {
					// ... user chose CANCEL or closed the dialog
				}

			}

			break;
		case VETERINARIO:
			try {
				Usuario user = new Usuario(textfield_cpf.getText(), TipoUsuario.VETERINARIO);
				Fachada.getInstance().cadastrarUsuario(user, passwordfield_senha.getText());
				Veterinario vet = new Veterinario(textfield_nome.getText(), textfield_cpf.getText(),
						datepicker_datanascimento.getValue(), (CargoVeterinario) choicebox_cargo.getValue(),
						textfield_contato.getText(), textfield_email.getText(), textfield_crmv.getText());
				Fachada.getInstance().cadastrarVeterinario(user, vet);

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Novo Cadastro Efetuado");
				alert.setTitle("Confirmação");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					// ... user chose OK
					alert.close();
					stage.close();

				} else {
					// ... user chose CANCEL or closed the dialog
				}

			} catch (Exception integrityexception) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText("Ocorreu um erro na tentativa de cadastro");
				alert.setTitle("Erro");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					// ... user chose OK
					alert.close();
					stage.close();

				} else {
					// ... user chose CANCEL or closed the dialog
				}

			}

			break;

		default:

			break;
		}

	}

	public void setStage(Stage novoFuncionarioStage) {

		this.stage = novoFuncionarioStage;
		this.stage.initStyle(StageStyle.UNDECORATED);

	}

	private Stage getStage() {
		return stage;
	}

	@FXML
	public void fechar() {

		button_sar.getScene().getWindow().hide();
	}

	@FXML
	public void atualizar() throws Exception {
		
//		String[] data = datepicker_datanascimento1.getPromptText().split("/");
//		datepicker_datanascimento1 = new DatePicker();
//		LocalDate ld = LocalDate.of(Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(data[0]));
		
		
		if (bt_atualizar.getText().equals("Atualizar")) {

			textfield_nome1.setDisable(false);
			textfield_cpf1.setDisable(false);
			datepicker_datanascimento1.setDisable(false);
			textfield_contato1.setDisable(false);
			textfield_email1.setDisable(false);
			bt_atualizar.setText("Salvar");
			
			
            
		}

		if (bt_atualizar.getText().equals("Salvar")) {

			switch (tipo) {

			case ADMINISTRATIVO:

				Administrativo administrativo = (Administrativo) objeto;
				Administrativo adm = new Administrativo(textfield_nome1.getText(), textfield_cpf1.getText(),
						datepicker_datanascimento1.getValue(), administrativo.getCargo(), textfield_contato1.getText(),
						textfield_email1.getText());
				objeto = adm;
				Fachada.getInstance().atualizaAdm(adm);

				break;
			case AUXILIAR:

				Auxiliar auxiliar = (Auxiliar) objeto;
				Auxiliar auxi = new Auxiliar(textfield_nome1.getText(), textfield_cpf1.getText(),
						datepicker_datanascimento1.getValue(), auxiliar.getCargo(), textfield_contato1.getText(),
						textfield_email1.getText());
				objeto = auxi;
				Fachada.getInstance().atualizarAuxiliar(auxi);

				break;
			case VETERINARIO:

				Veterinario veterinario = (Veterinario) objeto;
				Veterinario vet = new Veterinario(textfield_nome1.getText(), textfield_cpf1.getText(),
						datepicker_datanascimento1.getValue(), veterinario.getCargo(), textfield_contato1.getText(),
						textfield_email1.getText(), veterinario.getCrmv());
				objeto = vet;
				Fachada.getInstance().atualizarVeterinario(vet);

				break;
			default:

				break;
			}

			textfield_nome1.setDisable(true);
			textfield_cpf1.setDisable(true);
			datepicker_datanascimento1.setDisable(true);
			textfield_contato1.setDisable(true);
			textfield_email1.setDisable(true);
			bt_atualizar.setText("Atualizar");
			
			alert.setHeaderText("ATUALIZADO COM SUCESSO");
			alert.showAndWait();
		}

	}

	@FXML
	public void deletar() throws Exception {

		switch (tipo) {

		case ADMINISTRATIVO:

			Administrativo administrativo = (Administrativo) objeto;
			Fachada.getInstance().deletarAdm(administrativo);

			break;
		case AUXILIAR:

			Auxiliar auxiliar = (Auxiliar) objeto;
			Fachada.getInstance().deletarAuxiliar(auxiliar);

			break;
		case VETERINARIO:

			Veterinario veterinario = (Veterinario) objeto;
			Fachada.getInstance().deletarVeterinario(veterinario);

			break;
		default:

			break;
		}
		
		alert.setHeaderText("UDUARIO DELETADO COM SUCESSO");
		alert.showAndWait();

	}

	public void carregaDados(TipoUsuario tp, Object obj) {

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		textfield_nome1.setDisable(true);
		textfield_cpf1.setDisable(true);
		datepicker_datanascimento1.setDisable(true);
		textfield_contato1.setDisable(true);
		textfield_email1.setDisable(true);

		switch (tp) {

		case ADMINISTRATIVO:

			Administrativo adm = (Administrativo) obj;
			textfield_nome1.setText(adm.getNome());
			textfield_cpf1.setText(adm.getCpf());
			datepicker_datanascimento1.setPromptText(adm.getDataNasc().format(formatador).toString());
			textfield_contato1.setText(adm.getContato());
			textfield_email1.setText(adm.getEmail());

			tipo = tp.ADMINISTRATIVO;
			objeto = adm;

			break;
		case AUXILIAR:

			Auxiliar aux = (Auxiliar) obj;
			textfield_nome1.setText(aux.getNome());
			textfield_cpf1.setText(aux.getCpf());
			datepicker_datanascimento1.setPromptText(aux.getDataNasc().format(formatador).toString());
			textfield_contato1.setText(aux.getContato());
			textfield_contato1.setText(aux.getContato());
			textfield_email1.setText(aux.getEmail());
			tipo = tp.AUXILIAR;
			objeto = aux;

			break;
		case VETERINARIO:

			Veterinario vet = (Veterinario) obj;
			textfield_nome1.setText(vet.getNome());
			textfield_cpf1.setText(vet.getCpf());
			datepicker_datanascimento1.setPromptText(vet.getDataNasc().format(formatador).toString());
			textfield_contato1.setText(vet.getContato());
			textfield_email1.setText(vet.getEmail());
			tipo = tp.VETERINARIO;
			objeto = vet;

			break;
		default:

			break;
		}

		Pn2.setVisible(true);
		Pn1.setVisible(false);

	}

}
