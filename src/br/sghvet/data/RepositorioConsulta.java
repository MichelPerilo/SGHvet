package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.sghvet.model.Consulta;
import br.sghvet.model.Tutor;
import sun.reflect.misc.ConstructorUtil;

public class RepositorioConsulta implements IRepositorioConsulta{
	
	private static Connection connection;
	
	@Override
	public void conectar(Connection conect) {
		RepositorioConsulta.connection = conect;
	}

	@Override
	public boolean cadastrarConsulta(Consulta consulta) throws Exception {
		String query = "INSERT INTO consulta (dia, horario, cpf_tutor, prontuario, cpf_vet) values (?,?,?,?,?);";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, consulta.getDia().toString());
		ps.setString(2, consulta.getHorario().toString());
		ps.setString(3, consulta.getCpfTutor());
		ps.setInt(4, consulta.getProntuario());
		ps.setString(5, consulta.getCpfVeterinario());
		
		return !executar(ps);
	}

	@Override
	public boolean removerConsulta(Consulta consulta) throws Exception {
		String query = "DELETE FROM consulta WHERE id = ? ;";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, consulta.getId());
		
		return !executar(ps);
	}

	@Override
	public boolean atualizarConsulta(Consulta consulta) throws Exception {
		String query = "UPDATE consulta SET dia = ?, horario = ?, prontuario = ?, cpf_vet = ? WHERE id = ?;";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, consulta.getDia().toString());
		ps.setString(2, consulta.getHorario().toString());
		ps.setInt(3, consulta.getProntuario());
		ps.setString(4, consulta.getCpfVeterinario());
		ps.setInt(5, consulta.getId());
		
		return !executar(ps);		
	}
	
	@Override
	public boolean atualizarSTATUSConsulta(Consulta consulta) throws Exception {
		String query = "UPDATE consulta SET concluido = ? WHERE id = ?;";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setBoolean(1, true);
		ps.setInt(2, consulta.getId());
		
		return !executar(ps);		
	}
	
	

	@Override
	public List<Consulta> buscarConsultaCpf(String cpf) throws Exception {
		String query = "select * from consulta where cpf_tutor = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1,cpf);

		ResultSet rs = ps.executeQuery();
		List<Consulta> consultas = new ArrayList<Consulta>();
		
		while(rs.next()){
			consultas.add(preencherConsulta(rs));
		}

		return consultas;
	}
	
	
	
	@Override
	public Consulta buscarConsulta(String cpf) throws Exception {	
		LocalDate ld = LocalDate.now();
	    	
		String query = "select * from consulta where cpf_tutor = ? and data = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1,cpf);
		ps.setString(2,ld.toString());
		
		ResultSet rs = ps.executeQuery();
		Consulta consultas = null ;
		
		while(rs.next()){
			consultas = (preencherConsulta(rs));
		}

		return consultas;
	}
		

	@Override
	public List<Consulta> buscarConsultaVet(String cpf) throws Exception {
		String query = "select * from consulta where cpf_vet = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1,cpf);

		ResultSet rs = ps.executeQuery();
		List<Consulta> consultas = new ArrayList<Consulta>();
		
		while(rs.next()){
			consultas.add(preencherConsulta(rs));
		}

		return consultas;
	}

	@Override
	public List<Consulta> buscarConsultaPro(int prontuario) throws Exception {
		String query = "select * from consulta where prontuario = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,prontuario);

		ResultSet rs = ps.executeQuery();
		List<Consulta> consultas = new ArrayList<Consulta>();
		
		while(rs.next()){
			consultas.add(preencherConsulta(rs));
		}

		return consultas;
	}
	
	@Override
	public List<Consulta> buscarConsultasDoDia(String cpf, LocalDate data) throws Exception{
		String query = "select * from consulta where cpf_vet = ? and dia = ? and concluido = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1,cpf);
		ps.setString(2, data.toString());
		ps.setBoolean(3, false);

		ResultSet rs = ps.executeQuery();
		List<Consulta> consultas = new ArrayList<Consulta>();
		
		while(rs.next()){
			consultas.add(preencherConsulta(rs));
		}
		return consultas;
		
	}
		
	@Override
	public List<Consulta> buscarALLConsultas() throws Exception {
		String query = "select *  FROM consulta where concluido = ?";		
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setBoolean(1, false);
		ResultSet rs = ps.executeQuery();
		List<Consulta> consulta = new ArrayList<>();
		
		while(rs.next()){
			
			String data =  rs.getString("dia");
			String[] pedacoData = data.split("-");
			LocalDate dia = LocalDate.of(Integer.parseInt(pedacoData[0]),Integer.parseInt(pedacoData[1]),Integer.parseInt(pedacoData[2]));
            LocalDate hoje = LocalDate.now();
	    
		    if(dia.equals(hoje)) {	
		 	consulta.add(preencherConsulta(rs));
		    }
		}
		ps.close();
		rs.close();
		
		return consulta;
	}
	
	
	@Override
	public List<Consulta> buscarRelatorio1(LocalDate inicio, LocalDate fim, String cpf_tutor) throws Exception {
		String query = "	select * from consulta where cpf_tutor = ? and concluido = true and dia between date(?) and date(?)";		
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, cpf_tutor);
		ps.setString(2, inicio.toString());
		ps.setString(3, fim.toString());
		ResultSet rs = ps.executeQuery();
		List<Consulta> consulta = new ArrayList<>();
		
		while(rs.next()){
			Consulta c1;
			String data =  rs.getString("dia");
			String horarioS = rs.getString("horario");
			String[] pedacoData = data.split("-");
			String[] pedacoHora = horarioS.split(":");
			LocalDate dia = LocalDate.of(Integer.parseInt(pedacoData[0]),Integer.parseInt(pedacoData[1]),Integer.parseInt(pedacoData[2]));
			LocalTime horario = LocalTime.of(Integer.parseInt(pedacoHora[0]),Integer.parseInt(pedacoHora[1]));

			c1 = new Consulta(dia, horario, rs.getString("cpf_tutor"), rs.getInt("prontuario"),rs.getString("cpf_vet"));
			c1.setId(rs.getInt("id"));
			consulta.add(c1);
		}
		ps.close();
		rs.close();
		
		return consulta;
	}
	@Override
	public List<Consulta> buscarRelatorio2(LocalDate inicio, LocalDate fim, String cpf_vet) throws Exception {
		String query = "select * from consulta where cpf_vet = ? and concluido = true and dia between date(?) and date(?)";		
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, cpf_vet);
		ps.setString(2, inicio.toString());
		ps.setString(3, fim.toString());
		ResultSet rs = ps.executeQuery();
		List<Consulta> consultas = new ArrayList<>();
		
		while(rs.next()){
			Consulta c1;
			String data =  rs.getString("dia");
			String horarioS = rs.getString("horario");
			String[] pedacoData = data.split("-");
			String[] pedacoHora = horarioS.split(":");
			LocalDate dia = LocalDate.of(Integer.parseInt(pedacoData[0]),Integer.parseInt(pedacoData[1]),Integer.parseInt(pedacoData[2]));
			LocalTime horario = LocalTime.of(Integer.parseInt(pedacoHora[0]),Integer.parseInt(pedacoHora[1]));
System.out.println(rs.getString("cpf_vet"));
			c1 = new Consulta(dia, horario, rs.getString("cpf_tutor"), rs.getInt("prontuario"),rs.getString("cpf_vet"));
			c1.setId(rs.getInt("id"));
			consultas.add(c1);
		}
		ps.close();
		rs.close();
		
		for (Consulta c : consultas) {
			       
			       System.out.println(c.getProntuario());
			
			}
		
		return consultas;
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

 	private Consulta preencherConsulta(ResultSet rs) throws Exception{
		Consulta c1;
		try{
			String data =  rs.getString("dia");
			String horarioS = rs.getString("horario");
			String[] pedacoData = data.split("-");
			String[] pedacoHora = horarioS.split(":");
			LocalDate dia = LocalDate.of(Integer.parseInt(pedacoData[0]),Integer.parseInt(pedacoData[1]),Integer.parseInt(pedacoData[2]));
			LocalTime horario = LocalTime.of(Integer.parseInt(pedacoHora[0]),Integer.parseInt(pedacoHora[1]));

			c1 = new Consulta(dia, horario, rs.getString("cpf_tutor"), rs.getInt("prontuario"),rs.getString("cpf_vet"));
			c1.setId(rs.getInt("id"));
		}catch(SQLException e){
			throw new Exception("Consulta possui dados invalidos");
		}
		
		return c1;
	}

}
