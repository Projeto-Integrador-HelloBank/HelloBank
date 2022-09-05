package com.br.hellorbank.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.hellorbank.model.Conta;
import com.br.hellorbank.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public Conta criar(Conta conta) {
		return contaRepository.save(conta);
	}

	public Conta buscarNumeroConta(String numeroConta) {
		return contaRepository.findByNumeroConta(numeroConta);
	}


	public Conta mudaSaldo(String numeroConta,String tipoTransacao, BigDecimal saldo) {
		Conta conta = buscarNumeroConta(numeroConta);
		if (conta != null) {
			if (tipoTransacao.equals("deposito")) {
				conta.setSaldo(conta.getSaldo().add(new BigDecimal(numeroConta)));
			} else if (tipoTransacao.equals("saque")) {
				conta.setSaldo(conta.getSaldo().subtract(new BigDecimal(numeroConta)));
			}
			contaRepository.save(conta);
		}
		return conta;
	}
}
