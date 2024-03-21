package com.avaliacaoBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacaoBack.entities.Cliente;
import com.avaliacaoBack.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	private final ClienteService ClienteService;

	@Autowired
	public ClienteController(ClienteService ClienteService) {
		this.ClienteService = ClienteService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscaClienteControlId(@PathVariable Long id){
		Cliente Cliente = ClienteService.buscaClienteId(id);
		if (Cliente != null) {
			return ResponseEntity.ok(Cliente);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Cliente>> buscaTodosClienteControl(){
		List<Cliente> Cliente = ClienteService.buscaTodosCliente();

		return ResponseEntity.ok(Cliente);
	}
	@PostMapping("/")
	public ResponseEntity<Cliente> salvaClienteControl(@RequestBody Cliente Cliente){
		Cliente salvaCliente = ClienteService.SalvaCliente(Cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaCliente);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> alteraClienteControl(@PathVariable Long id, @RequestBody Cliente Cliente){
		Cliente alteraCliente = ClienteService.alterarCliente(id, Cliente);
		if(Cliente != null) {
			return ResponseEntity.ok(Cliente);
		}
		else {
			return ResponseEntity.notFound().build();   	
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaClienteControl(@PathVariable Long id){
		boolean apagar = ClienteService.apagarCliente(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Cliente foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}


}


