package br.com.globalcode.jsf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.globalcode.jsf.model.Categoria;
import br.com.globalcode.jsf.model.ProdutoMaterial;
import br.com.globalcode.jsf.repositories.CategoriaRepository;

@Controller("ProdutoMB")
@Scope("request")
public class ProdutoMB {

	@Autowired
	private CategoriaRepository categoriaRepository;

	private ProdutoMaterial produto = new ProdutoMaterial();
	private List<Categoria> categoriasDisponiveis;
	private Integer categoriaSelecionada;

	public ProdutoMB() {
		categoriasDisponiveis = new ArrayList<Categoria>();
		produto = new ProdutoMaterial();
	}

	public void setProduto(ProdutoMaterial produto) {
		this.produto = produto;
	}

	public ProdutoMaterial getProduto() {
		return produto;
	}

	public List<Categoria> getCategoriasDisponiveis() {
		if (categoriasDisponiveis.isEmpty()) {

			List<Categoria> categoriasList = categoriaRepository.findAll();
			for (Categoria cat : categoriasList) {
				categoriasDisponiveis.add(cat);
			}

		}
		return categoriasDisponiveis;
	}

	public void setCategoriasDisponiveis(List<Categoria> categoriasDisponiveis) {
		this.categoriasDisponiveis = categoriasDisponiveis;
	}

	public Integer getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public void setCategoriaSelecionada(Integer categoriaSelecionada) {
		System.out.println("[ProdutoMB] Categoria Selecionada = " + categoriaSelecionada);
		this.categoriaSelecionada = categoriaSelecionada;
		Categoria c = categoriaRepository.findOne(categoriaSelecionada);
		System.out.println("categoria = " + c);
		produto.setCategoria(c);
	}

	public String salvar() {
		System.out.println("[ProdutoMB - salvar] " + produto.getNome() +
				" categoria do produto = " + produto.getCategoria());
		return null;
	}

}
