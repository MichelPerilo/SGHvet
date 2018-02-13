package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sghvet.model.Cirurgia;
import br.sghvet.model.MembroCirurgia;

public class RepositorioMembroCirurgia implements IRepositorioMembroCirurgia{

private static Connection connection;
	
	@Override
	public void conectar(Connection conect) {
		RepositorioMembroCirurgia.connection = conect;
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
	
	@Override
	public boolean cadastrarMembroCirurgia(MembroCirurgia membro) throws Exception {
		String query = "INSERT INTO membro_cirurgia (id_cirur, cpf_membro) values (?,?);";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, membro.getCirurgia_id());
		ps.setString(2, membro.getMembro_cpf().toString());
	
		
		
		return !executar(ps);
	}
	
	@Override
	public boolean removerMembroCirurgia(MembroCirurgia membro) throws Exception {
		String query = "DELETE FROM membro_cirurgia WHERE id = ? ;";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, membro.getId());
		
		return !executar(ps);
	}
	
	@Override
	public boolean atualizarMembroCirurgia(MembroCirurgia membro) throws Exception {
		String query = "UPDATE cirurgia SET id_cirur = ?, cpf_membro = ? WHERE id = ?;";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, membro.getCirurgia_id());
		ps.setString(2, membro.getMembro_cpf().toString());
		
		
		
		return !executar(ps);		
	}
	
	@Override
	public List<MembroCirurgia> buscarMembros(int cirurgia_id) throws Exception {
		String query = "select * from membro_cirurgia where id_cirur = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,cirurgia_id);

		ResultSet rs = ps.executeQuery();
		List<MembroCirurgia> membros = new ArrayList<MembroCirurgia>();
		
		while(rs.next()){
			membros.add(preencherMembroCirurgia(rs));
		}

		return membros;
	}
	
	@Override
	public List<MembroCirurgia> buscarCirurgias(String cpf_membro) throws Exception {
		String query = "select * from membro_cirurgia where cpf_membro = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, cpf_membro);

		ResultSet rs = ps.executeQuery();
		List<MembroCirurgia> membros = new ArrayList<MembroCirurgia>();
		
		while(rs.next()){
			membros.add(preencherMembroCirurgia(rs));
		}

		return membros;
	}
	
	
	private MembroCirurgia preencherMembroCirurgia(ResultSet rs) throws Exception{
		MembroCirurgia c1;
		try{

			c1 = new MembroCirurgia(rs.getInt("id_cirur"), rs.getString("cpf_membro"));
			c1.setId(rs.getInt("id"));
		}catch(SQLException e){
			throw new Exception("Cirurgia possui dados invalidos");
		}
		
		return c1;
	}
}
