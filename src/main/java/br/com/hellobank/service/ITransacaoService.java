package br.com.hellobank.service;

import java.util.List;

import br.com.hellobank.dto.DepositoDTO;
import br.com.hellobank.dto.SaqueDTO;
import br.com.hellobank.dto.TransferenciaDTO;
import br.com.hellobank.model.Conta;
import br.com.hellobank.model.Transacao;

public interface ITransacaoService {
	List<Transacao> listarTodos();

	Transacao buscarPorCodigo(Long codigo);

	Transacao fazerTransferencia(TransferenciaDTO transferencia);
		
	Transacao fazerDeposito(DepositoDTO deposito);
		
	Transacao fazerSaque(SaqueDTO saque);

	Conta buscarConta(String numeroConta);
	
	boolean existeCodigo(Long codigo);
	
}
