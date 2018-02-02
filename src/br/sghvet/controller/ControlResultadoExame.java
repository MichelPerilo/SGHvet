package br.sghvet.controller;

import br.sghvet.data.IRepositorioResultadoExame;
import br.sghvet.data.RepositorioResultadoExame;
import br.sghvet.model.Consulta;
import br.sghvet.model.RequisicaoExame;
import br.sghvet.model.ResultadoExame;
import java.sql.Connection;

/**
 * controleRegistroConsulta
 */
public class ControlResultadoExame implements IControlResultadoExame {

    private IRepositorioResultadoExame repo;
    
    public ControlResultadoExame() {
        this.repo = new RepositorioResultadoExame();

    }
    
    @Override
	public ResultadoExame buscarRegistro(Consulta consulta) throws Exception {
		return repo.buscarRegistro(consulta);
	}

	@Override
	public boolean cadastrarRegistro(ResultadoExame registroConsulta) throws Exception {
		return repo.CadastrarRegistro(registroConsulta);
	}

	@Override
	public boolean atualizarRegistro(ResultadoExame registroConsulta) throws Exception {
		return repo.atualizarRegistro(registroConsulta);
	}

	@Override
	public void conectar(Connection conect) {
		this.repo.conectar(conect);
	}
    
}