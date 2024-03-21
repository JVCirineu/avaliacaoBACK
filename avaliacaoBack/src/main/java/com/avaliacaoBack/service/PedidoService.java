package com.avaliacaoBack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacaoBack.entities.Pedido;
import com.avaliacaoBack.repository.PedidoRepository;

@Service
public class PedidoService {
	private final PedidoRepository pedidoRepository;

    //construtor que recebe a dependencia
    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    
    public List<Pedido> buscaTodosPedido(){
    	return pedidoRepository.findAll();
    }
    
    public Pedido buscaPedidoId(Long id) {
        Optional <Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElse(null);
    }
    //metodo salvar os produtos
    public Pedido SalvaPedido(Pedido Pedido) {
    	return pedidoRepository.save(Pedido);
    }
    public Pedido alterarPedido(Long id, Pedido alterarPedido) {
    	Optional <Pedido> existePedido = pedidoRepository.findById(id);
    	
    	if (existePedido.isPresent()) {
    		alterarPedido.setId(id);
    		return pedidoRepository.save(alterarPedido);
    	}
    	return null;
    }
    public boolean apagarPedido(Long id) {
    	Optional <Pedido> existePedido = pedidoRepository.findById(id);
    	if (existePedido.isPresent()) {
    		pedidoRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }

}

