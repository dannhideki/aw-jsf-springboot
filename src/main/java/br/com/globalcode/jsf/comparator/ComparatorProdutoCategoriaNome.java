package br.com.globalcode.jsf.comparator;

import java.util.Comparator;

import br.com.globalcode.jsf.model.Categoria;
import br.com.globalcode.jsf.model.Produto;


public class ComparatorProdutoCategoriaNome implements Comparator<Produto> {

  public int compare(Produto p1, Produto p2) {

    int compId = compareCategoria(p1.getCategoria(), p2.getCategoria());
    if (compId != 0) {
      return compId;
    } else {
      return compareNome(p1, p2);
    }
  }

  private int compareCategoria(Categoria cat1, Categoria cat2) {

    Integer idCat1 = cat1 != null ? cat1.getId() : null;
    Integer idCat2 = cat2 != null ? cat2.getId() : null;

    if (idCat1 == null || idCat2 == null) {
      return 0;
    } else if (idCat1 == null) {
      return -1;
    } else if (idCat2 == null) {
      return +1;
    } else {
      return idCat1.compareTo(idCat2);
    }

  }

  private int compareNome(Produto p1, Produto p2) {

    if (p1.getNome() == null && p2.getNome() == null) {
      return 0;
    } else if (p1.getNome() == null) {
      return -1;
    } else if (p2.getNome() == null) {
      return +1;
    } else {
      return p1.getNome().compareTo(p2.getNome());
    }

  }

}
