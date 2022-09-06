package com.br.hellobank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.hellobank.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

}
