package com.br.hellorbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.hellorbank.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

}
