package br.com.hellobank.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.hellobank.exception.ContaSemSaldoException;
import br.com.hellobank.model.Conta;
import br.com.hellobank.repository.ContaRepository;

@Service
public class ContaServiceImpl implements IContaService{

	private ContaRepository contaRepository;
	
	public ContaServiceImpl(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}
	
	public List<Conta> listarContas() {
		
		return contaRepository.findAll();
	}

	@Transactional
	public Conta criar(Conta conta) {
		
		return contaRepository.save(conta);
	}

	public Conta buscarNumeroConta(String numeroConta) {

		return contaRepository.findByNumeroConta(numeroConta);
	}

	@Transactional
	public void atualizarSaldo(Conta contaOrigem, Conta contaDestino, BigDecimal valor) {

		if (contaOrigem != null) {
			if (contaOrigem.getSaldo().compareTo(valor) >= 0) {
				contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
			}

			else {
				throw new ContaSemSaldoException(
						String.format("valor do saldo '%s'", contaOrigem.getSaldo().toString()));
			}
			contaRepository.save(contaOrigem);
		}

		if (contaDestino != null) {
			contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
			contaRepository.saveAndFlush(contaDestino);
		}		
	}

}
