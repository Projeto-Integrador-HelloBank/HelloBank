package com.br.hellorbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 50, message = "O nome deve possuir entre 3 a 50 caracteres")
	@Column(name = "nome")
	private String nome;
	
	@NotBlank(message = "CPF ou CNPJ é obrigatório")
	@Size(min = 10,  max = 20, message = "O cpf ou cnpj deve possuir entre 10 a 20 caracteres")
	@Column(name = "cpf_cnpj")
	private String cpfCnpj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
	
	
}
