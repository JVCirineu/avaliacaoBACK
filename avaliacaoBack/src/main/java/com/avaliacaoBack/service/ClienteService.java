package com.avaliacaoBack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacaoBack.entities.Cliente;
import com.avaliacaoBack.repository.ClienteRepository;

@Service
public class ClienteService {
	private final ClienteRepository ClienteRepository;

	//construtor que recebe a dependencia
	@Autowired
	public ClienteService(ClienteRepository ClienteRepository) {
		this.ClienteRepository = ClienteRepository;
	}

	public List<Cliente> buscaTodosCliente(){
		return ClienteRepository.findAll();
	}

	public Cliente buscaClienteId(Long id) {
		Optional <Cliente> Cliente = ClienteRepository.findById(id);
		return Cliente.orElse(null);
	}
	//metodo salvar os produtos
	public Cliente SalvaCliente(Cliente Cliente) {
		return ClienteRepository.save(Cliente);
	}
	public Cliente alterarCliente(Long id, Cliente alterarCliente) {
		Optional <Cliente> existeCliente = ClienteRepository.findById(id);

		if (existeCliente.isPresent()) {
			alterarCliente.setId(id);
			return ClienteRepository.save(alterarCliente);
		}
		return null;
	}
	public boolean apagarCliente(Long id) {
		Optional <Cliente> existeCliente = ClienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			ClienteRepository.deleteById(id);
			return true;
		}
		return false;
	}

}


