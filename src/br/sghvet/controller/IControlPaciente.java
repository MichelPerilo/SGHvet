package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.Animal;
import br.sghvet.model.Endereco;
import br.sghvet.model.Tutor;
import exceptions.ConectionException;

public interface IControlPaciente {
	
	public void conectar(Connection conect);

	
	public boolean cadastrarAnimal(Animal a) throws Exception;
	public boolean atualizarAnimal(Animal a) throws Exception;
	public boolean deletarAnimal(Animal a) throws Exception;
	public List buscarAnimal(String cpfTutor) throws Exception;
	public Animal buscaAnimalProntuario(int prontuario) throws Exception;
	public List<Animal> allAnimals() throws Exception;

	public Tutor buscarTutor(String cpf) throws Exception;
	public void cadastrarTutor(Tutor t) throws Exception;
	public void atualizarTutor(Tutor t) throws Exception;
	public void deletarTutor(Tutor t) throws Exception;
	public List buscarALLTutor() throws Exception;
	
	public boolean cadastraEndereco(Endereco e1) throws Exception;
	public boolean atualizarEndereco(Endereco e1) throws Exception;
	public Endereco buscaEndereco(String cpf) throws Exception;
	public boolean deletarEndereco(Endereco e1) throws Exception;	
	
	
	}
