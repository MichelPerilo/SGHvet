package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import br.sghvet.model.Animal;
import br.sghvet.model.Consulta;
import br.sghvet.model.DiaDaSemana;
import br.sghvet.model.Disponibilidade;

public class RepositorioDisponibilidade implements IRepositorioDisponibilidade {

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
	public void cadastrarHorario(Disponibilidade disp) throws Exception {
		String query = "insert into disponibilidade_vet(horario_inicio,horario_fim,dia,cpf_vet)  values (?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, disp.getHorarioInicio().toString());
		ps.setString(2, disp.getHorarioFinal().toString());
		ps.setString(3, disp.getDia().toString().toLowerCase());
		ps.setString(4, disp.getCpfVet());

		executar(ps);
	}

	@Override
	public void atualizarHorario(Disponibilidade disp) throws Exception {
		String query = "update disponibilidade_vet set horario_inicio = ?, horario_fim =? where dia =? and cpf_vet =?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, disp.getHorarioInicio().toString());
		ps.setString(2, disp.getHorarioFinal().toString());
		ps.setString(3, disp.getDia().toString().toLowerCase());
		ps.setString(4, disp.getCpfVet());

		executar(ps);
	}

	@Override
	public List<Disponibilidade> buscaHorarios(String cpf_vet) throws Exception {
		String query = "select * from disponibilidade_vet where cpf_vet = ? ";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, cpf_vet);
		ResultSet rs = ps.executeQuery();
		List<Disponibilidade> horarios = new ArrayList<>();

		while (rs.next()) {
			horarios.add(preencherDisponibilidade(rs));
		}
		ps.close();
		rs.close();

		return horarios;
	}

	@Override
	public void deletarHorario(Disponibilidade disp) throws Exception {
		String query = "delete from disponibilidade_vet where cpf_vet =? and dia = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, disp.getCpfVet());
		ps.setString(2, disp.getDia().toString().toLowerCase());

		executar(ps);
	}

	private Disponibilidade preencherDisponibilidade(ResultSet rs) throws Exception {
		Disponibilidade d1;
		try {
			String horarioinicio = rs.getString("horario_inicio");
			String horarioFim = rs.getString("horario_fim");
			String[] inicio = horarioinicio.split(":");
			String[] fim = horarioFim.split(":");
			LocalTime horario_inicio = LocalTime.of(Integer.parseInt(inicio[0]), Integer.parseInt(inicio[1]));
			LocalTime horario_fim = LocalTime.of(Integer.parseInt(fim[0]), Integer.parseInt(fim[1]));

			d1 = new Disponibilidade(horario_inicio, horario_fim, rs.getString("cpf_vet"),
					DiaDaSemana.valueOf(rs.getString("dia")));
		} catch (SQLException e) {
			throw new Exception("Consulta possui dados invalidos");
		}

		return d1;
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
			throw new Exception(e.getMessage());
		}

	}

	@Override

	public List<Disponibilidade> buscaDisponibilidade(String horario, LocalDate dia) throws Exception {

		String query = "select * from disponibilidade_vet where dia = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		String diaSemana = dia.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
		String dias = diaSemana.substring(0, diaSemana.indexOf("-"));
		ps.setString(1, dias);
		ResultSet rs = ps.executeQuery();
		List<Disponibilidade> horarios = new ArrayList<>();

		while (rs.next()) {

			String horarioinicio = rs.getString("horario_inicio");
			String horarioFim = rs.getString("horario_fim");
			String[] inicio = horarioinicio.split(":");
			String[] fim = horarioFim.split(":");
			String[] atual = horario.split(":");

			if (Integer.parseInt(atual[0]) >= Integer.parseInt(inicio[0])
					&& Integer.parseInt(atual[0]) <= Integer.parseInt(fim[0]))
				horarios.add(preencherDisponibilidade(rs));

		}

		ps.close();

		rs.close();

		return horarios;

	}

}
