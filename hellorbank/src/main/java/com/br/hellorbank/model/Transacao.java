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
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
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
	private String tipoTransacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_transacao")
	private Date dataTransacao = new java.sql.Date(System.currentTimeMillis());
	
	@Digits(integer = 7, fraction = 2, message = "Apenas milhares e 2 casas apos o ponto")
	@Column(name = "valor_transacao")
	private BigDecimal valorTransacao;
	
	@ManyToOne
	@JoinColumn(name = "conta_origem")
	private Conta contaOrigem;
	
	@ManyToOne
	@JoinColumn(name = "conta_destino")
	private Conta contaDestino;

}
