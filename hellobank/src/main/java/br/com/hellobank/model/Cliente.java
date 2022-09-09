package br.com.hellobank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 100, message = "O nome deve possuir entre 3 a 50 caracteres")
	@Column(name = "nome")
	private String nome;
	
	@CPF(message = "CPF inválido")
	@NotBlank(message = "CPF é obrigatório")
	@Size(min = 10,  max = 20, message = "O cpf ou cnpj deve possuir entre 10 a 20 caracteres")
	@Column(name = "cpf", unique = true)
	private String cpf;

	@NotBlank(message = "Endereço é obrigatório")
	@Size (min = 10, max=50, message = "O endereço deve possuir entre 10 a 50 caracteres")
	@Column (name = "endereco")
	private String endereco;
	
	@NotBlank(message = "A cidade é obrigatório")
	@Size (min = 4, max = 50, message = "A cidade deve possuir entre 4 a 15 caracteres")
	@Column (name = "cidade")
	private String cidade;
	
	@NotBlank(message = "Estado é obrigatório")
	@Size (max = 2, message = "O estado deve possuir 2 caracteres")
	@Column (name = "estado")
	private String estado;
	
	@Email (message = "E-mail inválido")
	@NotBlank (message = "E-mail é obrigatório")
	@Size (min = 10, max=60, message = "O E-mail deve possuir entre 20 a 60 caracteres")
	@Column (name = "email", unique = true)
	private String email;
	
	@NotBlank (message = "O número de telefone é obrigatório")
	@Size (min = 1, max = 18, message = "O número de telefone é obrigatório")
	@Column (name = "telefone")
	private String telefone;
}
