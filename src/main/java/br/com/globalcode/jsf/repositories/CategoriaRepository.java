package br.com.globalcode.jsf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.globalcode.jsf.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
