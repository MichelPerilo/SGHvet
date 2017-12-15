package br.sghvet.controller;

import java.util.List;

import br.sghvet.model.Animal;
import br.sghvet.model.Tutor;
import exceptions.ConectionException;

public interface IControlPaciente {
	
	public void conectar() throws ConectionException;
	public boolean cadastrarAnimal(Animal a) throws Exception;
	public boolean atualizarAnimal(Animal a) throws Exception;
	public boolean deletarAnimal(Animal a) throws Exception;
	public List buscarAnimal(String cpfTutor) throws Exception;

	public Tutor buscarTutor(String cpf) throws Exception;
	public void cadastrarTutor(Tutor t) throws Exception;
	public void atualizarTutor(Tutor t) throws Exception;
	public void deletarTutor(Tutor t) throws Exception;
	public List buscarALLTutor() throws Exception;
}
