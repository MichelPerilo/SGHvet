package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sghvet.model.Animal;
import br.sghvet.model.Endereco;
import br.sghvet.model.Tutor;

public class RepositorioTutor implements IRepositorioTutor {

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

	public boolean cadastrarEndereco(Endereco e1) throws Exception {

		String query = "insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values (?, ?, ?, ?, ?, ? ,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, e1.getLogradouro());
		ps.setString(2, e1.getBairro());
		ps.setString(3, e1.getNumero());
		ps.setString(4, e1.getComplemento());
		ps.setString(5, e1.getCep());
		ps.setString(6, e1.getCidade());
		ps.setString(7, e1.getEstado());
		ps.setString(8, e1.getCpfTutor());

		return executar(ps);
	}

	@Override
	public boolean cadastrarTutor(Tutor tutor) throws Exception {
		System.out.println("Entrou");
		String query = "insert into Tutor (nome, cpf, sexo, contato)values(?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, tutor.getNome());
		ps.setString(2, tutor.getCpf());
		ps.setString(3, tutor.getSexo());
		ps.setString(4, tutor.getContato());
		return executar(ps);
	}

	@Override
	public Tutor buscaTutor(String cpf) throws Exception {

		Tutor t1 = null;
		String query = "select * from tutor where cpf = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();	
		
		while(rs.next()){
			t1 = new Tutor(rs.getString("nome"), rs.getString("cpf"), rs.getString("sexo"), rs.getString("contato"));
		}
		ps.isClosed();
		rs.close();
		
		return t1;
		
		
	}

	public Endereco buscaEndereco(String cpf) throws Exception {

		String query = "select E.rua, E.bairro, E.numero, E.complemento, E.cep, E.cidade, E.estado from endereco as E, tutor as T where E.cpfTutor = T.cpf and T.cpf = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();
		Endereco e1 = null;
		while(rs.next()){
			e1 = preencherEndereco(rs);
		}
		
		ps.close();
		rs.close();

		return e1;
	}

	public boolean atualizarEndereco(Endereco e1) throws Exception {
		String query = "update endereco set rua = ?, bairro = ?,numero = ?, complemento = ?, cep = ?, "
				+ "cidade = ?, estado = ? where cpf = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, e1.getLogradouro());
		ps.setString(2, e1.getBairro());
		ps.setString(3, e1.getNumero());
		ps.setString(4, e1.getComplemento());
		ps.setString(5, e1.getCep());
		ps.setString(6, e1.getCidade());
		ps.setString(7, e1.getEstado());
		ps.setString(8, e1.getCpfTutor());

		return executar(ps);
	}

	@Override
	public boolean atualizaTutor(Tutor tutor) throws Exception {

		String query = "update tutor set nome = ?, contato = ? where cpf = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, tutor.getNome());
		ps.setString(2, tutor.getContato());
		ps.setString(3, tutor.getCpf());

		return executar(ps);
	}

	@Override
	public boolean deletarEndereco(Endereco end) throws Exception {
		
		String query = "delete from endereco where cpf = ?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, end.getCpfTutor());
		
		return executar(ps);
	}

	@Override
	public boolean deletarTutor(Tutor tutor) throws Exception {

		String query = "delete from tutor where cpf = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, tutor.getCpf());

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

	private Endereco preencherEndereco(ResultSet rs) throws Exception {
		Endereco e1 = null;
		try {
			e1 = new Endereco(rs.getString("rua"), rs.getString("bairro"), rs.getString("cep"), rs.getString("numero"),
					rs.getString("complemento"), rs.getString("cidade"), rs.getString("estado"), "41646752333");
		
		} catch (SQLException e) {
			throw e;
		}

		return e1;
	}

	private Tutor preencherTutor(ResultSet rs) throws Exception {
		Tutor t1;
		try {
			t1 = new Tutor(rs.getString("nome"), rs.getString("cpf"), rs.getString("sexo"), rs.getString("contato"),null);
		} catch (SQLException e) {
			throw new Exception("Tutor possui dados invalidos");
		}
		return t1;
	}
	
	
	
	@Override
	public List buscarALLTutor() throws Exception {
		String query = "select * from tutor";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Tutor> tutores = new ArrayList<>();
		
		while(rs.next()){
			tutores.add(preencherTutor(rs));
		}
		ps.close();
		rs.close();
		
		return tutores;
	}
	
	private Animal preencherAnimal(ResultSet rs) throws Exception{
		Animal a1;
		try{
			a1 = new Animal(rs.getString("nome"), rs.getString("especie"), rs.getString("sexo"),rs.getInt("idade"),
					rs.getString("cpfTutor"),rs.getString("raca"),rs.getString("pelagem"),rs.getDouble("peso"));
			a1.setNumProntuario(rs.getInt("prontuario"));
		}catch(SQLException e){
			throw new Exception("Animal possui dados invalidos");
		}
		
		return a1;
	}
	
	

}
