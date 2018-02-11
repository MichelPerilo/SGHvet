package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import br.sghvet.model.Animal;

public class RepositorioAnimal implements IRepositorioAnimal {

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

		String query = "insert into animal (nome, especie, raca, pelagem, peso, sexo, dataNascimento, cpfTutor)values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, a.getNome());
		ps.setString(2, a.getEspecie());
		ps.setString(3, a.getRaça());
		ps.setString(4, a.getPelagem());
		ps.setDouble(5, a.getPeso());
		ps.setString(6, a.getSexo());
		ps.setString(7, a.getDataNascimento().toString());
		ps.setString(8, a.getCpfTutor());

		ps.executeUpdate();
		return true;
	}

	@Override
	public boolean atualizarAnimal(Animal a) throws Exception {

		String query = "update animal set nome = ?, especie =?, raca =?, pelagem =?, peso =?, sexo =?, dataNascimento =? where prontuario =?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, a.getNome());
		ps.setString(2, a.getEspecie().toString());
		ps.setString(3, a.getRaça());
		ps.setString(4, a.getPelagem());
		ps.setDouble(5, a.getPeso());
		ps.setString(6, a.getSexo());
		ps.setString(7,a.getDataNascimento().toString());
		ps.setLong(8, a.getNumProntuario());

		return ps.execute();
	}

	@Override
	public boolean deletarAnimal(Animal a) throws Exception {

		String query = "delete from animal where prontuario =?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setLong(1, a.getNumProntuario());

		return executar(ps);
	}

	@Override
	public List<Animal> buscarAnimal(String cpfTutor) throws Exception {
		String query = "select * from animal where cpfTutor = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, cpfTutor);
		ResultSet rs = ps.executeQuery();
		List<Animal> animais = new ArrayList<>();

		while (rs.next()) {
			animais.add(preencherAnimal(rs));
		}
		ps.close();
		rs.close();

		return animais;
	}
	
	@Override
	public List<Animal> allAnimals() throws Exception {
		String query = "select * from animal";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Animal> animais = new ArrayList<>();

		while (rs.next()) {
			animais.add(preencherAnimal(rs));
		}
		ps.close();
		rs.close();

		return animais;
	}

	@Override
	public Animal buscaAnimalProntuario(int prontuario) throws Exception {
		String query = "select * from animal where prontuario = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setInt(1, prontuario);
		ResultSet rs = ps.executeQuery();
		List<Animal> animais = new ArrayList<>();

		while (rs.next()) {
			animais.add(preencherAnimal(rs));
		}
		ps.close();
		rs.close();

		
		return animais.get(0);
		
	}

	private Animal preencherAnimal(ResultSet rs) throws Exception {
		Animal a1;
		try {
			String data =  rs.getString("dataNascimento");
			String[] pedacoData = data.split("-");
			LocalDate dia = LocalDate.of(Integer.parseInt(pedacoData[0]),Integer.parseInt(pedacoData[1]),Integer.parseInt(pedacoData[2]));
			
			a1 = new Animal(dia,rs.getString("nome"), rs.getString("especie"), rs.getString("sexo"),rs.getString("cpfTutor"), rs.getString("raca"), rs.getString("pelagem"), rs.getDouble("peso"));
			a1.setNumProntuario(rs.getLong("prontuario"));
			a1.setIdade(rs.getInt("idade"));
		} catch (SQLException e) {
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
