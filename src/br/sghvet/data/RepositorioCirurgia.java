package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.sghvet.model.CargoVeterinario;
import br.sghvet.model.Cirurgia;
import br.sghvet.model.Consulta;
import br.sghvet.model.MembroCirurgia;
import br.sghvet.model.SalaDeCirurgia;
import br.sghvet.model.TipoCirurgia;

public class RepositorioCirurgia implements IRepositorioCirurgia {

private static Connection connection;
	
	@Override
	public void conectar(Connection conect) {
		RepositorioCirurgia.connection = conect;
	}
	
	/*
	  tipo enum('GERAL', 'ESPECISLISTA') not null,
	  especialidade varchar(60), 
	  data_cir date NOT NULL,
	  hr_fim time,
	  sala enum('SALA_A', 'SALA_B', 'SALA_C', 'SALA_D' , 'SALA_E') NOT NULL,
	  hr_inic time NOT NULL,
	  prontuario INT(11) NOT NULL,
*/

	@Override
	public boolean cadastrarCirurgia(Cirurgia cirurgia) throws Exception {
		String query = "INSERT INTO cirurgia (tipo, especialidade, data_cir, hr_fim, sala, hr_inic, prontuario) values (?,?,?,?,?,?,?);";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, cirurgia.getTipo().toString());
		ps.setString(2, cirurgia.getEspecialidade().toString());
		ps.setString(3, cirurgia.getData().toString());
		ps.setString(4, cirurgia.getHora_fim().toString());
		ps.setString(5, cirurgia.getSala().toString());
		ps.setString(6, cirurgia.getHora_inicio().toString());
		ps.setInt(7, cirurgia.getProntuario_id());
		
		
		return !executar(ps);
	}
	

	@Override
	public boolean removerCirurgia(Cirurgia cirurgia) throws Exception {
		String query = "DELETE FROM cirurgia WHERE id = ? ;";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, cirurgia.getId());
		
		return !executar(ps);
	}


	@Override
	public boolean atualizarCirurgia(Cirurgia cirurgia) throws Exception {
		String query = "UPDATE cirurgia SET tipo = ?, especialidade = ?, data_cir = ?, hr_fim = ? , sala = ? , hr_inic = ?, prontuario = ? WHERE id = ?;";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, cirurgia.getTipo().toString());
		ps.setString(2, cirurgia.getEspecialidade().toString());
		ps.setString(3, cirurgia.getData().toString());
		ps.setString(4, cirurgia.getHora_fim().toString());
		ps.setString(5, cirurgia.getSala().toString());
		ps.setString(6, cirurgia.getHora_inicio().toString());
		ps.setInt(7, cirurgia.getProntuario_id());
		ps.setInt(8, cirurgia.getId());
		
		
		return !executar(ps);		
	}

	@Override
	public List<Cirurgia> buscarCirurgias(int prontuario_id) throws Exception {
		String query = "select * from cirurgia where prontuario = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,prontuario_id);

		ResultSet rs = ps.executeQuery();
		List<Cirurgia> cirurgias = new ArrayList<Cirurgia>();
		
		while(rs.next()){
			cirurgias.add(preencherCirurgia(rs));
		}

		return cirurgias;
	}
	
	
		
	@Override
	public List<Cirurgia> buscarALLCirurgia() throws Exception {
		String query = "select *  FROM cirurgia";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Cirurgia> cirurgias = new ArrayList<>();
		
		while(rs.next()){
			
			String data =  rs.getString("data_cir");
			String[] pedacoData = data.split("-");
			LocalDate dia = LocalDate.of(Integer.parseInt(pedacoData[0]),Integer.parseInt(pedacoData[1]),Integer.parseInt(pedacoData[2]));
            LocalDate hoje = LocalDate.now();
	    
		    if(dia.equals(hoje)) {	
		 	cirurgias.add(preencherCirurgia(rs));
		    }
		}
		ps.close();
		rs.close();
		
		return cirurgias;
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

 	private Cirurgia preencherCirurgia(ResultSet rs) throws Exception{
		Cirurgia c1;
		try{
			
			// (TipoCirurgia tipo, String especialidade, LocalDate data, LocalTime hora_inicio, LocalTime hora_fim, SalaDeCirurgia sala, int prontuario)
			String data =  rs.getString("data_cir");
			String horaInicio = rs.getString("hr_inic");
			String horaFim = rs.getString("hr_fim");
			String[] pedacoData = data.split("-");
			String[] pedacoHoraInicio = horaInicio.split(":");
			String[] pedacoHoraFim = horaFim.split(":");
			LocalDate data_o = LocalDate.of(Integer.parseInt(pedacoData[0]),Integer.parseInt(pedacoData[1]),Integer.parseInt(pedacoData[2]));
			LocalTime hora_inicio = LocalTime.of(Integer.parseInt(pedacoHoraInicio[0]),Integer.parseInt(pedacoHoraInicio[1]));
			LocalTime hora_fim = LocalTime.of(Integer.parseInt(pedacoHoraFim[0]),Integer.parseInt(pedacoHoraFim[1]));
			SalaDeCirurgia sala = SalaDeCirurgia.valueOf(rs.getString("sala").toUpperCase());
			TipoCirurgia tipo = TipoCirurgia.valueOf(rs.getString("tipo").toUpperCase());

			c1 = new Cirurgia(tipo, rs.getString("especialidade"), data_o, hora_inicio, hora_fim, sala, rs.getInt("prontuario"));
			c1.setId(rs.getInt("id"));
		}catch(SQLException e){
			throw new Exception("Cirurgia possui dados invalidos");
		}
		
		return c1;
	}
 	
	
}
