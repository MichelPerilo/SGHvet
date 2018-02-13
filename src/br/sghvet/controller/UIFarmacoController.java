package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import br.sghvet.facade.Fachada;
import br.sghvet.model.Consulta;
import br.sghvet.model.Item_Estoque;
import br.sghvet.model.Remedio;
import br.sghvet.model.Requisicoes;
import br.sghvet.model.Tipo_Remedio;
import br.sghvet.model.Tutor;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author Raylison
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UIFarmacoController implements Initializable {

	// Buscar remedio por tipo

	@FXML
	private Button tx_Busca_OK;

	@FXML
	private TextField tx_Busca_remedio;

	@FXML
	private ComboBox<String> cb_selecionar_tipo;
	// Novo Medicamento

	@FXML
	private Button bt_Novo_remedio;

	// Tabela de itens de estoque

	@FXML
	private TableView<Item_Estoque> tv_Estoque;

	@FXML
	private TableColumn<Item_Estoque, Integer> tc_R_ID;

	@FXML
	private TableColumn<Item_Estoque, String> tc_R_Tipo;

	@FXML
	private TableColumn<Item_Estoque, Integer> tc_R_CDR;

	@FXML
	private TableColumn<Item_Estoque, String> tc_R_Nome;
	
	private ObservableList<Item_Estoque> observableListItem_Estoque;
	

	// Medicamento selecionado

	String idEstoqueSelecionado;

	@FXML
	private Pane pn_NovoProduto;

	@FXML
	private Label lb_data_vencimento_remedio;

	@FXML
	private Label lb_id_remedio;

	@FXML
	private TextField tx_nome_remedio;

	@FXML
	private Label lb_tipo_remedio;

	@FXML
	private TextField tx_qtd_remedio;

	@FXML
	private Button bt_atualizar_remedio;

	@FXML
	private Button bt_salvar_remedio;

	@FXML
	private Button bt_deletar_remedio;

	@FXML
	private TextArea tx_descricap_remedio;

	@FXML
	private Label lb_data_cadastro_remedio;

	@FXML
	private DatePicker dp_data_vencimento;

	@FXML
	private TextArea tx_restricao_remedio;

	@FXML
	private ComboBox<String> cb_tipo_rremedio;

	@FXML
	private Pane pn_NovoProduto2;
	
	@FXML
	private Pane pn_novo_salvar;

	// Pesquisa Farmaco

	@FXML
	private TextField tx_pesquisar_requisição;

	@FXML
	private Button bt_pesquisar_requisição;

	// Requisicao selecionada

	@FXML
	private Label lb_id_requisicao;

	@FXML
	private Label lb_qtd_requisicao;

	@FXML
	private Button bt_liberar_requisicao;

	@FXML
	private TableView<Requisicoes> tv_Requisições;

	@FXML
	private TableColumn<Requisicoes, String> tc_R_id;

	@FXML
	private TableColumn<Requisicoes, String> tc_R_QTD;

	@FXML
	private TableColumn<Requisicoes, String> tc_R_Clinico;
	
	private ObservableList<Requisicoes> observableListRequisicoes;
	

	// Painel pessoal

	@FXML
	private Label lb_Logado;

	@FXML
	private Button bt_Logoff;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Fachada.getInstance();		
		FuncionarioLogado();
		setCB();
		carregarTableViewRemedio();

	}
	
	public void carregarTableViewRemedio() {

		tc_R_ID.setCellValueFactory(new PropertyValueFactory<>("id_intem_estoque"));
		tc_R_Tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tc_R_CDR.setCellValueFactory(new PropertyValueFactory<>("codigo_remedio_ie"));
		tc_R_Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		try {
			observableListItem_Estoque = FXCollections.observableArrayList(Fachada.getInstance().buscarALLIntem_Estoque());
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		tv_Estoque.setItems(observableListItem_Estoque);
	}
	
	
	

	@FXML
	public void handlerPesquisarProduto() throws Exception {
		
		
		limpaRemedio();
		pn_NovoProduto.setVisible(false);
		pn_NovoProduto2.setVisible(false);
 
		if (tx_Busca_remedio.getText() != null && !tx_Busca_remedio.getText().equals(""))
			fazBusca(tx_Busca_remedio.getText());

	}
	
	
	@FXML
	public void clicarMouseItemListViewIntemRemedio() throws IOException {

		pn_NovoProduto.setVisible(false);
		pn_NovoProduto2.setVisible(false);
		Item_Estoque ie = tv_Estoque.getSelectionModel().getSelectedItem();
		fazBusca(String.valueOf(ie.getCodigo_remedio_ie()));

	}
	

	public void fazBusca(String id) {

		Item_Estoque ie;
		Remedio r;

		try {
			ie = Fachada.getInstance().buscaIntem_Estoque(id);
			r = Fachada.getInstance().buscaRemedio(ie.getCodigo_remedio_ie());
			idEstoqueSelecionado = String.valueOf(ie.getId_intem_estoque());

			
		
			tx_nome_remedio.setEditable(false);
			tx_qtd_remedio.setEditable(false);
			tx_descricap_remedio.setEditable(false);
			tx_restricao_remedio.setEditable(false);

			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			lb_data_cadastro_remedio.setText(ie.getData_entrada().format(formatador));
			lb_data_vencimento_remedio.setText(ie.getData_validade().format(formatador).toString());
			lb_tipo_remedio.setText(r.getTipo().toString());
			tx_nome_remedio.setText(r.getNome());
			tx_qtd_remedio.setText(String.valueOf(ie.getQtd_atual()));
			tx_descricap_remedio.setText(r.getDescricao());
			lb_id_remedio.setText(String.valueOf(ie.getCodigo_remedio_ie()));

			tx_restricao_remedio.setText(r.getRestricao());
			carregarTableViewRemedio();


		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	@FXML
	public void handlerAtualizarRemedio() throws Exception {

		setCB();
		pn_NovoProduto.setVisible(true);
		pn_NovoProduto2.setVisible(true);
		

		bt_atualizar_remedio.setVisible(false);
		bt_salvar_remedio.setVisible(true);
		tx_nome_remedio.setEditable(true);
		tx_qtd_remedio.setEditable(true);
		tx_descricap_remedio.setEditable(true);
		tx_restricao_remedio.setEditable(true);

	}

	@FXML
	public void handlerSalvarRemedio() throws Exception {

		
		pn_NovoProduto.setVisible(false);
		pn_NovoProduto2.setVisible(false);
		lb_data_vencimento_remedio.setVisible(true);
		lb_tipo_remedio.setVisible(true);

		bt_atualizar_remedio.setVisible(true);
		bt_salvar_remedio.setVisible(false);
		tx_nome_remedio.setEditable(false);
		tx_qtd_remedio.setEditable(false);
		tx_descricap_remedio.setEditable(false);
		tx_restricao_remedio.setEditable(false);

		LocalDate dataNew;

		Item_Estoque ie;
		Remedio r = null;

		if (dp_data_vencimento.getValue() == null) {

			String[] Convertedate = lb_data_vencimento_remedio.getText().split("/");
			dataNew = LocalDate.of(Integer.parseInt(Convertedate[2]), Integer.parseInt(Convertedate[1]),
					Integer.parseInt(Convertedate[0]));

		} else {
			dataNew = dp_data_vencimento.getValue();
		}

		ie = new Item_Estoque(dataNew, Integer.parseInt(tx_qtd_remedio.getText()),
				Integer.parseInt(lb_id_remedio.getText()));
		ie.setId_intem_estoque(Integer.parseInt(idEstoqueSelecionado));
		Fachada.getInstance().atualizaIntem_Estoque(ie);

		if (cb_tipo_rremedio.getValue() == null) {

			if (lb_tipo_remedio.getText().equals(Tipo_Remedio.Analgesicos.toString()))
				r = new Remedio(tx_nome_remedio.getText(), Tipo_Remedio.Analgesicos, tx_descricap_remedio.getText(),
						tx_restricao_remedio.getText());

			else if (lb_tipo_remedio.getText().equals(Tipo_Remedio.Antibioticos.toString()))
				r = new Remedio(tx_nome_remedio.getText(), Tipo_Remedio.Antibioticos, tx_descricap_remedio.getText(),
						tx_restricao_remedio.getText());

			else if (lb_tipo_remedio.getText().equals(Tipo_Remedio.Antiflamatorio.toString()))
				r = new Remedio(tx_nome_remedio.getText(), Tipo_Remedio.Antiflamatorio,
						tx_descricap_remedio.getText(), tx_restricao_remedio.getText());

		} else {

			if (cb_tipo_rremedio.getValue().equals(Tipo_Remedio.Analgesicos.toString()))
				r = new Remedio(tx_nome_remedio.getText(), Tipo_Remedio.Analgesicos, tx_descricap_remedio.getText(),
						tx_restricao_remedio.getText());

			else if (cb_tipo_rremedio.getValue().equals(Tipo_Remedio.Antibioticos.toString()))
				r = new Remedio(tx_nome_remedio.getText(), Tipo_Remedio.Antibioticos, tx_descricap_remedio.getText(),
						tx_restricao_remedio.getText());

			else if (cb_tipo_rremedio.getValue().equals(Tipo_Remedio.Antiflamatorio.toString()))
				r = new Remedio(tx_nome_remedio.getText(), Tipo_Remedio.Antiflamatorio,
						tx_descricap_remedio.getText(), tx_restricao_remedio.getText());
			

		}

		r.setId(Integer.parseInt(lb_id_remedio.getText()));

		Fachada.getInstance().atualizaIntem_Estoque(ie);
		Fachada.getInstance().atualizaRemedio(r);
		carregarTableViewRemedio();
		handlerPesquisarProduto();
		
		
 
	}

	@FXML
	public void handlerDeletarRemedio() throws Exception {

		Fachada.getInstance().deletarIntem_Estoque(Fachada.getInstance().buscaIntem_Estoque(idEstoqueSelecionado));
		carregarTableViewRemedio();
		limpaRemedio();

	}

	@FXML
	public void handlerNovoRemedio() throws Exception {
		
		limpaRemedio();
		pn_NovoProduto.setVisible(true);
		pn_NovoProduto2.setVisible(true);
		pn_novo_salvar.setVisible(true);
		lb_data_vencimento_remedio.setVisible(false);
		lb_tipo_remedio.setVisible(false);
       	tx_qtd_remedio.setEditable(true);
       	tx_nome_remedio.setEditable(true);
		tx_descricap_remedio.setEditable(true);
		tx_restricao_remedio.setEditable(true);
		
		        
        
	}
	
	
	public void limpaRemedio() {
		
		tx_nome_remedio.setText("");
		tx_qtd_remedio.setText("");
		tx_descricap_remedio.setText("");
		tx_restricao_remedio.setText("");
		lb_data_cadastro_remedio.setText("");
		lb_data_vencimento_remedio.setText("");
        lb_id_remedio.setText("");
        lb_tipo_remedio.setText("");
        
	}
	
	
	@FXML
	public void handlerSalvarNewRemedio() throws Exception{
		
		
		Item_Estoque ie;
		Remedio r = null;

	
		if (cb_tipo_rremedio.getValue().equals(Tipo_Remedio.Analgesicos.toString()))
			r = new Remedio(tx_nome_remedio.getText(), Tipo_Remedio.Analgesicos, tx_descricap_remedio.getText(),
					tx_restricao_remedio.getText());

		else if (cb_tipo_rremedio.getValue().equals(Tipo_Remedio.Antibioticos.toString())) {
			r = new Remedio(tx_nome_remedio.getText(), Tipo_Remedio.Antibioticos, tx_descricap_remedio.getText(),
					tx_restricao_remedio.getText());
              System.out.println("chegouijhdfihsdfhio");
		}
		else if (cb_tipo_rremedio.getValue().equals(Tipo_Remedio.Antiflamatorio.toString()))
			r = new Remedio(tx_nome_remedio.getText(), Tipo_Remedio.Antiflamatorio, tx_descricap_remedio.getText(),
					tx_restricao_remedio.getText());

		
		Fachada.getInstance().cadastrarRemedio(r);		
		ie = new Item_Estoque(dp_data_vencimento.getValue(), Integer.parseInt(tx_qtd_remedio.getText()),Fachada.getInstance().idCadastrado(r.getNome()));
					
		Fachada.getInstance().cadastrarIntem_Estoque(ie);
		carregarTableViewRemedio();
		
		
		pn_NovoProduto.setVisible(false);
		pn_NovoProduto2.setVisible(false);
		pn_novo_salvar.setVisible(false);
		lb_data_vencimento_remedio.setVisible(true);
		lb_tipo_remedio.setVisible(true);
		
		tx_nome_remedio.setEditable(false);
		tx_qtd_remedio.setEditable(false);
		tx_descricap_remedio.setEditable(false);
		tx_restricao_remedio.setEditable(false);
		
		limpaRemedio();
	
		
	}
	
	
	
	public void setCB() {
		
	
		List<String> listaTipo = new ArrayList<>();
		listaTipo.add(Tipo_Remedio.Analgesicos.toString());
		listaTipo.add(Tipo_Remedio.Antibioticos.toString());
		listaTipo.add(Tipo_Remedio.Antiflamatorio.toString());
				
		ObservableList<String> listTipos = FXCollections.observableArrayList(listaTipo);
		cb_tipo_rremedio.setItems(listTipos);
		cb_selecionar_tipo.setItems(listTipos);
		
	}
	
	
	@FXML
	public void logoff() {
		try {

			Stage stageCLose = (Stage) bt_Logoff.getScene().getWindow(); // Obtendo a janela atual
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
			
			e.printStackTrace();
		}

	}
	
	
	public void FuncionarioLogado() {

		try {
			String nome = Fachada.getInstance().buscaAdm(Fachada.getInstance().getCpfLogado()).getNome();
			System.out.println(nome);
			lb_Logado.setText(nome);
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}
	
	
	
	

}
