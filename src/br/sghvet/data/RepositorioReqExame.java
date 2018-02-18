package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.sghvet.model.Cirurgia;
import br.sghvet.model.RequisicaoExame;
import br.sghvet.model.TipoCirurgia;
import br.sghvet.model.TipoExame;

public class RepositorioReqExame implements IRepositorioReqExame {

	private static Connection connection;

	@Override
	public void conectar(Connection conect) {
		RepositorioReqExame.connection = conect;
	}

	@Override
	public boolean cadastraReqExame(RequisicaoExame e) throws Exception {
		String query = "insert into exame (tipo,natureza,observacoes,prontuario,hora,data_exame,cpf_vet,realizado) values (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, e.getTipo().toString());
		ps.setString(2, e.getNatureza().toString());
		ps.setString(3, e.getObservacoes());
		ps.setInt(4, e.getProntuario());
		ps.setString(5, e.getHora().toString());
		ps.setString(6, e.getData().toString());
		ps.setString(7, e.getCpf_vet());
		ps.setBoolean(8, false);

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
	public boolean atualizaReqExame(RequisicaoExame e) throws Exception {
		String query = "UPDATE exame SET tipo = ?,natureza = ?,observacoes = ?,prontuario = ?,hora = ?,data_exame = ?, cpf_vet = ?,realizado = ? WHERE id = ?;";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, e.getTipo().toString());
		ps.setString(2, e.getNatureza().toString());
		ps.setString(3, e.getObservacoes());
		ps.setInt(4, e.getProntuario());
		ps.setString(5, e.getHora().toString());
		ps.setString(6, e.getData().toString());
		ps.setString(7, e.getCpf_vet());
		ps.setBoolean(8, e.getRealizado());
		ps.setInt(9, e.getId());
		

		return !executar(ps);
	}

	@Override
	public List<RequisicaoExame> buscaReqExameCPF(int prontuario) throws Exception {
		String query = "select * from exame where prontuario = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, prontuario);

		ResultSet rs = ps.executeQuery();
		List<RequisicaoExame> requisicoes = new ArrayList<RequisicaoExame>();

		while (rs.next()) {
			requisicoes.add(preencherRequisicao(rs));
		}

		return requisicoes;
	}

	@Override
	public boolean deletarReqExame(RequisicaoExame r1) throws Exception {
		String query = "delete from exame where id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, r1.getId());

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
	
	@Override
	public List<RequisicaoExame> buscarALLExameImagem() throws Exception {
		String query = "select *  FROM exame";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<RequisicaoExame> exames = new ArrayList<>();
		
		while(rs.next()){
			TipoExame tipo =  TipoExame.valueOf(rs.getString("tipo").toUpperCase());
			
			if (tipo.equals(TipoExame.IMAGEM)){
		 	exames.add(preencherRequisicao(rs));
			}
		}
		ps.close();
		rs.close();
		
		return exames;
	}
	
	@Override
	public List<RequisicaoExame> buscarALLExameLab() throws Exception {
		String query = "select *  FROM exame";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<RequisicaoExame> exames = new ArrayList<>();
		
		while(rs.next()){
			TipoExame tipo =  TipoExame.valueOf(rs.getString("tipo").toUpperCase());
			
			if (tipo.equals(TipoExame.LABORATORIAL)){
		 	exames.add(preencherRequisicao(rs));
			}
		}
		ps.close();
		rs.close();
		
		return exames;
	}
	
	

	private RequisicaoExame preencherRequisicao(ResultSet rs) throws Exception {
		RequisicaoExame r1;
		try {
			if (rs.getInt("id") > 0) {
				
				String data = rs.getString("data_exame");
				String[] pedacoData = data.split("-");
				LocalDate date = LocalDate.of(Integer.parseInt(pedacoData[0]), Integer.parseInt(pedacoData[1]),
						Integer.parseInt(pedacoData[2]));
				
				TipoExame tipo = TipoExame.valueOf(rs.getString("tipo").toUpperCase());
				String horaS = rs.getString("hora");
				String[] pedacoHora = horaS.split(":");
				LocalTime hora = LocalTime.of(Integer.parseInt(pedacoHora[0]),Integer.parseInt(pedacoHora[1]));

				
				r1 = new RequisicaoExame(tipo, rs.getString("natureza"), rs.getString("observacoes"), rs.getInt("prontuario"),hora, date,
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
			e.printStackTrace();
			throw new Exception("Falha ao realizar operação no banco de dados");
		}

	}
}
