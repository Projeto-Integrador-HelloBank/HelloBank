package br.com.hellobank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hellobank.model.Cliente;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
Optional <Cliente>findByCpf(String cpf);

}
