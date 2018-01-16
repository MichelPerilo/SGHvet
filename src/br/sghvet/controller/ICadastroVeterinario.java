package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.Veterinario;

public interface ICadastroVeterinario {

	public Veterinario buscaVeterinario(String cpf)throws Exception;
	public boolean cadastrarVeterinario(Veterinario vet) throws Exception;
	public boolean atualizarVeterinario(Veterinario vet) throws Exception;
	public boolean deletarVeterinario(Veterinario vet) throws Exception;
	public void conectar(Connection conect);
	public List<Veterinario> buscaTodosVeterinario() throws Exception;
}
