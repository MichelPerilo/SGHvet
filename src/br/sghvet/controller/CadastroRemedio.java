
package br.sghvet.controller;

import br.sghvet.data.RepositorioRemedio;
import exceptions.CadatroProdutoExistenteExeception;
import exceptions.ProcuraProdutoInexistenteExeception;
import br.sghvet.model.Remedio;
import br.sghvet.model.Tipo_Remedio;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
}
