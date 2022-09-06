package com.br.hellobank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.hellobank.model.Cliente;
import com.br.hellobank.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@PostMapping("/cadastrar")
	public ResponseEntity<Cliente> salvar(@Valid @RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(cliente));

	}

	@GetMapping
	public ResponseEntity<List<Cliente>> listarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {

		Optional<Cliente> clienteOptional = service.buscarPorId(id);

		if (clienteOptional.isEmpty()) {

			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());

	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Cliente> buscarPorCpf(@PathVariable String cpf) {

		Optional<Cliente> clienteOptional = service.buscarPorCpf(cpf);

		if (clienteOptional.isEmpty()) {

			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());

	}

	@PutMapping("/atualizar")
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente) {

		Cliente clienteSalvo = service.salvar(cliente);
		return ResponseEntity.status(HttpStatus.OK).body(clienteSalvo);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
