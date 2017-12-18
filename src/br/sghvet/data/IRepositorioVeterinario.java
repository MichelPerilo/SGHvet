package br.sghvet.data;

import java.sql.Connection;

import br.sghvet.model.Veterinario;

public interface IRepositorioVeterinario {

	public Veterinario buscaVeterinario(String cpf)throws Exception;
	public boolean cadastrarVeterinario(Veterinario vet) throws Exception;
	public boolean atualizarVeterinario(Veterinario vet) throws Exception;
	public boolean deletarVeterinario(Veterinario vet) throws Exception;
	public void conectar(Connection conect);
	
}
