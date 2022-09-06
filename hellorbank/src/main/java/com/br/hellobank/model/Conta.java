package com.br.hellobank.model;

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
@Table(name = "tb_conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;
	
	@NotBlank(message = "A escolha do tipo de conta é obrigatório")
	@Size(min = 5, max = 20, message = "O tipo de conta possuir entre 10 até 20 caracteres")
	@Column(name = "tipo_conta")
	private String tipoConta;
	
	@NotBlank(message = "Número da conta é obrigatório")
	@Size(min = 2, max = 50, message = "O número da conta deve possuir entre 2 até 50 caracteres")
	@Column(name = "numero_conta")
	private String numeroConta;
	
	@NotBlank(message = "Número da agência é obrigatório")
	@Size(min = 2, max = 10, message = "A agência deve possuir entre 2 até 50 caracteres")
	@Column(name = "agencia")
	private String agencia;
	
	@Digits(integer = 7, fraction = 2, message = "Apenas milhares e 2 casas apos o ponto")
	@Column(name = "saldo")
	private BigDecimal saldo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao")
	private Date dataCriacao = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

}
