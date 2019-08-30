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
 * @author aluno
 */
public class Estudante {

    private int codigo;
    private String nome;
    private String email;
    private String senha;
    private Date dataNasc;

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setCodigo(int codigoRecebido) {
        codigo = codigoRecebido;
    }

    public void setNome(String nomeRecebido) {
        nome = nomeRecebido;
    }

    public void setEmail(String emailRecebido) {
        email = emailRecebido;
    }

    public void setSenha(String senhaRecebida) {
        senha = senhaRecebida;
    }

    public void setDataNasc(String dataNascRecebida) throws ParseException {
        dataNasc = new SimpleDateFormat("dd-MM-yyyy").parse(dataNascRecebida);
    }
}
