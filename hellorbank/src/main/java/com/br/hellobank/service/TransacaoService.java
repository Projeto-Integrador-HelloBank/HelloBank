package com.br.hellobank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.hellobank.model.Transacao;
import com.br.hellobank.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	
	public TransacaoRepository transacaoRepository;
	
	public Transacao salvar(Transacao transacao) {
		return transacaoRepository.save(transacao);
	}
	
	public List<Transacao> listarTodos() {
		return transacaoRepository.findAll();
	}
	
	public Optional<Transacao> buscarPorCodigo(Long codigo) {
		return transacaoRepository.findById(codigo);
	}

}

