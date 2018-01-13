package br.sghvet.controller;

import br.sghvet.data.IRepositorioRegistroConsulta;
import br.sghvet.data.RepositorioRegistroConsulta;
import br.sghvet.model.Consulta;
import br.sghvet.model.RegistroConsulta;
import java.sql.Connection;

/**
 * controleRegistroConsulta
 */
public class controleRegistroConsulta implements IcontroleRegistroConsulta {

    private IRepositorioRegistroConsulta repo;
    
    public controleRegistroConsulta() {
        this.repo = new RepositorioRegistroConsulta();

    }
    
    @Override
	public RegistroConsulta buscarRegistro(Consulta consulta) throws Exception {
		return repo.buscarRegistro(consulta);
	}

	@Override
	public boolean cadastrarRegistro(RegistroConsulta registroConsulta) throws Exception {
		return repo.CadastrarRegistro(registroConsulta);
	}

	@Override
	public boolean atualizarRegistro(RegistroConsulta registroConsulta) throws Exception {
		return repo.atualizarRegistro(registroConsulta);
	}

	@Override
	public void conectar(Connection conect) {
		this.repo.conectar(conect);
	}
    
}