package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import br.sghvet.controller.Conexao;
import br.sghvet.model.Administrativo;
import br.sghvet.model.CargoAdm;

public class RepositorioAdm implements IRepositorioAdm {

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
	public Administrativo buscaAdm(String cpf) throws Exception {
		
		String query  = "select * from administrativo where cpf = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();
		
		Administrativo a1 = preencherAdministrativo(rs);
		ps.isClosed();
		rs.close();
		
		return a1;
	}


	@Override
	public boolean cadastraAdm(Administrativo adm) throws Exception {
		
		String query = "insert into administrativo (nome, cpf, dataNasc, cargo, contato, email)values(?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, adm.getNome());
		ps.setString(2, adm.getCpf());
		ps.setString(3, adm.getDataNasc().toString());
		ps.setString(4, adm.getCargo().toString());
		ps.setString(5, adm.getContato());
		ps.setString(6, adm.getEmail());
		
		if(executar(ps)) {
			//testar
			query = "GRANT SELECT, INSERT, UPDATE, DELETE ON sghvet.* TO '"+adm.getCpf()+"'@'"+new Conexao().getHost()+"';";
			String query2 = "GRANT CREATE USER ON *.* TO '"+adm.getCpf()+"'@'"+new Conexao().getHost()+"' WITH GRANT OPTION;";
			String query3 = "FLUSH PRIVILEGES;";
			ps = connection.prepareStatement(query);
			boolean q1 = executar(ps);
			ps = connection.prepareStatement(query2);
			boolean q2 = executar(ps);
			ps = connection.prepareStatement(query3);
			boolean q3 = executar(ps);
			if(q1&&q2&&q3)
				return true;
		}
		return false;
	}


	@Override
	public boolean atualizaAdm(Administrativo adm) throws Exception {
		
		String query = "update administrativo set nome = ?, dataNasc = ?, cargo = ?, contato = ?, email = ?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, adm.getNome());
		ps.setString(2, adm.getDataNasc().toString());
		ps.setString(3, adm.getCargo().toString());
		ps.setString(4, adm.getContato());
		ps.setString(5, adm.getEmail());
		
		return executar(ps);
	}

	@Override
	public boolean deletarAdm(Administrativo adm) throws Exception {

		String query = "delete from administrativo where cpf = ?";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, adm.getCpf());
		
		return executar(ps);
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
	
	private Administrativo preencherAdministrativo(ResultSet rs) throws Exception{
		Administrativo a1;
		try {
			String data = rs.getString("dataNasc");
			String[] splitdata = data.split("-");
			LocalDate date = LocalDate.of(Integer.parseInt(splitdata[0]),Integer.parseInt(splitdata[1]),Integer.parseInt(splitdata[2]));
			CargoAdm cargo = CargoAdm.valueOf(rs.getString("cargo"));
			
			a1 = new Administrativo(rs.getString("nome"), rs.getString("cpf"), date, cargo, rs.getString("contato"), rs.getString("email"));
		} catch (SQLException e) {
			throw e;
		}
		return a1;		
	}
}
