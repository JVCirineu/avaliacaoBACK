package com.avaliacaoBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacaoBack.entities.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long>{

}
