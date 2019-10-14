/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Padawan
 */
public class Investimento {

    private int codigo;
    private String descr;
    private Double rentabilidade;

    public int getCodigo() {
        return codigo;
    }
    
    public String getDescr() {
        return descr;
    }
    
    public Double getRentabilidade() {
        return rentabilidade;
    }

    public void setCodigo(int codigoRecebido) {
        codigo = codigoRecebido;
    }
    
    public void setCodigo(String codigoRecebido) {
        codigo = Integer.parseInt(codigoRecebido);
    }

    public void setDescr(String descrRecebida) {
        descr = descrRecebida;
    }
    
    public void setRendimento(Double rendimentoRecebido) {
        rentabilidade = rendimentoRecebido;
    }
    
    public void setRendimento(String rendimentoRecebido) {
        rentabilidade = Double.parseDouble(rendimentoRecebido);
    }
}
