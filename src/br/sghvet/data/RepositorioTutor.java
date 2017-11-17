package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import br.sghvet.model.Tutor;


public class RepositorioTutor implements IRepositorioTutor{
	
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
	public Tutor buscaTutor(String cpf) throws Exception {
		
		String query  = "select * from Tutor where cpf = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();
		
		Tutor t1 = preencherTutor(rs);
		ps.isClosed();
		rs.close();
		
		return t1;
	}


	@Override
	public boolean cadastraTutor(Tutor tutor) throws Exception {
		
		String query = "insert into Tutor (nome, cpf, dataNasc, cargo, contato, email)values(?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, tutor.getNome());
		ps.setString(2, tutor.getCpf());
		
		
		return executar(ps);
	}


	@Override
	public boolean atualizaTutor(Tutor tutor) throws Exception {
		
		String query = "update administrativo set nome = ?, dataNasc = ?, cargo = ?, contato = ?, email = ?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, tutor.getNome());
		
		
		return executar(ps);
	}

	@Override
	public boolean deletarTutor(Tutor tutor) throws Exception {

		String query = "delete from administrativo where cpf = ?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, tutor.getCpf());
		
		return executar(ps);
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
	
	private Tutor preencherTutor(ResultSet rs) throws Exception{
		Tutor t1;
		try {
			String data = rs.getString("dataNasc");
			String[] splitdata = data.split("-");
			LocalDate date = LocalDate.of(Integer.parseInt(splitdata[0]),Integer.parseInt(splitdata[1]),Integer.parseInt(splitdata[2]));
			CargoAdm cargo = CargoAdm.valueOf(rs.getString("cargo"));
			
			t1 = new Tutor(rs.getString("nome"), rs.getString("cpf"), date, cargo, rs.getString("contato"), rs.getString("email"));
		} catch (SQLException e) {
			throw e;
		}
		return t1;		
	}

}
