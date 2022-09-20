package br.com.hellobank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hellobank.model.Conta;
import br.com.hellobank.service.IContaService;

@RestController
@RequestMapping("/conta")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContaController {

	private IContaService contaService;
	
	public ContaController(IContaService contaService) {
		this.contaService = contaService;
	}

	@GetMapping
	public ResponseEntity<List<Conta>> listarContas() {
		
		return ResponseEntity.ok(contaService.listarContas());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Conta> criar(@Valid @RequestBody Conta conta) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(contaService.criar(conta));
	}

	@GetMapping("numero-conta/{numeroConta}")
	public ResponseEntity<Conta> buscarPorNumeroConta(@PathVariable String numeroConta){
		return ResponseEntity.ok(contaService.buscarNumeroConta(numeroConta));
	}
}
