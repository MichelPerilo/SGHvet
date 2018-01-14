package br.sghvet.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.sghvet.model.Animal;
import br.sghvet.model.Endereco;
import br.sghvet.model.Tutor;
import exceptions.ConectionException;

public class ControlPaciente implements IControlPaciente {

	private ICadastroAnimal cadAnimal;
	private ICadastroTutor cadTutor;
	private static Connection connection;

	public ControlPaciente() throws ConectionException {
		cadAnimal = new CadastroAnimal();
		cadTutor = new CadastroTutor();

	}

	@Override
	public void conectar(Connection conect) {

		ControlPaciente.connection = conect;
		cadTutor.conectar(connection);
		cadAnimal.conectar(connection);

	}

	@Override
	public boolean cadastrarAnimal(Animal a) throws Exception {
		return cadAnimal.cadastrarAnimal(a);
	}

	@Override
	public boolean atualizarAnimal(Animal a) throws Exception {
		return cadAnimal.atualizarAnimal(a);
	}

	@Override
	public boolean deletarAnimal(Animal a) throws Exception {
		return cadAnimal.deletarAnimal(a);
	}

	@Override
	public List buscarAnimal(String cpfTutor) throws Exception {
		return cadAnimal.buscarAnimal(cpfTutor);
	}

	@Override
	public Animal buscaAnimalProntuario(int prontuario) throws Exception {
		return cadAnimal.buscaAnimalProntuario(prontuario);
	}

	@Override
	public Tutor buscarTutor(String cpf) throws Exception {
		Endereco e1 = cadTutor.buscaEndereco(cpf);
		Tutor t1 = cadTutor.buscaTutor(cpf);
		t1.setEndereço(e1);
		return t1;
	}

	@Override
	public List buscarALLTutor() throws Exception {
		return cadTutor.buscarALLTutor();
	}

	@Override
	public void cadastrarTutor(Tutor t) throws Exception {
		cadTutor.cadastrarTutor(t);
		cadTutor.cadastraEndereco(t.getEndereco());
	}

	@Override
	public void atualizarTutor(Tutor t) throws Exception {
		cadTutor.atualizaTutor(t);
		cadTutor.atualizarEndereco(t.getEndereco());
	}

	@Override
	public void deletarTutor(Tutor t) throws Exception {
		cadTutor.deletarTutor(t);
	}

	@Override
	public boolean cadastraEndereco(Endereco e1) throws Exception {
		return cadTutor.cadastraEndereco(e1);
	}

	@Override
	public boolean atualizarEndereco(Endereco e1) throws Exception {
		return cadTutor.atualizarEndereco(e1);
	}

	@Override
	public Endereco buscaEndereco(String cpf) throws Exception {
		return cadTutor.buscaEndereco(cpf);
	}

	@Override
	public boolean deletarEndereco(Endereco e1) throws Exception {
		return cadTutor.deletarEndereco(e1);
	}

}
