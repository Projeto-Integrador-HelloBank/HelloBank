package com.br.hellobank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.hellobank.model.Cliente;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
Optional <Cliente>findByCpf(String cpf);

}
