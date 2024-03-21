package com.avaliacaoBack.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.avaliacaoBack.entities.Produto;
import com.avaliacaoBack.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;

    //construtor que recebe a dependencia
    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    
    public List<Produto> buscaTodosProduto(){
    	return produtoRepository.findAll();
    }
    
    public Produto buscaProdutoId(Long id) {
        Optional <Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }
    //metodo salvar os produtos
    public Produto SalvaProduto(Produto Produto) {
    	return produtoRepository.save(Produto);
    }
    public Produto alterarProduto(Long id, Produto alterarProduto) {
    	Optional <Produto> existeProduto = produtoRepository.findById(id);
    	
    	if (existeProduto.isPresent()) {
    		alterarProduto.setId(id);
    		return produtoRepository.save(alterarProduto);
    	}
    	return null;
    }
    public boolean apagarProduto(Long id) {
    	Optional <Produto> existeProduto = produtoRepository.findById(id);
    	if (existeProduto.isPresent()) {
    		produtoRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }

}

