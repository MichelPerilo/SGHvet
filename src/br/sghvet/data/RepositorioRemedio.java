package br.sghvet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.kernel.log.SystemOutCounter;

import br.sghvet.model.Item_Estoque;
import br.sghvet.model.Remedio;
import br.sghvet.model.TipoUsuario;
import br.sghvet.model.Tipo_Remedio;
import br.sghvet.model.Tutor;
import br.sghvet.model.Usuario;

/**
 *
 * @author Raylison
 */

public class RepositorioRemedio {

	private Connection connection;

	public void conectar(Connection conect) {
		try {
			if (this.connection != null)
				this.connection.close();

			this.connection = conect;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remedios

	public boolean cadastrarRemedio(Remedio remedio) throws Exception {
		System.out.println("Entrou");
		String query = "insert into remedio (nome, tipo, bula, restricao)values(?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, remedio.getNome());
		ps.setString(2, remedio.getTipo().toString());
		ps.setString(3, remedio.getDescricao());
		ps.setString(4, remedio.getRestricao());
		return executar(ps);
	}

	public Remedio buscaRemedio(int codigo) throws Exception {

		Remedio remedio = null;
		String query = "select * from remedio where codigo = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setInt(1, codigo);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			if (rs.getString("tipo").equals("Analgesicos")) {
				remedio = new Remedio(rs.getString("nome"), Tipo_Remedio.Analgesicos, rs.getString("bula"),
						rs.getString("restricao"));
			} else if (rs.getString("tipo").equals("Antibioticos")) {

				remedio = new Remedio(rs.getString("nome"), Tipo_Remedio.Antibioticos, rs.getString("bula"),
						rs.getString("restricao"));

			} else {
				remedio = new Remedio(rs.getString("nome"), Tipo_Remedio.Antiflamatorio, rs.getString("bula"),
						rs.getString("restricao"));
			}

		}
		ps.isClosed();
		rs.close();

		return remedio;

	}

	public boolean atualizaRemedio(Remedio remedio) throws Exception {

		String query = "update remedio set nome = ?, tipo = ?, bula = ?, restricao = ? where codigo = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, remedio.getNome());
		ps.setString(2, remedio.getTipo().toString());
		ps.setString(3, remedio.getDescricao());
		ps.setString(4, remedio.getRestricao());
		ps.setInt(5, remedio.getId());

		ps.executeUpdate();

		return true;
	}

