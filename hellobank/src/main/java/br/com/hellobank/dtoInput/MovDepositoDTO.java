package br.com.hellobank.dtoInput;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import br.com.hellobank.model.Conta;
import br.com.hellobank.model.TipoMovimentacao;
import br.com.hellobank.model.Transacao;
import br.com.hellobank.service.ContaService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovDepositoDTO {

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTransacao = new java.sql.Date(System.currentTimeMillis());

	@Digits(integer = 7, fraction = 2, message = "Apenas milhares e 2 casas apos o ponto")
	private BigDecimal valorTransacao;

	@NotBlank(message = "Obrigatorio colocar numero da conta")
	private String contaDestino;

	public Transacao toModel(ContaService contaService) {
		Transacao movimentacao = new Transacao();
		Conta contaDestino = contaService.buscarNumeroConta(this.contaDestino);
		movimentacao.setValorTransacao(this.valorTransacao);
		movimentacao.setContaDestino(contaDestino);
		movimentacao.setTipoTransacao(TipoMovimentacao.DEPOSITO);

		return movimentacao;
	}
}
