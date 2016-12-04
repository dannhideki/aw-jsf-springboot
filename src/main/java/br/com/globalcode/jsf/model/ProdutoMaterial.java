package br.com.globalcode.jsf.model;

import javax.persistence.Entity;

@Entity
public class ProdutoMaterial extends Produto {

	private static final long serialVersionUID = -3339716713487178208L;
	
	private double taxaEntrega;

    public ProdutoMaterial() {
    }

    public ProdutoMaterial(Produto produto) {
        super(produto);
        if (produto instanceof ProdutoMaterial) {
            setTaxaEntrega(((ProdutoMaterial)produto).getTaxaEntrega());
        }
    }

    public ProdutoMaterial(Categoria categoria, String marca, String nome,
                           double preco, boolean ativo, double taxaEntrega) {
        super(categoria, marca, nome, preco, ativo);
        this.taxaEntrega = taxaEntrega;
    }

    public ProdutoMaterial(Integer id, Categoria categoria, String marca,
                           String nome, double preco, boolean ativo,
                           double taxaEntrega) {
        this(categoria, marca, nome, preco, ativo, taxaEntrega);
        this.id = id;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

}
