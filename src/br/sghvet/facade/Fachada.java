package br.sghvet.facade;

import java.sql.Connection;
import java.util.List;

import br.sghvet.controller.*;
import br.sghvet.data.*;
import br.sghvet.model.*;
import exceptions.ConectionException;

public class Fachada implements IFachada{
	
	private static Connection conexao;
	
	private IControleLogin controlelogin;
	private IControlFuncionario controlfuncionario;
	private IControlPaciente controlPaciente;
	private CadastroReqExame cadastroReqExame;
	private ControlPdf pdfControl; 
	
	public static Fachada instance;
	
	public Fachada(){
		this.controlelogin = new ControleLogin();
		this.controlfuncionario = new ControlFuncionario();
		this.cadastroReqExame = new CadastroReqExame();
		this.pdfControl = new ControlPdf();
		this.controlPaciente = new ControlPaciente();
	}
	
	public static Fachada getInstance(){
		if(instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	
	public void conectar(Connection conexao) {  //executar após fazer login para persistir conexao
		controlfuncionario.conectar(conexao);
		cadastroReqExame.conectar(conexao);
		controlPaciente.conectar(conexao);
	}
	
	public void carregarAgendamento() throws Exception {
		
		Connection conect;
		conect = new Conexao().getConexao("root", "");
		
		this.controlPaciente =  new ControlPaciente();
		
		
		controlPaciente.conectar(conect);
	}
	
	
	
	@Override
	public Usuario loginUsuario(String cpf, String senha) throws Exception{ //salvar conexao
		Usuario user = controlelogin.loginUsuario(cpf, senha);
		if(user!=null) {
			this.conexao = controlelogin.getConexao();
			conectar();
			//if(conexao == null) {
			//	System.out.println("blow this shit up");
			//}
		}
		return user;
	}
	
	@Override
	public Usuario buscaUsuario(String cpf) throws Exception{
		return controlfuncionario.buscaUsuario(cpf);
	}

	@Override
	public boolean cadastrarUsuario(Usuario user, String senha) throws Exception{
		if(conexao == null) {
			System.out.println("blow this shit up");
		}
		controlfuncionario.conectar(conexao);
		return controlfuncionario.cadastrarUsuario(user, senha);
	}

	@Override
	public boolean atualizarUsuario(Usuario user) throws Exception{
		return controlfuncionario.atualizarUsuario(user);
	}

	@Override
	public boolean deletarUsuario(Usuario user) throws Exception{
		return controlfuncionario.deletarUsuario(user);
	}
	

	@Override
	public Veterinario buscaVeterinario(String cpf)throws Exception{
		return controlfuncionario.buscaVeterinario(cpf);
	}

	@Override
	public boolean cadastrarVeterinario(Usuario user, Veterinario vet) throws Exception{
		return controlfuncionario.cadastrarVeterinario(user, vet);
	}

	@Override
	public boolean atualizarVeterinario(Veterinario vet) throws Exception{
		return controlfuncionario.atualizarVeterinario(vet);
	}

	@Override
	public boolean deletarVeterinario(Veterinario vet) throws Exception{
		return controlfuncionario.deletarVeterinario(vet);
	}
	

	@Override
	public Administrativo buscaAdm(String cpf) throws Exception{
		return controlfuncionario.buscaAdm(cpf);
	}

	@Override
	public boolean cadastraAdm(Usuario user, Administrativo adm) throws Exception{
		return controlfuncionario.cadastraAdm(user, adm);
	}

	@Override
	public boolean atualizaAdm(Administrativo adm) throws Exception{
		return controlfuncionario.atualizaAdm(adm);
	}

	@Override
	public boolean deletarAdm(Administrativo adm) throws Exception{
		return controlfuncionario.deletarAdm(adm);
	}
	

	@Override
	public Auxiliar buscaAuxiliar(String cpf) throws Exception{
		return controlfuncionario.buscaAuxiliar(cpf);
	}

	@Override
	public boolean cadastrarAuxiliar(Usuario user, Auxiliar aux) throws Exception{
		return controlfuncionario.cadastrarAuxiliar(user, aux);
	}

	@Override
	public boolean atualizarAuxiliar(Auxiliar aux) throws Exception{
		return controlfuncionario.atualizarAuxiliar(aux);
	}

	@Override
	public boolean deletarAuxiliar(Auxiliar aux)throws Exception{
		return controlfuncionario.deletarAuxiliar(aux);
	}

	@Override
	public boolean cadastrarAnimal(Animal a) throws Exception {
		
		return controlPaciente.cadastrarAnimal(a);
	}

	@Override
	public boolean atualizarAnimal(Animal a) throws Exception {
		
		return controlPaciente.atualizarAnimal(a);
	}

	@Override
	public boolean deletarAnimal(Animal a) throws Exception {
		
		return controlPaciente.deletarAnimal(a);
	}

	@Override
	public List buscarAnimal(String cpfTutor) throws Exception {
		
		return controlPaciente.buscarAnimal(cpfTutor);
	}
	
	@Override
	public Animal buscaAnimalProntuario(int prontuario) throws Exception{
		return controlPaciente.buscaAnimalProntuario(prontuario);
	}

	@Override
	public Tutor buscarTutor(String cpf) throws Exception {
		
		Tutor t = controlPaciente.buscarTutor(cpf);
		t.setEndereço(controlPaciente.buscaEndereco(cpf));
		
		return t;
	}

	@Override
	public List buscarALLTutor() throws Exception {
		
		return controlPaciente.buscarALLTutor();
	}

	@Override
	public void cadastrarTutor(Tutor t) throws Exception {
		controlPaciente.cadastrarTutor(t);
		this.cadastraEndereco(t.getEndereco());		
	}

	@Override
	public void atualizarTutor(Tutor t) throws Exception {
			
		controlPaciente.atualizarTutor(t);
		controlPaciente.atualizarEndereco(t.getEndereco());		
	}

	@Override
	public void deletarTutor(Tutor t) throws Exception {
		
		this.deletarEndereco(t.getEndereco());
		controlPaciente.deletarTutor(t);						
	}

	@Override
	public boolean cadastraEndereco(Endereco e1) throws Exception {
		
		return controlPaciente.cadastraEndereco(e1);
	}

	@Override
	public boolean atualizarEndereco(Endereco e1) throws Exception {
		
		return controlPaciente.atualizarEndereco(e1);
	}

	@Override
	public Endereco buscaEndereco(String cpf) throws Exception {
		
		return controlPaciente.buscaEndereco(cpf);
	}

	@Override
	public boolean deletarEndereco(Endereco e1) throws Exception {
		
		return controlPaciente.deletarEndereco(e1);
	}

	@Override
	public RequisicaoExame buscaReqExame(int id) throws Exception {
		return cadastroReqExame.buscaReqExame(id);
	}

	@Override
	public List<RequisicaoExame> buscaReqExameCPF(String cpf) throws Exception {
		return cadastroReqExame.buscaReqExameCPF(cpf);
	}

	@Override
	public List<RequisicaoExame> buscaReqExameVet(String cpf_vet) throws Exception {
		return cadastroReqExame.buscaReqExameVet(cpf_vet);
	}

	@Override
	public List<RequisicaoExame> buscaReqExameProntuario(int id) throws Exception {
		return cadastroReqExame.buscaReqExameProntuario(id);
	}

	@Override
	public boolean cadastraReqExame(RequisicaoExame e) throws Exception {
		return cadastroReqExame.cadastraReqExame(e);
	}

	@Override
	public boolean atualizaReqExame(RequisicaoExame e) throws Exception {
		return cadastroReqExame.atualizaReqExame(e);
	}

	@Override
	public boolean deletarReqExame(int id) throws Exception {
		return cadastroReqExame.deletarReqExame(id);
	}
	
	@Override
	public void gerarPdfRequisicao(RequisicaoExame req) throws Exception{
		pdfControl.gerarPdfRequisicao(req);
	}
	
	
}
