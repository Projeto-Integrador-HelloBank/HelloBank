package com.br.hellorbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.hellorbank.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
