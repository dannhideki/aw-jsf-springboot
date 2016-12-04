package br.com.globalcode.jsf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable{
    
	private static final long serialVersionUID = 5168151894676236033L;
	
	@Id
    @GeneratedValue
	protected Integer id;
    protected Date dataPagamento;
    protected double valor;
    
    public Pagamento(){
    }
    
    public Pagamento(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.dataPagamento = pagamento.getDataPagamento();
        this.valor = pagamento.getValor();
    }

    public Pagamento(Date dataPagamento, double valor) {
        this.dataPagamento = dataPagamento;
        this.valor = valor;
    }
    
    public Pagamento(Integer id, Date dataPagamento, double valor) {
        this(dataPagamento, valor);
        this.id = id;
    }
    
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public Date getDataPagamento(){
        return dataPagamento;
    }
    
    public void setDataPagamento(Date dataPagamento){
        this.dataPagamento = dataPagamento;
    }
    
    public double getValor(){
        return valor;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    
    public String toString() {
        return "id = " + id + " data " + dataPagamento + " " + valor;
    }
    
}