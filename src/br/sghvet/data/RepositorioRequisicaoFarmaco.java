package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sghvet.model.RequisicoesFarmaco;

public class RepositorioRequisicaoFarmaco {
	
	private static Connection connection;


	public void conectar(Connection conect) {
		RepositorioRequisicaoFarmaco.connection = conect;
	}


	public boolean cadastraReqFarmaco(RequisicoesFarmaco rf) throws Exception {
		String query = "insert into requisicaoFarmaco (quantidade,descricao,justificativa) values (?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setInt(1, rf.getQtd());
		ps.setString(2, rf.getDescricao());
		ps.setString(3, rf.getJustificativa());
	
		return !executar(ps);
	}

	
	public RequisicoesFarmaco buscaReqFarmaco(int id) throws Exception {

		String query = "select * from requisicaoFarmaco where id = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		List<RequisicoesFarmaco> requisicoes = new ArrayList<RequisicoesFarmaco>();

		while (rs.next()) {
			requisicoes.add(preencherRequisicao(rs));
		}

		return requisicoes.get(0);
	}


	public boolean atualizaReqFarmaco(RequisicoesFarmaco req) throws Exception {
		String query = "UPDATE requisicaoFarmaco SET quantidade = ?, descricao = ?, justificativa = ? WHERE id = ?;";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, req.getQtd());
		ps.setString(2, req.getDescricao());
		ps.setString(3, req.getJustificativa());
		ps.setInt(4, req.getId());

		return !executar(ps);
	}

	
	
	public boolean atualizaReqFarmacoJustificativa(RequisicoesFarmaco req) throws Exception {
		String query = "UPDATE requisicaoFarmaco SET justificativaNull = ? WHERE id = ?;";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, req.getJustificativaNegacao());		
		ps.setInt(2, req.getId());

		return !executar(ps);
	}
	
	
	public boolean deletarReqFarmaco(int id) throws Exception {
		String query = "delete from requisicaoFarmaco where id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);

		return !executar(ps);
	}




	private RequisicoesFarmaco preencherRequisicao(ResultSet rs) throws Exception {
		RequisicoesFarmaco r1;
		try {
			if (rs.getInt("id") > 0) {
				
				r1 = new RequisicoesFarmaco(rs.getInt("quantidade"), rs.getString("descricao"),	rs.getString("justificativa"));
				r1.setId(rs.getInt("id"));
				return r1;
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return null;
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

}
