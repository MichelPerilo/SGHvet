package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.sghvet.model.RequisicaoExame;

public class RepositorioReqExame implements IRepositorioReqExame {

	private static Connection connection;

	@Override
	public void conectar(Connection conect) {
		RepositorioReqExame.connection = conect;
	}

	@Override
	public boolean cadastraReqExame(RequisicaoExame e) throws Exception {
		String query = "insert into exame (cpf_aux,cpf_tutor,prontuario,data_exame,realizado) values (?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, e.getCpfVeterinario());
		ps.setString(2, e.getCpfTutor());
		ps.setInt(3, e.getProntuario());
		ps.setString(4, e.getData().toString());
		ps.setBoolean(5, false);

		return !executar(ps);
	}

	@Override
	public RequisicaoExame buscaReqExame(int id) throws Exception {

		String query = "select * from exame where id = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		List<RequisicaoExame> requisicoes = new ArrayList<RequisicaoExame>();

		while (rs.next()) {
			requisicoes.add(preencherRequisicao(rs));
		}

		return requisicoes.get(0);
	}

	@Override
	public boolean atualizaReqExame(RequisicaoExame req) throws Exception {
		String query = "UPDATE exame SET data_exame = ?, prontuario = ?, cpf_vet = ? WHERE id = ?;";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, req.getData().toString());
		ps.setInt(2, req.getProntuario());
		ps.setString(3, req.getCpfVeterinario());
		ps.setInt(4, req.getId());

		return !executar(ps);
	}

	@Override
	public List<RequisicaoExame> buscaReqExameCPF(String cpf) throws Exception {
		String query = "select * from exame where cpf_tutor = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, cpf);

		ResultSet rs = ps.executeQuery();
		List<RequisicaoExame> requisicoes = new ArrayList<RequisicaoExame>();

		while (rs.next()) {
			requisicoes.add(preencherRequisicao(rs));
		}

		return requisicoes;
	}

	@Override
	public boolean deletarReqExame(int id) throws Exception {
		String query = "delete from exame where id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);

		return !executar(ps);
	}

	@Override
	public List<RequisicaoExame> buscaReqExameVet(String cpf_vet) throws Exception {
		String query = "select * from exame where cpf_vet = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, cpf_vet);
		ResultSet rs = ps.executeQuery();

		List<RequisicaoExame> requisicoes = new ArrayList<RequisicaoExame>();

		while (rs.next()) {
			requisicoes.add(preencherRequisicao(rs));
		}

		return requisicoes;
	}

	@Override
	public List<RequisicaoExame> buscaReqExameProntuario(int id) throws Exception {
		String query = "select * from exame where prontuario = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		List<RequisicaoExame> requisicoes = new ArrayList<RequisicaoExame>();

		while (rs.next()) {
			requisicoes.add(preencherRequisicao(rs));
		}

		return requisicoes;
	}

	private RequisicaoExame preencherRequisicao(ResultSet rs) throws Exception {
		RequisicaoExame r1;
		try {
			if (rs.getInt("id") > 0) {
				String data = rs.getString("data_exame");
				String[] pedacoData = data.split("-");
				LocalDate date = LocalDate.of(Integer.parseInt(pedacoData[0]), Integer.parseInt(pedacoData[1]),
						Integer.parseInt(pedacoData[2]));
				r1 = new RequisicaoExame(date, rs.getString("cpf_tutor"), rs.getInt("prontuario"),
						rs.getString("cpf_vet"), rs.getBoolean("realizado"));
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
