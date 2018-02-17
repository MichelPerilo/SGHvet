package br.sghvet.facade;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import br.sghvet.model.Administrativo;
import br.sghvet.model.Animal;
import br.sghvet.model.Auxiliar;
import br.sghvet.model.Cirurgia;
import br.sghvet.model.Consulta;
import br.sghvet.model.Disponibilidade;
import br.sghvet.model.Endereco;
import br.sghvet.model.MembroCirurgia;
import br.sghvet.model.ResultadoExame;
import br.sghvet.model.RequisicaoExame;
import br.sghvet.model.TipoUsuario;
import br.sghvet.model.Tutor;
import br.sghvet.model.Usuario;
import br.sghvet.model.Veterinario;
import exceptions.ConectionException;

public interface IFachada {
	
	public void conectar();
	
	public void desconectar();
	public Usuario loginUsuario(String cpf, String senha) throws Exception;
	
	public Usuario buscaUsuario(String cpf) throws Exception; // Login
	public boolean cadastrarUsuario(Usuario user, String senha) throws Exception;
	public boolean atualizarUsuario(Usuario user) throws Exception;
	public boolean deletarUsuario(Usuario user) throws Exception;
	
	public Veterinario buscaVeterinario(String cpf)throws Exception;
	public List<Veterinario> buscaTodosVeterinario()throws Exception;
	public boolean cadastrarVeterinario(Usuario user, Veterinario vet) throws Exception;
	public boolean atualizarVeterinario(Veterinario vet) throws Exception;
	public boolean deletarVeterinario(Veterinario vet) throws Exception;
	
	public Administrativo buscaAdm(String cpf) throws Exception;
	public List<Administrativo> buscaTodosAdm()throws Exception;
	public boolean cadastraAdm(Usuario user, Administrativo adm) throws Exception;
	public boolean atualizaAdm(Administrativo adm) throws Exception;
	public boolean deletarAdm(Administrativo adm) throws Exception;
	
	public Auxiliar buscaAuxiliar(String cpf) throws Exception;
	public List<Auxiliar> buscaTodosAuxiliar()throws Exception;
	public boolean cadastrarAuxiliar(Usuario user, Auxiliar aux) throws Exception;
	public boolean atualizarAuxiliar(Auxiliar aux) throws Exception;
	public boolean deletarAuxiliar(Auxiliar aux)throws Exception;
		
	public boolean cadastrarAnimal(Animal a) throws Exception;
	public boolean atualizarAnimal(Animal a) throws Exception;
	public boolean deletarAnimal(Animal a) throws Exception;
	public List buscarAnimal(String cpfTutor) throws Exception;
	public Animal buscaAnimalProntuario(int prontuario) throws Exception;
	public List<Animal> allAnimals() throws Exception;
	
	public Tutor buscarTutor(String cpf) throws Exception;
	public List buscarALLTutor() throws Exception;
	public void cadastrarTutor(Tutor t) throws Exception;
	public void atualizarTutor(Tutor t) throws Exception;
	public void deletarTutor(Tutor t) throws Exception;
	
	public boolean cadastraEndereco(Endereco e1) throws Exception;
	public boolean atualizarEndereco(Endereco e1) throws Exception;
	public Endereco buscaEndereco(String cpf) throws Exception;
	public boolean deletarEndereco(Endereco e1) throws Exception;
	
	public RequisicaoExame buscaReqExame(int id) throws Exception;
	public List<RequisicaoExame> buscaReqExameCPF(int prontuario) throws Exception;
	public List<RequisicaoExame> buscaReqExameVet(String cpf_vet) throws Exception;
	public List<RequisicaoExame> buscaReqExameProntuario(int id) throws Exception;
	public boolean cadastraReqExame(RequisicaoExame e) throws Exception;
	public boolean atualizaReqExame(RequisicaoExame e) throws Exception;
	public boolean deletarReqExame(RequisicaoExame r1) throws Exception;

	public ResultadoExame buscarRegistro(Consulta consulta) throws Exception;
	public boolean cadastrarRegistro(ResultadoExame registroConsulta) throws Exception;
	public boolean atualizarRegistro(ResultadoExame registroConsulta) throws Exception;     
	
	public void gerarPdfRequisicao(RequisicaoExame req) throws Exception;
	public void gerarPdfResultado(ResultadoExame result) throws Exception;
	
	public void cadastrarHorario(Disponibilidade disp)	throws Exception;
	void atualizarHorario(Disponibilidade dispo) throws Exception;
	List<Disponibilidade> buscaHorarios(String cpf_vet) throws Exception;
	List<Disponibilidade> buscaDisponibilidade(String horario, LocalDate ld) throws Exception;
	public void deletarHorario(Disponibilidade disp) throws Exception ;
	
	
	public boolean cadastrarConsulta(Consulta consulta) throws Exception;
	public boolean removerConsulta(Consulta consulta) throws Exception;	
	public boolean atualizarConsulta(Consulta consulta) throws Exception;
	public List<Consulta> buscarConsultaCpf(String cpf) throws Exception;
	public List<Consulta> buscarConsultaVet(String cpf) throws Exception;
	public List<Consulta> buscarConsultaPro(int prontuario) throws Exception;
	public List<Consulta> buscarConsultasDoDia(String cpf, LocalDate data) throws Exception;
	public List buscarALLConsulta() throws Exception;
	public Consulta buscarConsulta(String cpf) throws Exception;

	boolean cadastrarCirurgia(Cirurgia cirugia) throws Exception;

	boolean removerCirurgia(Cirurgia cirurgia) throws Exception;

	boolean atualizarCirurgia(Cirurgia cirurgia) throws Exception;

	List<Cirurgia> buscarCirurgias(int prontuario_id) throws Exception;

	List<Cirurgia> buscarALLCirurgia() throws Exception;

	boolean cadastrarMembroCirurgia(MembroCirurgia membro) throws Exception;

	boolean removerMembroCirurgia(MembroCirurgia membro) throws Exception;

	boolean atualizarMembroCirurgia(MembroCirurgia membro) throws Exception;

	List<MembroCirurgia> buscarMembros(int cirurgia_id) throws Exception;

	List<MembroCirurgia> buscarCirurgias(String cpf_membro) throws Exception;

	boolean atualizarSTATUSConsulta(Consulta consulta) throws Exception;

	List<Consulta> buscarRelatorio1(LocalDate inicio, LocalDate fim, String cpf_tutor) throws Exception;

	List<Consulta> buscarRelatorio2(LocalDate inicio, LocalDate fim, String cpf_vet) throws Exception;

	List<RequisicaoExame> buscarALLExameImagem() throws Exception;

	List<RequisicaoExame> buscarALLExameLab() throws Exception;
	

	
	


}
