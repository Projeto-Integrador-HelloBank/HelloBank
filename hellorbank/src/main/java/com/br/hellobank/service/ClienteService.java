package com.br.hellobank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.hellobank.model.Cliente;
import com.br.hellobank.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private  ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id){

        return clienteRepository.findById(id);
    }
    public Optional<Cliente> buscarPorCpf(String cpf){

        return clienteRepository.findByCpf(cpf);
    }

    public void deletar(Long id){

        clienteRepository.deleteById(id);
    }

}