package com.avaliacaoBack.controller;

import java.util.List;

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

import com.avaliacaoBack.entities.Fornecedor;
import com.avaliacaoBack.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
	private final FornecedorService FornecedorService;

	@Autowired
	public FornecedorController(FornecedorService FornecedorService) {
		this.FornecedorService = FornecedorService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> buscaFornecedorControlId(@PathVariable Long id){
		Fornecedor Fornecedor = FornecedorService.buscaFornecedorId(id);
		if (Fornecedor != null) {
			return ResponseEntity.ok(Fornecedor);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Fornecedor>> buscaTodosFornecedorControl(){
		List<Fornecedor> Fornecedor = FornecedorService.buscaTodosFornecedor();

		return ResponseEntity.ok(Fornecedor);
	}
	@PostMapping("/")
	public ResponseEntity<Fornecedor> salvaFornecedorControl(@RequestBody Fornecedor Fornecedor){
		Fornecedor salvaFornecedor = FornecedorService.SalvaFornecedor(Fornecedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaFornecedor);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> alteraFornecedorControl(@PathVariable Long id, @RequestBody Fornecedor Fornecedor){
		Fornecedor alteraFornecedor = FornecedorService.alterarFornecedor(id, Fornecedor);
		if(Fornecedor != null) {
			return ResponseEntity.ok(Fornecedor);
		}
		else {
			return ResponseEntity.notFound().build();   	
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaFornecedorControl(@PathVariable Long id){
		boolean apagar = FornecedorService.apagarFornecedor(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Fornecedor foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}


}
