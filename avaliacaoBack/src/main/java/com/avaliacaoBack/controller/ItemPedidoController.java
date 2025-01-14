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

import com.avaliacaoBack.entities.ItemPedido;
import com.avaliacaoBack.service.ItemPedidoService;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {
	private final ItemPedidoService ItemPedidoService;

	@Autowired
	public ItemPedidoController(ItemPedidoService ItemPedidoService) {
		this.ItemPedidoService = ItemPedidoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> buscaItemPedidoControlId(@PathVariable Long id){
		ItemPedido ItemPedido = ItemPedidoService.buscaItemPedidoId(id);
		if (ItemPedido != null) {
			return ResponseEntity.ok(ItemPedido);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<ItemPedido>> buscaTodosItemPedidoControl(){
		List<ItemPedido> ItemPedido = ItemPedidoService.buscaTodosItemPedido();

		return ResponseEntity.ok(ItemPedido);
	}
	@PostMapping("/")
	public ResponseEntity<ItemPedido> salvaItemPedidoControl(@RequestBody ItemPedido ItemPedido){
		ItemPedido salvaItemPedido = ItemPedidoService.SalvaItemPedido(ItemPedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemPedido);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ItemPedido> alteraItemPedidoControl(@PathVariable Long id, @RequestBody ItemPedido ItemPedido){
		ItemPedido alteraItemPedido = ItemPedidoService.alterarItemPedido(id, ItemPedido);
		if(ItemPedido != null) {
			return ResponseEntity.ok(ItemPedido);
		}
		else {
			return ResponseEntity.notFound().build();   	
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaItemPedidoControl(@PathVariable Long id){
		boolean apagar = ItemPedidoService.apagarItemPedido(id);
		if (apagar) {
			return ResponseEntity.ok().body("O ItemPedido foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}


}

