package com.br.hellobank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.hellobank.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
