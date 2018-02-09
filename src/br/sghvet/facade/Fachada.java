package br.sghvet.facade;

import java.sql.Connection;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.sghvet.controller.*;
import br.sghvet.data.*;
import br.sghvet.model.*;
import exceptions.ConectionException;

public class Fachada implements IFachada {

	private static Connection conexao;

	private IControleLogin controlelogin;
	private IControlFuncionario controlfuncionario;
	private IControlPaciente controlPaciente;
	private CadastroReqExame cadastroReqExame;
	private ControlPdf pdfControl;
	private IControlResultadoExame controlRegistro;
	private CadastroDisponibilidade cadastroDisp;
	private ICadastroConsulta cadastroConsulta;
	private RepositorioRacaEspecie repoRE;
	
	private String cpfLogado;
	
	private static Fachada instance;

	private Fachada() {
		
		this.controlelogin = new ControleLogin();
		this.controlfuncionario = new ControlFuncionario();
		this.cadastroReqExame = new CadastroReqExame();
		this.pdfControl = new ControlPdf();
		this.controlPaciente = new ControlPaciente();
		this.controlRegistro = new ControlResultadoExame();
		this.cadastroDisp = new CadastroDisponibilidade();
		this.cadastroConsulta = new CadastroConsulta();
		
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	public void conectar() { // executar após fazer login para persistir conexao
		controlfuncionario.conectar(conexao);
		controlPaciente.conectar(conexao);
		controlRegistro.conectar(conexao);
		cadastroReqExame.conectar(conexao);
		cadastroDisp.conectar(conexao);
		cadastroConsulta.conectar(conexao);
		
	}
	
	public void desconectar() {	//executar ao fazer logoff para reiniciar conexoes
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectar();
		this.controlelogin = new ControleLogin();
		this.controlfuncionario = new ControlFuncionario();
		this.cadastroReqExame = new CadastroReqExame();
		this.pdfControl = new ControlPdf();
		this.controlPaciente = new ControlPaciente();
		this.controlRegistro = new ControlResultadoExame();
		this.cadastroDisp = new CadastroDisponibilidade();
		this.cadastroConsulta = new CadastroConsulta();
		conexao = null;
	}
	
	public String getCpfLogado() {
		return this.cpfLogado;
	}

	public void carregarAgendamento() throws Exception {

		Connection conect;
		conect = new Conexao().getConexao("root", "");

		this.controlPaciente = new ControlPaciente();
		this.repoRE = new RepositorioRacaEspecie();

		controlPaciente.conectar(conect);
		repoRE.conectar(conect);
	}
	
	public List<String> buscarALLEspeciel() throws Exception{
		
		return repoRE.buscarALLEspeciel();
		
	}
	
	public List<String> buscarRaca(int cod) throws Exception{
		
		return repoRE.buscarRaca(cod);
	}
	
	
		

	@Override
	public Usuario loginUsuario(String cpf, String senha) throws Exception { // salvar conexao
		Usuario user = controlelogin.loginUsuario(cpf, senha);
		if (user != null) {
			this.conexao = controlelogin.getConexao();
			conectar();
			// if(conexao == null) {
			// System.out.println("blow this shit up");
			// }
		}
		cpfLogado = cpf;
		return user;
	}

	@Override
	public Usuario buscaUsuario(String cpf) throws Exception {
		return controlfuncionario.buscaUsuario(cpf);
	}

	@Override
	public boolean cadastrarUsuario(Usuario user, String senha) throws Exception {
		if (conexao == null) {
			System.out.println("blow this shit up");
		}
		controlfuncionario.conectar(conexao);
		return controlfuncionario.cadastrarUsuario(user, senha);
	}

	@Override
	public boolean atualizarUsuario(Usuario user) throws Exception {
		return controlfuncionario.atualizarUsuario(user);
	}

	@Override
	public boolean deletarUsuario(Usuario user) throws Exception {
		return controlfuncionario.deletarUsuario(user);
	}

	@Override
	public Veterinario buscaVeterinario(String cpf) throws Exception {
		return controlfuncionario.buscaVeterinario(cpf);
	}

	@Override
	public boolean cadastrarVeterinario(Usuario user, Veterinario vet) throws Exception {
		return controlfuncionario.cadastrarVeterinario(user, vet);
	}

	@Override
	public boolean atualizarVeterinario(Veterinario vet) throws Exception {
		return controlfuncionario.atualizarVeterinario(vet);
	}

	@Override
	public boolean deletarVeterinario(Veterinario vet) throws Exception {
		return controlfuncionario.deletarVeterinario(vet);
	}

	@Override
	public Administrativo buscaAdm(String cpf) throws Exception {
		return controlfuncionario.buscaAdm(cpf);
	}

	@Override
	public boolean cadastraAdm(Usuario user, Administrativo adm) throws Exception {
		return controlfuncionario.cadastraAdm(user, adm);
	}

	@Override
	public boolean atualizaAdm(Administrativo adm) throws Exception {
		return controlfuncionario.atualizaAdm(adm);
	}

	@Override
	public boolean deletarAdm(Administrativo adm) throws Exception {
		return controlfuncionario.deletarAdm(adm);
	}

	@Override
	public Auxiliar buscaAuxiliar(String cpf) throws Exception {
		return controlfuncionario.buscaAuxiliar(cpf);
	}

	@Override
	public boolean cadastrarAuxiliar(Usuario user, Auxiliar aux) throws Exception {
		return controlfuncionario.cadastrarAuxiliar(user, aux);
	}

	@Override
	public boolean atualizarAuxiliar(Auxiliar aux) throws Exception {
		return controlfuncionario.atualizarAuxiliar(aux);
	}

	@Override
	public boolean deletarAuxiliar(Auxiliar aux) throws Exception {
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
	public Animal buscaAnimalProntuario(int prontuario) throws Exception {
		return controlPaciente.buscaAnimalProntuario(prontuario);
	}
	
	@Override
	public List<Animal> allAnimals() throws Exception{
		return controlPaciente.allAnimals();
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
		
		controlPaciente.deletarTutor(t);
//		this.deletarEndereco(t.getEndereco());
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
	public void gerarPdfRequisicao(RequisicaoExame req) throws Exception {
		pdfControl.gerarPdfRequisicao(req);
	}

	@Override
	public List<Veterinario> buscaTodosVeterinario() throws Exception {
		return controlfuncionario.buscaTodosVeterinario();
	}

	@Override
	public List<Administrativo> buscaTodosAdm() throws Exception {
		return controlfuncionario.buscaTodosAdm();
	}

	@Override
	public List<Auxiliar> buscaTodosAuxiliar() throws Exception {
		return controlfuncionario.buscaTodosAuxiliar();
	}

	@Override
	public ResultadoExame buscarRegistro(Consulta consulta) throws Exception {
		return controlRegistro.buscarRegistro(consulta);
	}

	@Override
	public boolean cadastrarRegistro(ResultadoExame registroConsulta) throws Exception {
		return controlRegistro.cadastrarRegistro(registroConsulta);
	}

	@Override
	public boolean atualizarRegistro(ResultadoExame registroConsulta) throws Exception {
		return controlRegistro.atualizarRegistro(registroConsulta);
	}

	@Override
	public void cadastrarHorario(Disponibilidade disp) throws Exception {
		cadastroDisp.cadastrarHorario(disp);
	}

	@Override
	public void atualizarHorario(Disponibilidade dispo) throws Exception {
		cadastroDisp.atualizarHorario(dispo);
	}

	@Override
	public List<Disponibilidade> buscaHorarios(String cpf_vet) throws Exception {
		return cadastroDisp.buscaHorarios(cpf_vet);
	}
	
	@Override
	public List<Disponibilidade> buscaDisponibilidade(String horario) throws Exception {
		return cadastroDisp.buscaDisponibilidade(horario);
	}

	@Override
	public void deletarHorario(Disponibilidade disp) throws Exception {
		cadastroDisp.deletarHorario(disp);
	}
	
	
	public boolean cadastrarConsulta(Consulta consulta) throws Exception {
		return cadastroConsulta.cadastrarConsulta(consulta);
	}

	@Override
	public boolean removerConsulta(Consulta consulta) throws Exception {
		return cadastroConsulta.removerConsulta(consulta);
	}

	@Override
	public boolean atualizarConsulta(Consulta consulta) throws Exception {
		return cadastroConsulta.atualizarConsulta(consulta);
	}

	@Override
	public List<Consulta> buscarConsultaCpf(String cpf) throws Exception {
		return cadastroConsulta.buscarConsultaCpf(cpf);
	}

	@Override
	public List<Consulta> buscarConsultaVet(String cpf) throws Exception {
		return cadastroConsulta.buscarConsultaVet(cpf);
	}

	@Override
	public List<Consulta> buscarConsultasDoDia(String cpf, LocalDate data) throws Exception {
		return cadastroConsulta.buscarConsultasDoDia(cpf, data);
	}
	
	@Override
	public List<Consulta> buscarConsultaPro(int prontuario) throws Exception {
		return cadastroConsulta.buscarConsultaPro(prontuario);
	}
	
	@Override
	public List buscarALLConsulta() throws Exception {

		return cadastroConsulta.buscarALLConsultas();
	}

	@Override
	public Consulta buscarConsulta(String cpf) throws Exception {

		return cadastroConsulta.buscarConsultas(cpf);
	}

	@Override
	public void gerarPdfResultado(ResultadoExame result) throws Exception {
		pdfControl.gerarPdfResultado(result);
	}
	
	

}
