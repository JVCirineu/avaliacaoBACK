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

import com.avaliacaoBack.entities.Produto;
import com.avaliacaoBack.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	private final ProdutoService ProdutoService;

	@Autowired
	public ProdutoController(ProdutoService ProdutoService) {
		this.ProdutoService = ProdutoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscaProdutoControlId(@PathVariable Long id){
		Produto Produto = ProdutoService.buscaProdutoId(id);
		if (Produto != null) {
			return ResponseEntity.ok(Produto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Produto>> buscaTodosProdutoControl(){
		List<Produto> Produto = ProdutoService.buscaTodosProduto();

		return ResponseEntity.ok(Produto);
	}
	@PostMapping("/")
	public ResponseEntity<Produto> salvaProdutoControl(@RequestBody Produto Produto){
		Produto salvaProduto = ProdutoService.SalvaProduto(Produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Produto> alteraProdutoControl(@PathVariable Long id, @RequestBody Produto Produto){
		Produto alteraProduto = ProdutoService.alterarProduto(id, Produto);
		if(Produto != null) {
			return ResponseEntity.ok(Produto);
		}
		else {
			return ResponseEntity.notFound().build();   	
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaProdutoControl(@PathVariable Long id){
		boolean apagar = ProdutoService.apagarProduto(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Produto foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}


}

