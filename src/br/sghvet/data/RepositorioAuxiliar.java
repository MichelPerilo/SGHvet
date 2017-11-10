package br.sghvet.data;

import java.sql.Connection;
import java.sql.SQLException;

import br.sghvet.model.Auxiliar;

public class RepositorioAuxiliar implements IRepositorioAuxiliar {

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
	public Auxiliar buscaAuxiliar(String cpf) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cadastrarAuxiliar(Auxiliar aux) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizarAuxiliar(Auxiliar aux) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarAuxiliar(Auxiliar aux) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


}
