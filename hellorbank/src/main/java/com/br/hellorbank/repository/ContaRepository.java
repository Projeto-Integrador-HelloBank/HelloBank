package com.br.hellorbank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.hellorbank.model.Cliente;
import com.br.hellorbank.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
	
	 Conta findByNumeroConta(String numeroConta);
}
