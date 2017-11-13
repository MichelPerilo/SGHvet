package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import br.sghvet.model.CargoVeterinario;
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

		String query = "select * from veterinario where cpf = ?";
		
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();
		
		Veterinario v1 = preencherVet(rs);
		ps.close();
		rs.close();
		
		return v1;
	}


	@Override
	public boolean cadastrarVeterinario(Veterinario vet) throws Exception {
		
		String query = "insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values (?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, vet.getNome());
		ps.setString(2,vet.getCpf());
		ps.setString(3, vet.getDataNasc().toString());
		ps.setString(4, vet.getCargo().toString());
		ps.setString(5, vet.getContato());
		ps.setString(6, vet.getEmail());
		ps.setString(7, vet.getCrmv());
		
		return executar(ps);
	}

	@Override
	public boolean atualizarVeterinario(Veterinario vet) throws Exception {
		
		String query = "update veterinario set nome = ?, dataNasc = ?, cargo = ?, contato = ?, email = ?, crmv = ?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, vet.getNome());
		ps.setString(2, vet.getDataNasc().toString());
		ps.setString(3, vet.getCargo().toString());
		ps.setString(4, vet.getContato());
		ps.setString(5, vet.getEmail());
		ps.setString(6, vet.getCrmv());
		
		return executar(ps);
	}

	@Override
	public boolean deletarVeterinario(Veterinario vet) throws Exception {

		String query = "delete from veterinario where cpf = ?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1,vet.getCpf());
		
		return executar(ps);
	}

	private boolean executar(PreparedStatement ps) throws Exception {
		boolean result;

		if (ps.execute())
			result = true;
		else
			result = false;

		ps.close();
		return result;
}
	
	private Veterinario preencherVet(ResultSet rs) throws Exception {
		Veterinario v1;
		try {
			String data = rs.getString("dataNasc");
			String[] splitdata = data.split("-");
			LocalDate date = LocalDate.of(Integer.parseInt(splitdata[0]),Integer.parseInt(splitdata[1]),Integer.parseInt(splitdata[2]));
			CargoVeterinario cargo = CargoVeterinario.valueOf(rs.getString("cargo"));
			
			v1 = new Veterinario(rs.getString("nome"), rs.getString("cpf"), date, cargo, rs.getString("contato"), rs.getString("email")
					, rs.getString("crmv"));
		} catch (SQLException e) {
			throw e;
		}
		return v1;
	}
	
}
