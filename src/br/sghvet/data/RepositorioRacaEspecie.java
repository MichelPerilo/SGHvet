package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sghvet.model.Tutor;

public class RepositorioRacaEspecie {

	private Connection connection;

	public void conectar(Connection conect) {
		try {
			if (this.connection != null)
				this.connection.close();

			this.connection = conect;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String> buscarALLEspeciel() throws Exception {
		String query = "select *  from especie";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<String> especie = new ArrayList<>();

		while (rs.next()) {
			especie.add(preencherEspecie(rs));
		}
		ps.close();
		rs.close();

		return especie;
	}

	private String preencherEspecie(ResultSet rs) throws Exception {
		String especie = null;
		try {
			especie = new String(rs.getString("nome"));
		} catch (SQLException e) {

		}
		return especie;
	}

	public List<String> buscarRaca(int cod) throws Exception {
		String query = "select * from raça where cod_esp = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setInt(1, cod);
		ResultSet rs = ps.executeQuery();
		List<String> raça = new ArrayList<>();

		while (rs.next()) {
			raça.add(preencherEspecie(rs));
		}
		ps.close();
		rs.close();

		return raça;
	}
	


	private String preencherRaca(ResultSet rs) throws Exception {
		String raça = null;
		try {
			raça = new String(rs.getString("nome"));
		} catch (SQLException e) {

		}
		return raça;
	}

}
