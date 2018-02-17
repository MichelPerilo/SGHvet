package br.sghvet.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.model.RequisicoesFarmaco;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.Initializable;

public class UIRequisicaoFarmacoController implements Initializable {

	@FXML
	private TextArea ta_descricao;

	@FXML
	private TextArea ta_justificativa;

	@FXML
	private TextField tx_qtd_solicitada;

	@FXML
	private Label lb_id;

	@FXML
	private Button bt_sair;
	@FXML
	private Button bt_salvar;

	private Stage stage;

	private RequisicoesFarmaco requisi��o;
	private int IDconsultaNewRequisi��o;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Fachada.getInstance();

	}

	@FXML
	public void fechar() {
		bt_sair.getScene().getWindow().hide();

	}

	@FXML
	public void salvar() {

		RequisicoesFarmaco r = new RequisicoesFarmaco(Integer.parseInt(tx_qtd_solicitada.getText()),
				ta_descricao.getText(), ta_justificativa.getText(), Fachada.getInstance().getCpfLogado());
		try {
			r.setNomeMedico(Fachada.getInstance().buscaVeterinario(Fachada.getInstance().getCpfLogado()).getNome());
			r.setIdConsulta(IDconsultaNewRequisi��o);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		try {
			Fachada.getInstance().cadastraReqFarmaco(r);
			bt_sair.getScene().getWindow().hide();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setStage(Stage solicitaFarma) {

		this.stage = solicitaFarma;
		this.stage.initStyle(StageStyle.UNDECORATED);

	}

	public RequisicoesFarmaco getRequisi��o() {
		return requisi��o;
	}

	public void setRequisi��o(RequisicoesFarmaco requisi��o) {
		this.requisi��o = requisi��o;
		
		 
		    ta_descricao.setEditable(false);
            ta_justificativa.setEditable(false);
            tx_qtd_solicitada.setEditable(false);
            
            ta_descricao.setText(requisi��o.getDescricao());
            ta_justificativa.setText(requisi��o.getJustificativa());
            tx_qtd_solicitada.setText(String.valueOf(requisi��o.getQtd()));
            lb_id.setText(String.valueOf(requisi��o.getId()));
		    bt_salvar.setVisible(false);
		
		
	}

	public int getIDconsultaNewRequisi��o() {
		return IDconsultaNewRequisi��o;
	}

	public void setIDconsultaNewRequisi��o(int iDconsultaNewRequisi��o) {
		IDconsultaNewRequisi��o = iDconsultaNewRequisi��o;
	}

}
