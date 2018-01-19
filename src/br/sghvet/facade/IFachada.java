package br.sghvet.facade;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.Administrativo;
import br.sghvet.model.Animal;
import br.sghvet.model.Auxiliar;
import br.sghvet.model.Consulta;
import br.sghvet.model.Disponibilidade;
import br.sghvet.model.Endereco;
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
	public void carregarAgendamento() throws Exception;
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
	public List<RequisicaoExame> buscaReqExameCPF(String cpf) throws Exception;
	public List<RequisicaoExame> buscaReqExameVet(String cpf_vet) throws Exception;
	public List<RequisicaoExame> buscaReqExameProntuario(int id) throws Exception;
	public boolean cadastraReqExame(RequisicaoExame e) throws Exception;
	public boolean atualizaReqExame(RequisicaoExame e) throws Exception;
	public boolean deletarReqExame(int id) throws Exception;

	public ResultadoExame buscarRegistro(RequisicaoExame consulta) throws Exception;
	public boolean cadastrarRegistro(ResultadoExame registroConsulta) throws Exception;
	public boolean atualizarRegistro(ResultadoExame registroConsulta) throws Exception;     
	
	public void gerarPdfRequisicao(RequisicaoExame req) throws Exception;
	
	public void cadastrarHorario(Disponibilidade disp)	throws Exception;
	void atualizarHorario(Disponibilidade dispo) throws Exception;
	List<Disponibilidade> buscaHorarios(String cpf_vet) throws Exception;
	public void deletarHorario(Disponibilidade disp) throws Exception ;
	
	
	public boolean cadastrarConsulta(Consulta consulta) throws Exception;
	public boolean removerConsulta(Consulta consulta) throws Exception;	
	public boolean atualizarConsulta(Consulta consulta) throws Exception;
	public List<Consulta> buscarConsultaCpf(String cpf) throws Exception;
	public List<Consulta> buscarConsultaVet(String cpf) throws Exception;
	public List<Consulta> buscarConsultaPro(int prontuario) throws Exception;
	public List<Disponibilidade> buscaDisponibilidade(String horario) throws Exception;
	


}
