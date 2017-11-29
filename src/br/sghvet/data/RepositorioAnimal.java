package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sghvet.model.Animal;
import br.sghvet.model.Tutor;

public class RepositorioAnimal implements IRepositorioAnimal{

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
	public boolean cadastrarAnimal(Animal a) throws Exception {

		String query = "insert into animal (nome, especie, raca, pelagem, peso, sexo, idade, cpfTutor)values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, a.getNome());
		ps.setString(2, a.getEspecie());
		ps.setString(3, a.getRaça());
		ps.setString(4, a.getPelagem());
		ps.setDouble(5, a.getPeso());
		ps.setString(6, a.getSexo());
		ps.setInt(7, a.getIdade());
		ps.setString(8, a.getCpfTutor());
		
		return executar(ps);
	}

	@Override
	public boolean atualizarAnimal(Animal a) throws Exception {

		String query = "update animal set nome = ?, especie =?, raca =?, pelagem =?, peso =?, sexo =?, idade =? where prontuario =?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, a.getNome());
		ps.setString(2, a.getEspecie());
		ps.setString(3, a.getRaça());
		ps.setString(4, a.getPelagem());
		ps.setDouble(5, a.getPeso());
		ps.setString(6, a.getSexo());
		ps.setInt(7, a.getIdade());
		ps.setInt(8, a.getNumProntuario());
		
		return executar(ps);
	}

	@Override
	public boolean deletarAnimal(Animal a) throws Exception {
		
		String query ="delete from animal where prontuario =?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setInt(1, a.getNumProntuario());
		
		return executar(ps);
	}

	@Override
	public List buscarAnimal(String cpfTutor) throws Exception {
		String query = "select * from animal where cpfTutor = ?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, cpfTutor);
		ResultSet rs = ps.executeQuery();
		List<Animal> animais = new ArrayList<>();
		
		while(rs.next()){
			animais.add(preencherAnimal(rs));
		}
		ps.close();
		rs.close();
		
		return animais;
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
			throw new Exception("Falha ao realizar operacao no banco de dados");
		}

	}
	
	
	
	

}
