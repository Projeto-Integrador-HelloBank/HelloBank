package com.br.hellorbank.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.hellorbank.model.Cliente;
import com.br.hellorbank.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("\"tb_cliente\"")

public class ClienteController {

	@Autowired
	private ClienteService service;

	@PostMapping
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {

		Cliente clienteSalvo = service.salvar(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);

	}

	@GetMapping
	public ResponseEntity<List<Cliente>> listarTodos() {

		List<Cliente> cliente = service.listarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(cliente);

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

	@PutMapping
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
