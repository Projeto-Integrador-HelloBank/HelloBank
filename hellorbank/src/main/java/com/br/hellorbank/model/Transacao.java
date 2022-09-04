package com.br.hellorbank.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_transacao")
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	@NotBlank(message = "Tipo da transação é obrigatório")
	@Size(min = 5, max = 50, message = "O tipo de transação deve possuir entre 5 até 50 caracteres")
	@Column(name = "tipo_transacao")
	private String tipoTransicao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_transacao")
	private Date dataTransacao;
	
	@NotBlank(message = "Valor da transaçao é obrigatório")
	@Column(name = "valor_transacao")
	private BigDecimal valorTransacao;
	
	@ManyToOne
	@JoinColumn(name = "conta_origem")
	private Conta contaOrigem;
	
	@ManyToOne
	@JoinColumn(name = "conta_destino")
	private Conta contaDestino;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getTipoTransicao() {
		return tipoTransicao;
	}

	public void setTipoTransicao(String tipoTransicao) {
		this.tipoTransicao = tipoTransicao;
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

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}
	
	
}
