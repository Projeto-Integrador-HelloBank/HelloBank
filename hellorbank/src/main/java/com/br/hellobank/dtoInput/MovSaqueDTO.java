package com.br.hellobank.dtoInput;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import com.br.hellobank.model.Conta;
import com.br.hellobank.model.TipoMovimentacao;
import com.br.hellobank.model.Transacao;
import com.br.hellobank.service.ContaService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovSaqueDTO {
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTransacao = new java.sql.Date(System.currentTimeMillis());

	@Digits(integer = 7, fraction = 2, message = "Apenas milhares e 2 casas apos o ponto")
	private BigDecimal valorTransacao;

	@NotBlank(message = "Obrigatorio colocar numero da conta")
	private String contaOrigem;
	
	 public Transacao toModel(ContaService contaService){
		 Transacao movimentacao = new Transacao();
	        Conta contaOrigem = contaService.buscarNumeroConta(this.contaOrigem);
	        movimentacao.setValorTransacao(this.valorTransacao);
	        movimentacao.setContaOrigem(contaOrigem);
	        movimentacao.setTipoTransacao(TipoMovimentacao.SAQUE);

	        return movimentacao;
	    }
}
