package com.br.hellorbank.controller;

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

import com.br.hellorbank.model.Conta;
import com.br.hellorbank.service.ContaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/conta")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContaController {
	@Autowired
	private ContaService service;

	
	@GetMapping
	public ResponseEntity<List<Conta>> listarContas(){
		return ResponseEntity.ok(service.listarContas());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Conta> criar(@Valid @RequestBody Conta conta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(conta));
	}

}
