package br.sghvet.data;

import java.sql.Connection;
import java.sql.SQLException;

import br.sghvet.model.Administrativo;

public class RepositorioAdm implements IRepositorioAdm {

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
	public Administrativo buscaAdm(String cpf) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cadastraAdm(Administrativo adm) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizaAdm(Administrativo adm) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarAdm(Administrativo adm) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