	public boolean deletarRemedio(Remedio remedio) throws Exception {

		String query = "delete from remedio where codigo = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setInt(1, remedio.getId());

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

	public List<Remedio> buscarALLRemedio() throws Exception {
		String query = "select *  FROM remedio";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Remedio> remdios = new ArrayList<>();

		while (rs.next()) {
			remdios.add(preencherRemedio(rs));
		}
		ps.close();
		rs.close();

		return remdios;
	}

	private Remedio preencherRemedio(ResultSet rs) throws Exception {
		Remedio remedio;
		try {
			if (rs.getString("tipo").equals("Analgesicos")) {
				remedio = new Remedio(rs.getString("nome"), Tipo_Remedio.Analgesicos, rs.getString("bula"),
						rs.getString("restricao"));
				remedio.setId(rs.getInt("codigo"));
			} else if (rs.getString("tipo").equals("Antibioticos")) {

				remedio = new Remedio(rs.getString("nome"), Tipo_Remedio.Antibioticos, rs.getString("bula"),
						rs.getString("restricao"));
				remedio.setId(rs.getInt("codigo"));

			} else {
				remedio = new Remedio(rs.getString("nome"), Tipo_Remedio.Antiflamatorio, rs.getString("bula"),
						rs.getString("restricao"));
				remedio.setId(rs.getInt("codigo"));
			}
		} catch (SQLException e) {
			throw new Exception("Tutor possui dados invalidos");
		}
		return remedio;
	}

	// Intem_Estoque

	public boolean cadastrarIntem_Estoque(Item_Estoque itEstoque) throws Exception {
		System.out.println("Entrou");
		itEstoque.logCadastro();
		String query = "insert into intem_estoque (data_entrada, data_validade, qtd_atual, codigo_remedio_ie)values(?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, itEstoque.getData_entrada().toString());
		ps.setString(2, itEstoque.getData_validade().toString());
		ps.setInt(3, itEstoque.getQtd_atual());
		ps.setInt(4, itEstoque.getCodigo_remedio_ie());
		return executarIntem_Estoque(ps);
	}

	public Item_Estoque buscaIntem_Estoque(String pesquisa) throws Exception {

		Item_Estoque itEstoque = null;

		for (Item_Estoque ie : buscarALLIntem_Estoque()) {
			

			if (Integer.parseInt(pesquisa) == ie.getCodigo_remedio_ie()) {
				System.out.println(ie.getNome());
		
				itEstoque = ie;
				break;
			}

		}

		return itEstoque;

	}

	public boolean atualizaIntem_Estoque(Item_Estoque itEstoque) throws Exception {

		String query = "update intem_estoque set data_validade = ?, qtd_atual = ? where id_intem_estoque = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);

		ps.setString(1, itEstoque.getData_validade().toString());
		ps.setInt(2, itEstoque.getQtd_atual());
		ps.setInt(3, itEstoque.getId_intem_estoque());

		ps.executeUpdate();

		return true;
	}

	public boolean deletarIntem_Estoque(Item_Estoque itEstoque) throws Exception {

		String query = "delete from intem_estoque where id_intem_estoque = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		System.out.println(itEstoque.getId_intem_estoque());
		ps.setInt(1, itEstoque.getId_intem_estoque());

		return executarIntem_Estoque(ps);
	}

	private boolean executarIntem_Estoque(PreparedStatement ps) throws Exception {
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

	public List<Item_Estoque> buscarALLIntem_Estoque() throws Exception {
		String query = "select *  FROM intem_estoque";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Item_Estoque> itEstoque = new ArrayList<>();

		while (rs.next()) {
			itEstoque.add(preencherIntem_Estoque(rs));

		}
		ps.close();
		rs.close();

		return itEstoque;
	}

	private Item_Estoque preencherIntem_Estoque(ResultSet rs) throws Exception {
		Item_Estoque itEstoque;
		List<Remedio> remedio = new ArrayList<>();
		remedio = this.buscarALLRemedio();

		try {

			String st = rs.getString("data_entrada");
			String[] Data = st.split("-");

			LocalDate validade = LocalDate.of(Integer.parseInt(Data[0]), Integer.parseInt(Data[1]),
					Integer.parseInt(Data[2]));

			String st2 = rs.getString("data_validade");
			String[] Data2 = st2.split("-");

			LocalDate validade2 = LocalDate.of(Integer.parseInt(Data2[0]), Integer.parseInt(Data2[1]),
					Integer.parseInt(Data2[2]));

			itEstoque = new Item_Estoque(validade2, rs.getInt("qtd_atual"), rs.getInt("codigo_remedio_ie"));
			itEstoque.setId_intem_estoque(rs.getInt("id_intem_estoque"));
			itEstoque.setData_entrada(validade);

			for (Remedio r : remedio) {
				if (itEstoque.getCodigo_remedio_ie() == r.getId()) {

					itEstoque.setNome(r.getNome());
					itEstoque.setTipo(r.getTipo().toString());
					break;
				}

			}

		} catch (SQLException e) {
			throw new Exception("intens de estoque possui dados invalidos");
		}
		return itEstoque;
	}

	public int idCadastrado(String pesquisa) throws Exception {

		Remedio r = null;

		for (Remedio reme : this.buscarALLRemedio()) {

			if (pesquisa.equals(reme.getNome())) {

				r = reme;
				break;
			}

		}

		return r.getId();
	}

}
