package br.com.hellobank.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import br.com.hellobank.enums.TipoMovimentacao;
import br.com.hellobank.model.Conta;
import br.com.hellobank.model.Transacao;
import br.com.hellobank.service.ContaServiceImpl;

public class TransferenciaDTO {

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTransacao = new java.sql.Date(System.currentTimeMillis());

	@Digits(integer = 7, fraction = 2, message = "Apenas milhares e 2 casas apos o ponto")
	private BigDecimal valorTransacao;

	@NotBlank(message = "Obrigatorio colocar numero da conta")
	private String contaOrigem;

	@NotBlank(message = "Obrigatorio colocar numero da conta")
	private String contaDestino;

	public Transacao toModel(ContaServiceImpl contaService) {
		Transacao movimentacao = new Transacao();
		Conta contaOrigem = contaService.buscarNumeroConta(this.contaOrigem);
		Conta contaDestino = contaService.buscarNumeroConta(this.contaDestino);
		movimentacao.setValorTransacao(this.valorTransacao);
		movimentacao.setContaOrigem(contaOrigem);
		movimentacao.setContaDestino(contaDestino);
		movimentacao.setTipoTransacao(TipoMovimentacao.TRANSFERENCIA);

		return movimentacao;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public BigDecimal getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(BigDecimal valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

}
