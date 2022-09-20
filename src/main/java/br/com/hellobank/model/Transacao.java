package br.com.hellobank.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import br.com.hellobank.enums.TipoMovimentacao;

@Entity
@Table(name = "tb_transacao")
public class Transacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_transacao")
	private TipoMovimentacao tipoTransacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_transacao")
	private Date dataTransacao = new java.sql.Date(System.currentTimeMillis());

	@Digits(integer = 7, fraction = 2, message = "Apenas milhares e 2 casas apos o ponto")
	@Column(name = "valor_transacao")
	private BigDecimal valorTransacao;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "conta_origem")
	private Conta contaOrigem;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "conta_destino")
	private Conta contaDestino;

	public Long getCodigo() {
		return codigo;
	}

	public TipoMovimentacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoMovimentacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
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
