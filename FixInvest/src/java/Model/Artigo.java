/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Padawan
 */
public class Artigo {
    
    private int codigo;
    private String categoria;
    private String titulo;
    private String texto;
    private Date data;
    private int codEscritor;

    public int getCodigo() {
        return codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public Date getData() {
        return data;
    }

    public int getCodEscritor() {
        return codEscritor;
    }
    
    public void setCodigo(int codigoRecebido) {
        codigo = codigoRecebido;
    }
    
    public void setCategoria(String categoriaRecebida) {
        categoria = categoriaRecebida;
    }
    
    public void setTitulo(String tituloRecebido) {
        titulo = tituloRecebido;
    }
    
    public void setTexto(String textoRecebido) {
        texto = textoRecebido;
    }
    
    public void setData(String dataRecebida) throws ParseException {
        data = new SimpleDateFormat("dd-MM-yyyy").parse(dataRecebida);
    }

    public void setCodEscritor(int codEscritorRecebido) {
        codEscritor = codEscritorRecebido;
    }
}
