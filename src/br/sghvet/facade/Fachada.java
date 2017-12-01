package br.sghvet.facade;

import java.sql.Connection;

import br.sghvet.controller.*;
import br.sghvet.data.*;
import br.sghvet.model.*;

public class Fachada implements IFachada{
	
	private Connection conexao;
	
	private IControleLogin controlelogin;
	private IControlFuncionario controlfuncionario;
	
	public static Fachada instance;
	
	public Fachada() {
		this.controlelogin = new ControleLogin();
		this.controlfuncionario = new ControlFuncionario();
	}
	
	public static Fachada getInstance() {
		if(instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	@Override
	public void conectar() {  //executar após fazer login para persistir conexao
		controlfuncionario.conectar(conexao);
	}
	
	@Override
	public TipoUsuario loginUsuario(String cpf, String senha) throws Exception{ //salvar conexao
		TipoUsuario user = controlelogin.loginUsuario(cpf, senha);
		if(user!=null) {
			this.conexao = controlelogin.getConexao();
			conectar(); //testar se deveria ser aqui
		}
		return user;
	}
	
	@Override
	public Usuario buscaUsuario(String cpf) throws Exception{
		return controlfuncionario.buscaUsuario(cpf);
	}

	@Override
	public boolean cadastrarUsuario(Usuario user, String senha) throws Exception{
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
	
	
}
