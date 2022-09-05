package com.br.hellorbank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.hellorbank.model.Cliente;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
Optional <Cliente>findByCpf(String cpf);

}
