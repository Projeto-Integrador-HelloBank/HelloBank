package com.br.hellorbank.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.hellorbank.model.Conta;
import com.br.hellorbank.model.Transacao;
import com.br.hellorbank.service.ContaService;
import com.br.hellorbank.service.TransacaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("\"tb_transacao\"")
public class TransacaoController {

	
	private TransacaoService service;
	
	private ContaService contaService;

	@PostMapping
	public ResponseEntity<Transacao> salvar(@RequestBody Transacao transacao) {

		Transacao transacaoSalvo = service.salvar(transacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(transacaoSalvo);

	}

	@GetMapping
	public ResponseEntity<List<Transacao>> listarTodos() {

		List<Transacao> transacao = service.listarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(transacao);

	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Transacao> buscarPorCodigo(@PathVariable Long codigo) {

		Optional<Transacao> transacaoOptional = service.buscarPorCodigo(codigo);

		if (transacaoOptional.isEmpty()) {

			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(transacaoOptional.get());

	}
	
	@PutMapping("{numero}/deposito/{valor}")
	public ResponseEntity<Conta> deposito(@PathVariable String numero, @PathVariable BigDecimal valor) {
		contaService.mudaSaldo(numero, "deposito", valor);
		 contaService.buscarNumeroConta(numero);
		 return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping("{numero}/saque/{valor}")
	public ResponseEntity<Conta> saque(@PathVariable String numero, @PathVariable BigDecimal valor) {
		contaService.mudaSaldo(numero, "saque", valor);
		 contaService.buscarNumeroConta(numero);
		 return ResponseEntity.status(HttpStatus.OK).build();
	}

}
