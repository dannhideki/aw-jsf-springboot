package br.com.globalcode.jsf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ValueChangeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.globalcode.jsf.model.Categoria;
import br.com.globalcode.jsf.model.Produto;
import br.com.globalcode.jsf.model.ProdutoMaterial;
import br.com.globalcode.jsf.repositories.CategoriaRepository;
import br.com.globalcode.jsf.repositories.ProdutoRepository;



@Controller("ProdutoMB")
@Scope
public class ProdutoMB {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

    private Produto produto = new ProdutoMaterial();
    private List<Categoria> categoriasDisponiveis;
    private List<Produto> produtos;
    private String tipo = "material";
    private List<String> tipos;
    private boolean produtoMaterial = true;

    public ProdutoMB() {
        categoriasDisponiveis = new ArrayList<Categoria>();
        produto = new ProdutoMaterial();
        tipos = new ArrayList<String>();
        tipos.add("material");
        tipos.add("digital");
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public List<Categoria> getCategoriasDisponiveis() {
        if (categoriasDisponiveis.isEmpty()) {
        	categoriasDisponiveis = categoriaRepository.findAll();
        }
        return categoriasDisponiveis;
    }

    public void setCategoriasDisponiveis(List<Categoria> categoriasDisponiveis) {
        this.categoriasDisponiveis = categoriasDisponiveis;
    }

    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

    public boolean isProdutoMaterial() {
        return produtoMaterial;
    }

    public void setProdutoMaterial(boolean produtoMaterial) {
        this.produtoMaterial = produtoMaterial;
    }

    public String salvar() {
        System.out.println("Estou salvando o produto " + produto);
        try {
            produtoRepository.save(produto);
            return "listaProdutos";
        } catch (Exception e) {
            e.printStackTrace();
            return "paginaErro";
        }
    }

    public String criarNovo() {
        produto = new ProdutoMaterial();
        return "editaProduto";
    }

    public String verDetalhe(Produto produto) {
        this.produto = produto;
        return "editaProduto";
    }

    public void valorAlterado(ValueChangeEvent valueChangeEvent) {
        // verifique se o novo valor do componente que está sendo monitorado é igual a "material",
        // através da chamada do método getNewValue() no parâmetro recebido neste método.
        // se for "material", mude o atributo produtoMaterial para true e
        // mude o produto para ProdutoMaterial usando a seguinte sentença:
        // produto = new ProdutoMaterial(produto);
        // caso contrário, mude para false e
        // mude o produto para ProdutoDigital usando a seguinte sentença:
        // produto = new ProdutoDigital(produto);
        // por último, execute o método que renderiza a resposta...
    }

}
