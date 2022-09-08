package com.br.hellobank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.hellobank.model.Conta;
import com.br.hellobank.service.ContaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/conta")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContaController {
	@Autowired
	private ContaService service ;

	
	@GetMapping
	public ResponseEntity<List<Conta>> listarContas(){
		return ResponseEntity.ok(service.listarContas());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Conta> criar(@Valid @RequestBody Conta conta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(conta));
	}
	
//	
//	@PutMapping("{numero}/deposito/{valor}")
//	public ResponseEntity<Conta> deposito(@PathVariable String numero, @PathVariable BigDecimal valor) {
//		service.mudaSaldo(numero, "deposito", valor);
//		service.buscarNumeroConta(numero);
//		 return ResponseEntity.status(HttpStatus.OK).build();
//	}
//	
//	@PutMapping("{numero}/saque/{valor}")
//	public ResponseEntity<Conta> saque(@PathVariable String numero, @PathVariable BigDecimal valor) {
//		service.mudaSaldo(numero, "saque", valor);
//		service.buscarNumeroConta(numero);
//		 return ResponseEntity.status(HttpStatus.OK).build();
//	}

}
