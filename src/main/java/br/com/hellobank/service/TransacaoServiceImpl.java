package br.com.hellobank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.hellobank.dto.DepositoDTO;
import br.com.hellobank.dto.SaqueDTO;
import br.com.hellobank.dto.TransferenciaDTO;
import br.com.hellobank.model.Conta;
import br.com.hellobank.model.Transacao;
import br.com.hellobank.repository.TransacaoRepository;

@Service
public class TransacaoServiceImpl implements ITransacaoService {

	private TransacaoRepository transacaoRepository;

	private ContaServiceImpl contaService;

	public TransacaoServiceImpl(TransacaoRepository transacaoRepository, ContaServiceImpl contaService) {
		this.contaService = contaService;
		this.transacaoRepository = transacaoRepository;
	}

	public List<Transacao> listarTodos() {

		return transacaoRepository.findAll();
	}

	public Transacao buscarPorCodigo(Long codigo) {

		return transacaoRepository.findById(codigo).orElse(null);
	}

	@Transactional
	public Transacao fazerTransferencia(TransferenciaDTO transferencia) {

		Transacao transferenciaConta = transferencia.toModel(contaService);
		contaService.atualizarSaldo(transferenciaConta.getContaOrigem(), transferenciaConta.getContaDestino(),
				transferenciaConta.getValorTransacao());

		return transacaoRepository.save(transferenciaConta);
	}

	@Transactional
	public Transacao fazerDeposito(DepositoDTO deposito) {

		Transacao depositoConta = deposito.toModel(contaService);
		contaService.atualizarSaldo(depositoConta.getContaOrigem(), depositoConta.getContaDestino(),
				depositoConta.getValorTransacao());

		return transacaoRepository.save(depositoConta);
	}

	@Transactional
	public Transacao fazerSaque(SaqueDTO saque) {

		Transacao saqueConta = saque.toModel(contaService);
		contaService.atualizarSaldo(saqueConta.getContaOrigem(), saqueConta.getContaDestino(),
				saqueConta.getValorTransacao());

		return transacaoRepository.save(saqueConta);
	}

	public Conta buscarConta(String numeroConta) {

		return contaService.buscarNumeroConta(numeroConta);
	}

	
	public boolean existeCodigo(Long codigo) {
	
		return transacaoRepository.existsById(codigo);
	}

}
