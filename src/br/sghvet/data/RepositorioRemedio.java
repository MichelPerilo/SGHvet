package br.sghvet.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sghvet.model.Remedio;
import br.sghvet.model.TipoUsuario;
import br.sghvet.model.Tipo_Remedio;
import br.sghvet.model.Tutor;
import br.sghvet.model.Usuario;
/**
 *
 * @author Raylison
 */

public class RepositorioRemedio {
    
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
	
	
	public boolean cadastrarRemedio(Remedio remedio) throws Exception {
		System.out.println("Entrou");
		String query = "insert into remedio (nome, tipo, bula, restricao)values(?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, remedio.getNome());
		ps.setString(2, remedio.getTipo().toString());
		ps.setString(3, remedio.getDescricao());
		ps.setString(4, remedio.getRestricao());
		return executar(ps);
	}


	public Remedio buscaRemedio(int codigo) throws Exception {

		Remedio remedio = null;
		String query = "select * from remedio where codigo = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setInt(1, codigo);
		ResultSet rs = ps.executeQuery();	
		
		while(rs.next()){
			
			if (rs.getString("tipo").equals("Analgesicos")) {
				remedio = new Remedio(rs.getString("nome"), Tipo_Remedio.Analgesicos, rs.getString("bula"), rs.getString("restricao"));
			} else if (rs.getString("tipo").equals("Antibioticos")) {
							
				remedio = new Remedio(rs.getString("nome"), Tipo_Remedio.Antibioticos, rs.getString("bula"), rs.getString("restricao"));

			} else {
				remedio = new Remedio(rs.getString("nome"), Tipo_Remedio.Antiinflamatorios, rs.getString("bula"), rs.getString("restricao"));
			}
			
		}
		ps.isClosed();
		rs.close();
		
		return remedio;
		
		
	}



	public boolean atualizaRemedio(Remedio remedio) throws Exception {

		String query = "update remedio nome ?, tipo ?, bula ?, restricao ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, remedio.getNome());
		ps.setString(2, remedio.getTipo().toString());
		ps.setString(3, remedio.getDescricao());
		ps.setString(4, remedio.getRestricao());
		
		ps.executeUpdate();

		return true;
	}



	public boolean deletarRemedio(Remedio remedio) throws Exception {

		String query = "delete from remedio where codigo = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setInt(1, remedio.getId());

		return executar(ps);
	}

	private boolean executar(PreparedStatement ps) throws Exception {
		boolean result;

		try {
			if (ps.execute())
				result = true;
			else
				result = false;
			ps.close();
			return result;
		} catch (SQLException e) {
			throw new Exception("Falha ao realizar operação no banco de dados");
		}

	}

	
	
	public List<Remedio> buscarALLRemedio() throws Exception {
		String query = "select *  FROM remedio";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Remedio> remdios = new ArrayList<>();
		
		while(rs.next()){
			remdios.add(preencherRemedio(rs));
		}
		ps.close();
		rs.close();
		
		return remdios;
	}
	

	private Remedio preencherRemedio(ResultSet rs) throws Exception {
		Remedio remedio;
		try {
			if (rs.getString("tipo").equals("Analgesicos")) {
				remedio = new Remedio(rs.getString("nome"), Tipo_Remedio.Analgesicos, rs.getString("bula"), rs.getString("restricao"));
			} else if (rs.getString("tipo").equals("Antibioticos")) {
							
				remedio = new Remedio(rs.getString("nome"), Tipo_Remedio.Antibioticos, rs.getString("bula"), rs.getString("restricao"));

			} else {
				remedio = new Remedio(rs.getString("nome"), Tipo_Remedio.Antiinflamatorios, rs.getString("bula"), rs.getString("restricao"));
			}
		} catch (SQLException e) {
			throw new Exception("Tutor possui dados invalidos");
		}
		return remedio;
	}
	
}
