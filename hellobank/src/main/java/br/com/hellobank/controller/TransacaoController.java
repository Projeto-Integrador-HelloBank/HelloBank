package br.com.hellobank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hellobank.dto.MovDepositoDTO;
import br.com.hellobank.dto.MovSaqueDTO;
import br.com.hellobank.dto.MovTransferenciaDTO;
import br.com.hellobank.model.Transacao;
import br.com.hellobank.service.TransacaoService;

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

	@GetMapping("/{codigo}")
	public ResponseEntity<Transacao> buscarPorCodigo(@PathVariable Long codigo) {

		Optional<Transacao> transacaoOptional = service.buscarPorCodigo(codigo);

		if (transacaoOptional.isEmpty()) {

			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(transacaoOptional.get());

	}

	@PostMapping("/transferencia")
	public ResponseEntity<Transacao> fazerTransferencia(@RequestBody @Valid MovTransferenciaDTO transferencia) {
		Transacao movimentacaoSalva = service.fazerTransferencia(transferencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoSalva);
	}

	@PostMapping("/deposito")
	public ResponseEntity<Transacao> fazerDeposito(@RequestBody @Valid MovDepositoDTO deposito) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.fazerDeposito(deposito));
	}

	@PostMapping("/saque")
	public ResponseEntity<Transacao> fazerSaque(@RequestBody @Valid MovSaqueDTO saque) {
		Transacao movimentacaoSalva = service.fazerSaque(saque);
		return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoSalva);
	}

}
