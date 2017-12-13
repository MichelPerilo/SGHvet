package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.Animal;

public interface ICadastroAnimal {

	public void conectar(Connection conect);
	public boolean cadastrarAnimal(Animal a) throws Exception;
	public boolean atualizarAnimal(Animal a) throws Exception;
	public boolean deletarAnimal(Animal a) throws Exception;
	public List buscarAnimal(String cpfTutor) throws Exception;
}
