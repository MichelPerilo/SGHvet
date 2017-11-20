package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import br.sghvet.model.Auxiliar;
import br.sghvet.model.CargoAuxiliar;

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
		
		String query = "select * from auxiliar where cpf = ?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, cpf);
		ResultSet rs =  ps.executeQuery();
		
		Auxiliar a1 = preencherAuxiliar(rs);
		ps.close();
		rs.close();
		
		return a1;
	}


	@Override
	public boolean cadastrarAuxiliar(Auxiliar aux) throws Exception {

		String query = "insert into auxiliar (nome, cpf, dataNasc, cargo, contato, email)values(?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, aux.getNome());
		ps.setString(2, aux.getCpf());
		ps.setString(3, aux.getDataNasc().toString());
		ps.setString(4, aux.getCargo().toString());
		ps.setString(5, aux.getContato());
		ps.setString(6, aux.getEmail());
		
		return executar(ps);		
	}

	@Override
	public boolean atualizarAuxiliar(Auxiliar aux) throws Exception {

		String query = "update auxiliar set nome = ?, dataNasc = ?, cargo = ?, contato = ?, email = ?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, aux.getNome());
		ps.setString(2, aux.getDataNasc().toString());
		ps.setString(3, aux.getCargo().toString());
		ps.setString(4, aux.getContato());
		ps.setString(5, aux.getEmail());
		
		return executar(ps);		
	}

	@Override
	public boolean deletarAuxiliar(Auxiliar aux) throws Exception {

		String query = "delete from auxiliar where cpf = ?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, aux.getCpf());
		
		return executar(ps);
	}
	
	private Auxiliar preencherAuxiliar(ResultSet rs) throws Exception{
		Auxiliar a1;
		try {
			String data = rs.getString("dataNasc");
			String[] splitdata = data.split("-");
			LocalDate date = LocalDate.of(Integer.parseInt(splitdata[0]),Integer.parseInt(splitdata[1]),Integer.parseInt(splitdata[2]));
			CargoAuxiliar cargo = CargoAuxiliar.valueOf(rs.getString("cargo"));
			
			a1 = new Auxiliar(rs.getString("nome"), rs.getString("cpf"), date, cargo, rs.getString("contato"), rs.getString("email"));
		} catch (SQLException e) {
			throw e;
		}
		return a1;		
	}
	
	private boolean executar(PreparedStatement ps) throws Exception{
		boolean result;

		if (ps.execute())
			result = true;
		else
			result = false;

		ps.close();
		return result;
	}


}
