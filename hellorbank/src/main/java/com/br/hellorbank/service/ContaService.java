package com.br.hellorbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.hellorbank.model.Conta;
import com.br.hellorbank.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	public List<Conta> listarContas(){
		return contaRepository.findAll();
	}
	
	
	public Conta criar(Conta conta) {
		return contaRepository.save(conta);
	}

}
