package com.br.hellobank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.hellobank.model.Transacao;
import com.br.hellobank.service.TransacaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {

	@Autowired
	private TransacaoService service;
	
	@GetMapping
	public ResponseEntity<List<Transacao>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}


	@PostMapping("/cadastrar")
	public ResponseEntity<Transacao> salvar(@RequestBody Transacao transacao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(transacao));
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Transacao> buscarPorCodigo(@PathVariable Long codigo) {

		Optional<Transacao> transacaoOptional = service.buscarPorCodigo(codigo);

		if (transacaoOptional.isEmpty()) {

			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(transacaoOptional.get());

	}

}
