package com.avaliacaoBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacaoBack.entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {

}
