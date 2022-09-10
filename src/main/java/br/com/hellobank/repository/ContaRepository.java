package br.com.hellobank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hellobank.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

	Conta findByNumeroConta(String numeroConta);
}
