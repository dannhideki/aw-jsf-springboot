package br.com.globalcode.jsf.model;

import java.io.Serializable;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import br.com.globalcode.jsf.comparator.ComparatorProdutoCategoriaNome;

@Entity
public class CatalogoProdutos implements Serializable{
    
	private static final long serialVersionUID = -4165669004727864280L;
	
	@Id
    @GeneratedValue
	private Integer id;  
    private String nome;
    private Date validade;
    
    @OneToMany
    @OrderBy
	private SortedSet<Produto> produtos = new TreeSet<Produto>(new ComparatorProdutoCategoriaNome());
    
    public CatalogoProdutos(){
    }
    
    public CatalogoProdutos(String nome, Date validade) {
      setNome(nome);
      setValidade(validade);
    }
    
    public CatalogoProdutos(Integer id, String nome, Date validade) {
      this(nome,validade);
      setId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }    
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Date getValidade(){
        return validade;
    }
    
    public void setValidade(Date validade){
        this.validade = validade;
    }
    
    public SortedSet getProdutos() {
        return produtos;
    }
    
    public void setProdutos(SortedSet produtos) {
        this.produtos = produtos;
    }
    
    public String toString() {
        return getNome();
    }
    
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        boolean result = false;
        if (o instanceof Categoria) {
            CatalogoProdutos outro = (CatalogoProdutos) o;
            result = this.getNome() != null && 
                     this.getNome().equals(outro.getNome());
        }
        return result;      
    }
    
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 41;
        return result;
    }    
}