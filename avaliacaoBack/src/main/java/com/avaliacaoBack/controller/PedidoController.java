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

import com.avaliacaoBack.entities.Pedido;
import com.avaliacaoBack.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	private final PedidoService PedidoService;

	@Autowired
	public PedidoController(PedidoService PedidoService) {
		this.PedidoService = PedidoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscaPedidoControlId(@PathVariable Long id){
		Pedido Pedido = PedidoService.buscaPedidoId(id);
		if (Pedido != null) {
			return ResponseEntity.ok(Pedido);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Pedido>> buscaTodosPedidoControl(){
		List<Pedido> Pedido = PedidoService.buscaTodosPedido();

		return ResponseEntity.ok(Pedido);
	}
	@PostMapping("/")
	public ResponseEntity<Pedido> salvaPedidoControl(@RequestBody Pedido Pedido){
		Pedido salvaPedido = PedidoService.SalvaPedido(Pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaPedido);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> alteraPedidoControl(@PathVariable Long id, @RequestBody Pedido Pedido){
		Pedido alteraPedido = PedidoService.alterarPedido(id, Pedido);
		if(Pedido != null) {
			return ResponseEntity.ok(Pedido);
		}
		else {
			return ResponseEntity.notFound().build();   	
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaPedidoControl(@PathVariable Long id){
		boolean apagar = PedidoService.apagarPedido(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Pedido foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}


}



