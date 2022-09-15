package br.com.hellobank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.hellobank.exception.ClienteNotFoundException;
import br.com.hellobank.exception.CpfNotFoundException;
import br.com.hellobank.model.Cliente;
import br.com.hellobank.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {

	private ClienteRepository clienteRepository;

	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Transactional
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente buscarPorId(Long id) {

		if(!clienteRepository.existsById(id)) {
			throw new ClienteNotFoundException(id);
		}

		return clienteRepository.findById(id).orElse(null);
	}

	public Cliente buscarPorCpf(String cpf) {
		if (!clienteRepository.existsByCpf(cpf)) {
			throw new CpfNotFoundException(cpf);
		}

		return clienteRepository.findByCpf(cpf);
	}

	@Transactional
	public void deletar(Long id) {
		if(!clienteRepository.existsById(id)) {
			throw new ClienteNotFoundException(id);
		}

		clienteRepository.deleteById(id);
	}
}
