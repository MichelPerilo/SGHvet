package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.Animal;
import br.sghvet.model.Endereco;
import br.sghvet.model.Tutor;

public class ControlPaciente implements IControlPaciente {

	private ICadastroAnimal cadastroAnimal;
	private ICadastroTutor cadastroTutor;

	public ControlPaciente() {
		cadastroAnimal = new CadastroAnimal();
		cadastroTutor = new CadastroTutor();
	}

	@Override
	public void conectar() {
		Connection conect;
		try {
			conect = new Conexao().getConexao("root", "");
			cadastroTutor.conectar(conect);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean cadastrarAnimal(Animal a) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizarAnimal(Animal a) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarAnimal(Animal a) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List buscarAnimal(String cpfTutor) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tutor buscarTutor(String cpf) throws Exception {
		Endereco e1 = cadastroTutor.buscaEndereco(cpf);
		Tutor t1 = cadastroTutor.buscaTutor(cpf);
		t1.setEndereço(e1);
		return t1;
	}

	@Override
	public void cadastrarTutor(Tutor t) throws Exception {
		cadastroTutor.cadastrarTutor(t);
		cadastroTutor.cadastraEndereco(t.getEndereco());
	}

	@Override
	public void atualizarTutor(Tutor t) throws Exception {
		cadastroTutor.atualizaTutor(t);
		cadastroTutor.atualizarEndereco(t.getEndereco());
	}

	@Override
	public void deletarTutor(Tutor t) throws Exception {
		cadastroTutor.deletarTutor(t);
	}

}
