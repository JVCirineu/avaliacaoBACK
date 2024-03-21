package com.avaliacaoBack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacaoBack.entities.Fornecedor;
import com.avaliacaoBack.repository.FornecedorRepository;

@Service
public class FornecedorService {
	 private final FornecedorRepository fornecedorRepository;

	    //construtor que recebe a dependencia
	    @Autowired
	    public FornecedorService(FornecedorRepository fornecedorRepository) {
	        this.fornecedorRepository = fornecedorRepository;
	    }
	    
	    public List<Fornecedor> buscaTodosFornecedor(){
	    	return fornecedorRepository.findAll();
	    }
	    
	    public Fornecedor buscaFornecedorId(Long id) {
	        Optional <Fornecedor> fornecedor = fornecedorRepository.findById(id);
	        return fornecedor.orElse(null);
	    }
	    //metodo salvar os produtos
	    public Fornecedor SalvaFornecedor(Fornecedor fornecedor) {
	    	return fornecedorRepository.save(fornecedor);
	    }
	    public Fornecedor alterarFornecedor(Long id, Fornecedor alterarFornecedor) {
	    	Optional <Fornecedor> existeFornecedor = fornecedorRepository.findById(id);
	    	
	    	if (existeFornecedor.isPresent()) {
	    		alterarFornecedor.setId(id);
	    		return fornecedorRepository.save(alterarFornecedor);
	    	}
	    	return null;
	    }
	    public boolean apagarFornecedor(Long id) {
	    	Optional <Fornecedor> existeFornecedor = fornecedorRepository.findById(id);
	    	if (existeFornecedor.isPresent()) {
	    		fornecedorRepository.deleteById(id);
	    		return true;
	    	}
	    	return false;
	    }

}

