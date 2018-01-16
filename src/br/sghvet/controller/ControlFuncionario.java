package br.sghvet.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.sghvet.model.Administrativo;
import br.sghvet.model.Auxiliar;
import br.sghvet.model.Usuario;
import br.sghvet.model.Veterinario;

public class ControlFuncionario implements IControlFuncionario {

	private ICadastroUsuario cadastroUsuario;
	private ICadastroVeterinario cadastroVeterinario;
	private ICadastroAdm cadastroAdm;
	private ICadastroAuxiliar cadastroAuxiliar;

	private static Connection connection;

	public ControlFuncionario() {
		this.cadastroUsuario = new CadastroUsuario();
		this.cadastroVeterinario = new CadastroVeterinario();
		this.cadastroAdm = new CadastroAdm();
		this.cadastroAuxiliar = new CadastroAuxiliar();
	}

	@Override
	public void conectar(Connection conect) {
		// try {

		// if (ControlFuncionario.connection != null)
		// ControlFuncionario.connection.close();
		ControlFuncionario.connection = conect;
		cadastroUsuario.conectar(connection);
		cadastroVeterinario.conectar(connection);
		cadastroAdm.conectar(connection);
		cadastroAuxiliar.conectar(connection);
		// } catch (SQLException e) {

		// e.printStackTrace();
		// }
	}

	@Override
	public Usuario buscaUsuario(String cpf) throws Exception {
		return cadastroUsuario.buscarUsuario(cpf);
	}

	@Override
	public boolean cadastrarUsuario(Usuario user, String senha) throws Exception {
		return cadastroUsuario.cadastrarUsuario(user, senha);
	}

	@Override
	public boolean atualizarUsuario(Usuario user) throws Exception {
		return cadastroUsuario.atualizarUsuario(user);
	}

	@Override
	public boolean deletarUsuario(Usuario user) throws Exception {
		return cadastroUsuario.deletarUsuario(user);
	}

	@Override
	public Veterinario buscaVeterinario(String cpf) throws Exception {
		return cadastroVeterinario.buscaVeterinario(cpf);
	}

	@Override
	public boolean cadastrarVeterinario(Usuario user, Veterinario vet) throws Exception {
		return cadastroVeterinario.cadastrarVeterinario(vet);
	}

	@Override
	public boolean atualizarVeterinario(Veterinario vet) throws Exception {
		return cadastroVeterinario.atualizarVeterinario(vet);
	}

	@Override
	public boolean deletarVeterinario(Veterinario vet) throws Exception {
		return cadastroVeterinario.deletarVeterinario(vet);
	}

	@Override
	public Administrativo buscaAdm(String cpf) throws Exception {
		return cadastroAdm.buscaAdm(cpf);
	}

	@Override
	public boolean cadastraAdm(Usuario user, Administrativo adm) throws Exception {
		return cadastroAdm.cadastraAdm(adm);
	}

	@Override
	public boolean atualizaAdm(Administrativo adm) throws Exception {
		return cadastroAdm.atualizaAdm(adm);
	}

	@Override
	public boolean deletarAdm(Administrativo adm) throws Exception {
		return cadastroAdm.deletarAdm(adm);
	}

	@Override
	public Auxiliar buscaAuxiliar(String cpf) throws Exception {
		return cadastroAuxiliar.buscaAuxiliar(cpf);
	}

	@Override
	public boolean cadastrarAuxiliar(Usuario user, Auxiliar aux) throws Exception {
		return cadastroAuxiliar.cadastrarAuxiliar(aux);
	}

	@Override
	public boolean atualizarAuxiliar(Auxiliar aux) throws Exception {
		return cadastroAuxiliar.atualizarAuxiliar(aux);
	}

	@Override
	public boolean deletarAuxiliar(Auxiliar aux) throws Exception {
		return cadastroAuxiliar.deletarAuxiliar(aux);
	}

	@Override
	public List<Veterinario> buscaTodosVeterinario() throws Exception {
		return cadastroVeterinario.buscaTodosVeterinario();
	}

	@Override
	public List<Administrativo> buscaTodosAdm() throws Exception {
		return cadastroAdm.buscaTodosAdm();
	}

	@Override
	public List<Auxiliar> buscaTodosAuxiliar() throws Exception {
		return cadastroAuxiliar.buscaTodosAuxiliar();
	}

}
