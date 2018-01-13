package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.sghvet.model.Consulta;
import br.sghvet.model.RegistroConsulta;

public class RepositorioRegistroConsulta implements IRepositorioRegistroConsulta{
	
	private static Connection connection;
	
	@Override
	public void conectar(Connection conect) {
		RepositorioRegistroConsulta.connection = conect;
	}

	@Override
	public boolean CadastrarRegistro(RegistroConsulta registro) throws Exception {
		String query = "insert into registro(id_consulta,temperatura,batimentoPorMin,movRespPorMin,pulso, ectoscopia,"
				+ "cabecaPescoco,cavidadeToracica,cavidadeAbdominal,sistemaLocomotor,sistemaNervoso,diagnosticoProvavel,"
				+ "examesComplementares,diagnosticoDefinitivo,prognostico) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, registro.getIdConsulta());
		ps.setFloat(2, registro.getTemp());
		ps.setFloat(3, registro.getBatimentoPorMin());
		ps.setFloat(4, registro.getMovRespPorMin());
		ps.setFloat(5, registro.getPulso());
		ps.setString(6, registro.getEctoscopia());
		ps.setString(7, registro.getCabecaPescoco());
		ps.setString(8, registro.getCavidadeToracica());
		ps.setString(9, registro.getCavidadeAbdominal());
		ps.setString(10, registro.getSistemaLocomotor());
		ps.setString(11, registro.getSistemaNervoso());
		ps.setString(12, registro.getDiagnosticoProvavel());
		ps.setString(13, registro.getExamesComplementares());
		ps.setString(14, registro.getDiagnosticoDefinitivo());
		ps.setString(15, registro.getPrognostico());
		
		return !executar(ps);
	}

	@Override
	public boolean atualizarRegistro(RegistroConsulta registro) throws Exception {
		String query = "update registro SET temperatura=?,batimentoPorMin=?,movRespPorMin=?,pulso=?, ectoscopia=?,"
				+ "cabecaPescoco=?,cavidadeToracica=?,cavidadeAbdominal=?,sistemaLocomotor=?,sistemaNervoso=?,diagnosticoProvavel=?,"
				+ "examesComplementares=?,diagnosticoDefinitivo=?,prognostico=? WHERE id_consulta = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setFloat(1, registro.getTemp());
		ps.setFloat(2, registro.getBatimentoPorMin());
		ps.setFloat(3, registro.getMovRespPorMin());
		ps.setFloat(4, registro.getPulso());
		ps.setString(5, registro.getEctoscopia());
		ps.setString(6, registro.getCabecaPescoco());
		ps.setString(7, registro.getCavidadeToracica());
		ps.setString(8, registro.getCavidadeAbdominal());
		ps.setString(9, registro.getSistemaLocomotor());
		ps.setString(10, registro.getSistemaNervoso());
		ps.setString(11, registro.getDiagnosticoProvavel());
		ps.setString(12, registro.getExamesComplementares());
		ps.setString(13, registro.getDiagnosticoDefinitivo());
		ps.setString(14, registro.getPrognostico());
		ps.setInt(15, registro.getIdConsulta());
		
		return !executar(ps);
	}
	
	@Override
	public RegistroConsulta buscarRegistro(Consulta consulta) throws Exception {
		String query = "SELECT * FROM registro WHERE id_consulta = "+consulta.getId();
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return preencherRegistro(rs);
		
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

	private RegistroConsulta preencherRegistro(ResultSet rs) {
		RegistroConsulta rc;
		try {
			rc = new RegistroConsulta(rs.getInt("id_consulta"), rs.getFloat("temperatura"), rs.getFloat("batimentoPorMin"),
					rs.getFloat("movRespPorMin"), rs.getFloat("pulso"), rs.getString("ectoscopia"), rs.getString("cabecaPescoco"),
					rs.getString("cavidadeToracica"), rs.getString("cavidadeAbdominal"), rs.getString("sistemaLocomotor"), 
					rs.getString("sistemaNervoso"), rs.getString("diagnosticoProvavel"), rs.getString("examesComplementares"), 
					rs.getString("diagnosticoDefinitivo"), rs.getString("prognostico"));
			return rc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
