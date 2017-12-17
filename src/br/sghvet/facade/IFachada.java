package br.sghvet.facade;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.Administrativo;
import br.sghvet.model.Animal;
import br.sghvet.model.Auxiliar;
import br.sghvet.model.Endereco;
import br.sghvet.model.TipoUsuario;
import br.sghvet.model.Tutor;
import br.sghvet.model.Usuario;
import br.sghvet.model.Veterinario;
import exceptions.ConectionException;

public interface IFachada {
	
	public void conectar();
	public void carregarAgendamento() throws ConectionException;
	public TipoUsuario loginUsuario(String cpf, String senha) throws Exception;
	
	public Usuario buscaUsuario(String cpf) throws Exception; // Login
	public boolean cadastrarUsuario(Usuario user, String senha) throws Exception;
	public boolean atualizarUsuario(Usuario user) throws Exception;
	public boolean deletarUsuario(Usuario user) throws Exception;
	
	public Veterinario buscaVeterinario(String cpf)throws Exception;
	public boolean cadastrarVeterinario(Usuario user, Veterinario vet) throws Exception;
	public boolean atualizarVeterinario(Veterinario vet) throws Exception;
	public boolean deletarVeterinario(Veterinario vet) throws Exception;
	
	public Administrativo buscaAdm(String cpf) throws Exception;
	public boolean cadastraAdm(Usuario user, Administrativo adm) throws Exception;
	public boolean atualizaAdm(Administrativo adm) throws Exception;
	public boolean deletarAdm(Administrativo adm) throws Exception;
	
	public Auxiliar buscaAuxiliar(String cpf) throws Exception;
	public boolean cadastrarAuxiliar(Usuario user, Auxiliar aux) throws Exception;
	public boolean atualizarAuxiliar(Auxiliar aux) throws Exception;
	public boolean deletarAuxiliar(Auxiliar aux)throws Exception;
		
	public boolean cadastrarAnimal(Animal a) throws Exception;
	public boolean atualizarAnimal(Animal a) throws Exception;
	public boolean deletarAnimal(Animal a) throws Exception;
	public List buscarAnimal(String cpfTutor) throws Exception;
	
	public Tutor buscarTutor(String cpf) throws Exception;
	public List buscarALLTutor() throws Exception;
	public void cadastrarTutor(Tutor t) throws Exception;
	public void atualizarTutor(Tutor t) throws Exception;
	public void deletarTutor(Tutor t) throws Exception;
	
	public boolean cadastraEndereco(Endereco e1) throws Exception;
	public boolean atualizarEndereco(Endereco e1) throws Exception;
	public Endereco buscaEndereco(String cpf) throws Exception;
	public boolean deletarEndereco(Endereco e1) throws Exception;
	

}
