package br.sghvet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.sghvet.facade.Fachada;
import br.sghvet.facade.IFachada;
import br.sghvet.model.Administrativo;
import br.sghvet.model.Auxiliar;
import br.sghvet.model.CargoAdm;
import br.sghvet.model.CargoAuxiliar;
import br.sghvet.model.CargoVeterinario;
import br.sghvet.model.TipoUsuario;
import br.sghvet.model.Veterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UiGerenciamentoPessoasController implements Initializable{

	@FXML
	private Button button_novocadastro;
	@FXML
	private ListView listview_funcionarios;
	@FXML
	private ChoiceBox choicebox_setor;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		ObservableList<TipoUsuario> items = FXCollections.observableArrayList (TipoUsuario.values());
	       choicebox_setor.setItems(items);
			
	}
	
	public void setLisView() throws Exception{
		IFachada fachada = new Fachada();	
		switch((TipoUsuario) choicebox_setor.getValue()) {
		
		case ADMINISTRATIVO :
			listview_funcionarios.setItems(null);
			ObservableList<Object> adms = FXCollections.observableArrayList (fachada.buscaTodosAdm());
			listview_funcionarios.setItems(adms);
			break;
		case AUXILIAR :
			listview_funcionarios.setItems(null);
			ObservableList<Object> auxs = FXCollections.observableArrayList (fachada.buscaTodosAuxiliar());
			listview_funcionarios.setItems(auxs);
			
			break;
		case VETERINARIO :
			listview_funcionarios.setItems(null);
			ObservableList<Object> vets = FXCollections.observableArrayList (fachada.buscaTodosVeterinario());
			listview_funcionarios.setItems(vets);
			break;
		default:
			
			break;
		}
	}
	
	
	@FXML
	public void handler_NovoCadastro() throws IOException{
		showUiNovoCadastro();
	    
	}
	
	
	    
	 public void showUiNovoCadastro() throws IOException{
		 FXMLLoader loader = new FXMLLoader();
	     loader.setLocation(UiCadastroFuncionarioController.class.getResource("../view/fxml_ui_cadastro_funcionario.fxml"));
	     AnchorPane page = (AnchorPane) loader.load();
	     Stage cadastroFuncionario = new Stage();
	     cadastroFuncionario.setTitle("Novo Funcionario");
	     Scene scene = new Scene(page);
	     cadastroFuncionario.setScene(scene);
	     //cadastroFuncionario.getIcons().add(new Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
	     cadastroFuncionario.setResizable(false);
	        
	     UiCadastroFuncionarioController controller = loader.getController();
	     controller.setStage(cadastroFuncionario);
	        
	     cadastroFuncionario.showAndWait();
	 }
	 
	 @FXML
	 public void handler_ClicarFuncionario() throws IOException{
			 Object o  = listview_funcionarios.getSelectionModel().getSelectedItem();
			 showUiEditarCadastro(o);
		 
	 }
	 
	 public void showUiEditarCadastro(Object o) throws IOException{
		 FXMLLoader loader = new FXMLLoader();
	     loader.setLocation(UiCadastroFuncionarioController.class.getResource("../view/fxml_ui_cadastro_funcionario.fxml"));
	     AnchorPane page = (AnchorPane) loader.load();
	     Stage cadastroFuncionario = new Stage();
	     cadastroFuncionario.setTitle("Editar Funcionario");
	     Scene scene = new Scene(page);
	     cadastroFuncionario.setScene(scene);
	     //cadastroFuncionario.getIcons().add(new Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
	     cadastroFuncionario.setResizable(false);
	        
	     UiCadastroFuncionarioController controller = loader.getController();
	     controller.setStage(cadastroFuncionario);
	     controller.label_titulo.setText("Dados do Usuário");
	    
	     if ((TipoUsuario) choicebox_setor.getValue() == TipoUsuario.ADMINISTRATIVO){
	    	Administrativo adm = (Administrativo) o;
	    	controller.textfield_nome.setText(adm.getNome());
	    	controller.textfield_cpf.setText(adm.getCpf());
	    	controller.textfield_contato.setText(adm.getContato());
	    	controller.textfield_email.setText(adm.getEmail());
	    	controller.choicebox_setor.setValue(TipoUsuario.ADMINISTRATIVO);
	    	controller.setCargoList();
	    	controller.choicebox_cargo.setValue((CargoAdm)adm.getCargo());
	    	controller.datepicker_datanascimento.setValue(adm.getDataNasc());
	    	controller.button_salvar.setDisable(true);
	    	controller.button_salvar.setVisible(false);
	    	controller.getButton_salvar2().setDisable(false);
	    	controller.getButton_salvar2().setVisible(true);
	    	controller.passwordfield_senha.setVisible(false);
	    	controller.getLabel_senha().setVisible(false);
	    	
	    	
		 }else if ((TipoUsuario) choicebox_setor.getValue() == TipoUsuario.VETERINARIO){
			Veterinario vet = (Veterinario) o;
			controller.textfield_nome.setText(vet.getNome());
	    	controller.textfield_cpf.setText(vet.getCpf());
	    	controller.textfield_contato.setText(vet.getContato());
	    	controller.textfield_email.setText(vet.getEmail());
	    	controller.choicebox_setor.setValue(TipoUsuario.VETERINARIO);
	    	controller.setCargoList();
	    	controller.choicebox_cargo.setValue((CargoVeterinario) vet.getCargo());
	    	controller.datepicker_datanascimento.setValue(vet.getDataNasc());
	    	controller.textfield_crmv.setText(vet.getCrmv());
	    	controller.button_salvar.setDisable(true);
	    	controller.button_salvar.setVisible(false);
	    	controller.getButton_salvar2().setDisable(false);
	    	controller.getButton_salvar2().setVisible(true);
	    	controller.passwordfield_senha.setVisible(false);
	    	controller.getLabel_senha().setVisible(false);
		 } else {
			 Auxiliar aux = (Auxiliar) o;
			 controller.textfield_nome.setText(aux.getNome());
		    	controller.textfield_cpf.setText(aux.getCpf());
		    	controller.textfield_contato.setText(aux.getContato());
		    	controller.textfield_email.setText(aux.getEmail());
		    	controller.choicebox_setor.setValue(TipoUsuario.AUXILIAR);
		    	controller.setCargoList();
		    	controller.choicebox_cargo.setValue((CargoAuxiliar) aux.getCargo());
		    	controller.datepicker_datanascimento.setValue(aux.getDataNasc());
		    	controller.button_salvar.setDisable(true);
		    	controller.button_salvar.setVisible(false);
		    	controller.getButton_salvar2().setDisable(false);
		    	controller.getButton_salvar2().setVisible(true);
		    	controller.passwordfield_senha.setVisible(false);
		    	controller.getLabel_senha().setVisible(false);
		 }
	     
	     cadastroFuncionario.showAndWait();
	 }
	 

}
