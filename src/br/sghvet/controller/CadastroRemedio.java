
package br.sghvet.controller;

import br.sghvet.data.RepositorioRemedio;
import exceptions.CadatroProdutoExistenteExeception;
import exceptions.ProcuraProdutoInexistenteExeception;
import br.sghvet.model.Item_Estoque;
import br.sghvet.model.Remedio;
import br.sghvet.model.Tipo_Remedio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raylison
 */
public class CadastroRemedio {
    
    private RepositorioRemedio repositorio;

	public CadastroRemedio() {
		

		repositorio =  new RepositorioRemedio();
	}
	
	
	

	public void conectar(Connection conect) {
		repositorio.conectar(conect);
	}
	
	
	
//	remedios
	

	public boolean cadastrarRemedio(Remedio remedio) throws Exception {
		
		return repositorio.cadastrarRemedio(remedio);
		
	}


	public Remedio buscaRemedio(int codigo) throws Exception {

	 return repositorio.buscaRemedio(codigo);
		
	}



	public boolean atualizaRemedio(Remedio remedio) throws Exception {

		return repositorio.atualizaRemedio(remedio);
	}



	public boolean deletarRemedio(Remedio remedio) throws Exception {

		return repositorio.deletarRemedio(remedio);
	}

	
	public List<Remedio> buscarALLRemedio() throws Exception {
				
		return repositorio.buscarALLRemedio();
	}
	
	
	
//	Intem de estoque
	
	
	public boolean cadastrarIntem_Estoque(Item_Estoque itEstoque) throws Exception {
		return repositorio.cadastrarIntem_Estoque(itEstoque);
	}


	public Item_Estoque buscaIntem_Estoque(String codigo) throws Exception {

	return repositorio.buscaIntem_Estoque(codigo);		
		
	}



	public boolean atualizaIntem_Estoque(Item_Estoque itEstoque) throws Exception {

		return repositorio.atualizaIntem_Estoque(itEstoque);
	}



	public boolean deletarIntem_Estoque(Item_Estoque itEstoque) throws Exception {

		return repositorio.deletarIntem_Estoque(itEstoque);
	}

	
	
	public List<Item_Estoque> buscarALLIntem_Estoque() throws Exception {
		
		return repositorio.buscarALLIntem_Estoque();
	}
	
	public int  idCadastrado(String pesquisa) throws Exception {
		
		return repositorio.idCadastrado(pesquisa);
	}
	
    
}
