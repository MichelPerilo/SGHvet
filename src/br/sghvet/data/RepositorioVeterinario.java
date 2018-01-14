package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.sghvet.controller.Conexao;
import br.sghvet.model.CargoVeterinario;
import br.sghvet.model.Veterinario;

public class RepositorioVeterinario implements IRepositorioVeterinario {

	private Connection connection;
	
	@Override
	public void conectar(Connection conect) {
		//try {
			//if (this.connection != null)
				//this.connection.close();
			
			this.connection = conect;
		//} catch (SQLException e) {
			//e.printStackTrace();
		//}
	}
	
	@Override
	public Veterinario buscaVeterinario(String cpf) throws Exception {

		String query = "select * from veterinario where cpf = ?";
		
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();
		List<Veterinario> veterinario = new ArrayList<>();
		
		while(rs.next()){
			veterinario.add(preencherVet(rs));			
		}
		ps.close();
		rs.close();
		
		return veterinario.get(0);
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
		
		if(!executar(ps)) {
			query = "GRANT SELECT, INSERT, UPDATE, DELETE ON sghvet.* TO '"+vet.getCpf()+"'@'"+new Conexao().getHost()+"';";
			//String query2 = "GRANT CREATE USER ON *.* TO '"+vet.getCpf()+"'@'"+new Conexao().getHost()+"' WITH GRANT OPTION;";
			String query3 = "FLUSH PRIVILEGES;";
			ps = connection.prepareStatement(query);
			boolean q1 = !executar(ps);
			//ps = connection.prepareStatement(query2);
			//boolean q2 = executar(ps);
			ps = connection.prepareStatement(query3);
			boolean q3 = !executar(ps);
			if(q1&&q3)
				return true;
		}
		return false;
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
		
		return !executar(ps);
	}

	@Override
	public boolean deletarVeterinario(Veterinario vet) throws Exception {

		String query = "delete from veterinario where cpf = ?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1,vet.getCpf());
		
		return !executar(ps);
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
			CargoVeterinario cargo = CargoVeterinario.valueOf(rs.getString("cargo").toUpperCase());
			
			v1 = new Veterinario(rs.getString("nome"), rs.getString("cpf"), date, cargo, rs.getString("contato"), rs.getString("email")
					, rs.getString("crmv"));
		} catch (SQLException e) {
			throw e;
		}
		return v1;
	}
	
}
