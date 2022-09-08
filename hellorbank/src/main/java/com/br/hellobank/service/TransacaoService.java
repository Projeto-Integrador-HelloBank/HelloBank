package com.br.hellobank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.hellobank.dtoInput.MovDepositoDTO;
import com.br.hellobank.dtoInput.MovSaqueDTO;
import com.br.hellobank.dtoInput.MovTransferenciaDTO;
import com.br.hellobank.model.Conta;
import com.br.hellobank.model.Transacao;
import com.br.hellobank.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	public TransacaoRepository transacaoRepository;

	@Autowired
	private ContaService contaService;

//	public Transacao transacao(MovimentacaoDepositoDTO transacao) {
//		Conta origem = buscarConta(transacao.getContaOrigem());
//		Conta destino = buscarConta(transacao.getContaDestino());
//
//		contaService.atualizarSaldo(origem, destino, transacao.getValorTransacao(), transacao.getTipo().toString());
//
//		Transacao movimentacao = new Transacao();
//		movimentacao.setValorTransacao(transacao.getValorTransacao());
//		movimentacao.setContaOrigem(origem);
//		movimentacao.setContaDestino(destino);
//		return movimentacao;
//	}

	public List<Transacao> listarTodos() {
		return transacaoRepository.findAll();
	}

	public Optional<Transacao> buscarPorCodigo(Long codigo) {
		return transacaoRepository.findById(codigo);
	}

	public Transacao fazerTransferencia(MovTransferenciaDTO transferencia) {
		Transacao transferenciaConta = transferencia.toModel(contaService);
		contaService.atualizarSaldo(transferenciaConta.getContaOrigem(), transferenciaConta.getContaDestino(),
				transferenciaConta.getValorTransacao());
		return transacaoRepository.save(transferenciaConta);

	}

	public Transacao fazerDeposito(MovDepositoDTO deposito) {
		Transacao depositoConta = deposito.toModel(contaService);
		contaService.atualizarSaldo(depositoConta.getContaOrigem(), depositoConta.getContaDestino(),
				depositoConta.getValorTransacao());
		return transacaoRepository.save(depositoConta);
	}

	public Transacao fazerSaque(MovSaqueDTO saque) {
		Transacao saqueConta = saque.toModel(contaService);
		contaService.atualizarSaldo(saqueConta.getContaOrigem(), saqueConta.getContaDestino(),
				saqueConta.getValorTransacao());		
		return transacaoRepository.save(saqueConta);
	}

	public Conta buscarConta(String numeroConta) {
		return contaService.buscarNumeroConta(numeroConta);
	}

}