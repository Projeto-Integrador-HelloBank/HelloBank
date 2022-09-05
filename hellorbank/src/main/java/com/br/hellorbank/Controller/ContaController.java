package com.br.hellorbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.hellorbank.model.Conta;
import com.br.hellorbank.service.ContaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("\"tb_conta\"")

public class ContaController {
	@Autowired
	private ContaService service;

	@PostMapping
	public ResponseEntity<Conta> criar(@RequestBody Conta conta) {

		Conta contaCriar = service.criar(conta);
		return ResponseEntity.status(HttpStatus.CREATED).body(contaCriar);
	}

}
