package br.com.hellobank.service;

import java.util.List;

import br.com.hellobank.model.Cliente;

public interface IClienteService {
	
	Cliente salvar(Cliente cliente);

	List<Cliente> listarTodos();

	Cliente buscarPorId(Long id);

	Cliente buscarPorCpf(String cpf);

	void deletar(Long id);
	
}
