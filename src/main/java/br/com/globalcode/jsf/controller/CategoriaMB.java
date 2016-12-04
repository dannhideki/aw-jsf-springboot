package br.com.globalcode.jsf.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.globalcode.jsf.model.Categoria;
import br.com.globalcode.jsf.repositories.CategoriaRepository;

@Controller
@Scope("session")
public class CategoriaMB {

	@Autowired
	private CategoriaRepository categoriaRepository;
	private Collection<Categoria> categorias;
	private Categoria categoria;

	public CategoriaMB() {
		categorias = new ArrayList<Categoria>();
		categoria = new Categoria();
	}

	public void setCategorias(Collection<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Collection<Categoria> getCategorias() {
		try {
			categorias = categoriaRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categorias;
	}

	public void setCategoria(Categoria categoriaSelecionada) {
		this.categoria = categoriaSelecionada;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public String salvar() {
		try {
			categoriaRepository.save(categoria);
			return "listaCategorias"; 
		} catch (Exception e) {
			e.printStackTrace();
			return "paginaErro"; 
		}
	}

	public String criarNovo() {
		this.categoria = new Categoria();
		return "editaCategoria"; 
	}

	public String verDetalhe(Categoria categoria) {
		this.categoria = categoria;
		return "editaCategoria"; 
	}
}
