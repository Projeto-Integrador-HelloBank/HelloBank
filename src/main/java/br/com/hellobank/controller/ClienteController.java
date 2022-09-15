package br.com.hellobank.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.hellobank.model.Cliente;
import br.com.hellobank.service.IClienteService;

@RestController
@RequestMapping(path = "/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	private IClienteService clienteService;
	
	public ClienteController(IClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Cliente> salvar(@Valid @RequestBody Cliente cliente) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(cliente));
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> listarTodos() {
		
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.listarTodos());
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable("id") Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarPorId(id));
	}

	@GetMapping(path = "/cpf/{cpf}")
	public ResponseEntity<Cliente> buscarPorCpf(@PathVariable("cpf") String cpf) {
		
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarPorCpf(cpf));
	}

	@PutMapping(path = "/atualizar")
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente) {
		
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.salvar(cliente));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
			
		clienteService.deletar(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}}
	
	
