/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Banco;
import Model.Estudante;
import java.sql.Date;

public class EstudanteCRUD {

    public int gravar(Estudante estudante) throws Exception {
        Banco banco = new Banco();
        int linhasAfetadas = 0;

        try {
            banco.comando = Banco.conexao.prepareStatement("insert into estudante(nome,senha,email,datanasc) values(?,?,?,?)");

            banco.comando.setString(1, estudante.getNome());
            banco.comando.setString(2, estudante.getSenha());
            banco.comando.setString(3, estudante.getEmail());
            banco.comando.setDate(4, new java.sql.Date(estudante.getDataNasc().getTime()));

            linhasAfetadas = banco.comando.executeUpdate();

            Banco.conexao.close();

            return (linhasAfetadas);
        } catch (Exception ex) {
            throw new Exception("Erro ao gravar estudante:" + ex.getMessage());
        }
    }
    
    public Estudante login(String email, String senha) throws Exception {
        Banco banco = new Banco();
        Estudante estudante = null;

        try {
            banco.comando = Banco.conexao.prepareStatement("select codigo,nome,email,senha,datanasc from estudante where email=? and senha=?");
            
            banco.comando.setString(1, email);
            banco.comando.setString(2, senha);
            banco.tabela = banco.comando.executeQuery();
            
            if (banco.tabela.next()) {
                estudante = new Estudante();
                estudante.setCodigo(banco.tabela.getInt(1));
                estudante.setNome(banco.tabela.getString(2));
                estudante.setEmail(banco.tabela.getString(3));
                estudante.setSenha(banco.tabela.getString(4));
            }
            
            Banco.conexao.close();
            
            return (estudante);
        } catch (Exception ex) {
            throw new Exception("Erro ao efetuar o login:" + ex.getMessage());
        }
    }
}
