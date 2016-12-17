package br.com.globalcode.jsf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.globalcode.jsf.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
