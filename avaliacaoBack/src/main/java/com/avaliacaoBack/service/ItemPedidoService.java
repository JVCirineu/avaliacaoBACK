package com.avaliacaoBack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacaoBack.entities.ItemPedido;
import com.avaliacaoBack.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	private final ItemPedidoRepository itemPedidoRepository;

    //construtor que recebe a dependencia
    @Autowired
    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }
    
    public List<ItemPedido> buscaTodosItemPedido(){
    	return itemPedidoRepository.findAll();
    }
    
    public ItemPedido buscaItemPedidoId(Long id) {
        Optional <ItemPedido> itemPedido = itemPedidoRepository.findById(id);
        return itemPedido.orElse(null);
    }
    //metodo salvar os produtos
    public ItemPedido SalvaItemPedido(ItemPedido itemPedido) {
    	return itemPedidoRepository.save(itemPedido);
    }
    public ItemPedido alterarItemPedido(Long id, ItemPedido alterarItemPedido) {
    	Optional <ItemPedido> existeItemPedido = itemPedidoRepository.findById(id);
    	
    	if (existeItemPedido.isPresent()) {
    		alterarItemPedido.setId(id);
    		return itemPedidoRepository.save(alterarItemPedido);
    	}
    	return null;
    }
    public boolean apagarItemPedido(Long id) {
    	Optional <ItemPedido> existeItemPedido = itemPedidoRepository.findById(id);
    	if (existeItemPedido.isPresent()) {
    		itemPedidoRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }

}


