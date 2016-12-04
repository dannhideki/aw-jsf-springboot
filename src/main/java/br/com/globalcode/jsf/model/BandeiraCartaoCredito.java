package br.com.globalcode.jsf.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BandeiraCartaoCredito implements Serializable{

	private static final long serialVersionUID = -7187120941118821652L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;

	public BandeiraCartaoCredito(){
	}

	public BandeiraCartaoCredito(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

    public String toString() {
        return getNome() + " - " + getId();
    }

    public boolean equals(Object o) {
      	if (o == null) return false;
      	if (this == o) return true;
      	boolean result = false;
        if (o instanceof BandeiraCartaoCredito) {
            BandeiraCartaoCredito outro = (BandeiraCartaoCredito) o;
            result = this.getNome() != null && 
                     this.nome.equals(outro.nome);
        }
        return result;
    }

    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 41;
        return result;
    }

}