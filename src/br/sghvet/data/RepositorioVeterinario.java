package br.sghvet.data;

import java.sql.Connection;
import java.sql.SQLException;

import br.sghvet.model.Veterinario;

public class RepositorioVeterinario implements IRepositorioVeterinario {

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
	public Veterinario buscaVeterinario(String cpf) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cadastrarVeterinario(Veterinario vet) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizarVeterinario(Veterinario vet) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarVeterinario(Veterinario vet) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


}
