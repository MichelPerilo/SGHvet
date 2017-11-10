package br.sghvet.data;

import java.sql.Connection;
import java.sql.SQLException;

import br.sghvet.model.Usuario;

public class RepositorioUsuario implements IRepositorioUsuario{

	private Connection connection;
	
	@Override
	public void conectar(Connection conect) {
			try {
				if (this.connection != null)
					this.connection.close();
				
				this.connection = conect;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public Usuario buscaUsuario(String cpf, String senha) throws Exception {
		return null;
	}

	@Override
	public boolean cadastrarUsuario(Usuario user) throws Exception {
		return false;
	}

	@Override
	public boolean atualizarUsuario(Usuario user) throws Exception {
		return false;
	}

	@Override
	public boolean deletarUsuario(Usuario user) throws Exception {
		return false;
	}


}
