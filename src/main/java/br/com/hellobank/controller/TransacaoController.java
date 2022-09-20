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

import br.com.hellobank.dto.DepositoDTO;
import br.com.hellobank.dto.SaqueDTO;
import br.com.hellobank.dto.TransferenciaDTO;
import br.com.hellobank.model.Transacao;
import br.com.hellobank.service.ITransacaoService;

@RestController
@RequestMapping("/transacao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransacaoController {

	private ITransacaoService transacaoService;
	
	public TransacaoController(ITransacaoService transacaoService) {
		this.transacaoService = transacaoService;
	}

	@GetMapping
	public ResponseEntity<List<Transacao>> listarTodos() {
		return ResponseEntity.ok(transacaoService.listarTodos());
	}


	@GetMapping("/{codigo}")
	public ResponseEntity<Transacao> buscarPorCodigo(@PathVariable Long codigo) {

		if (!transacaoService.existeCodigo(codigo)) {

			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(transacaoService.buscarPorCodigo(codigo));

	}


	@PostMapping("/transferencia")
	public ResponseEntity<Transacao> fazerTransferencia(@RequestBody @Valid TransferenciaDTO transferencia) {
		Transacao movimentacaoSalva = transacaoService.fazerTransferencia(transferencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoSalva);
	}

	@PostMapping("/deposito")
	public ResponseEntity<Transacao> fazerDeposito(@RequestBody @Valid DepositoDTO deposito) {

		return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.fazerDeposito(deposito));
	}

	@PostMapping("/saque")
	public ResponseEntity<Transacao> fazerSaque(@RequestBody @Valid SaqueDTO saque) {
		Transacao movimentacaoSalva = transacaoService.fazerSaque(saque);
		return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoSalva);
	}
}
