package br.com.hellobank.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.hellobank.model.Conta;

public interface IContaService {

	List<Conta> listarContas();

	Conta criar(Conta conta);

	Conta buscarNumeroConta(String numeroConta);

	void atualizarSaldo(Conta contaOrigem, Conta contaDestino, BigDecimal valor);

}