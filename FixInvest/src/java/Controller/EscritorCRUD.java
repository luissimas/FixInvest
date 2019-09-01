/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Banco;
import Model.Escritor;
import java.sql.Date;
import java.sql.ResultSet;

public class EscritorCRUD {

    public int gravar(Escritor escritor) throws Exception {
        Banco banco = new Banco();
        int linhasAfetadas = 0;

        try {
            banco.comando = Banco.conexao.prepareStatement("insert into escritor(nome,email,senha,dataNasc) values(?,?,?,?)");

            banco.comando.setString(1, escritor.getNome());
            banco.comando.setString(2, escritor.getEmail());
            banco.comando.setString(3, escritor.getSenha());
            banco.comando.setDate(4, new java.sql.Date(escritor.getDataNasc().getTime()));

            linhasAfetadas = banco.comando.executeUpdate();

            Banco.conexao.close();

            return (linhasAfetadas);
        } catch (Exception ex) {
            throw new Exception("Erro ao gravar escritor:" + ex.getMessage());
        }
    }
    
    public Escritor login(String email, String senha) throws Exception {
        Banco banco = new Banco();
        Escritor escritor = null;

        try {
            banco.comando = Banco.conexao.prepareStatement("select codigo,nome,email,senha,datanasc from escritor where email=? and senha=?");
            
            banco.comando.setString(1, email);
            banco.comando.setString(2, senha);
            banco.tabela = banco.comando.executeQuery();
            
            if (banco.tabela.next()) {
                escritor = new Escritor();
                escritor.setCodigo(banco.tabela.getInt(1));
                escritor.setNome(banco.tabela.getString(2));
                escritor.setEmail(banco.tabela.getString(3));
                escritor.setSenha(banco.tabela.getString(4));
            }
            
            Banco.conexao.close();
            
            return (escritor);
        } catch (Exception ex) {
            throw new Exception("Erro ao efetuar o login:" + ex.getMessage());
        }
    }
    
    public ResultSet listarCodigo(int codigo) throws Exception {
        Banco banco = new Banco();

        try {
            banco.comando = Banco.conexao.prepareStatement("select codigo, nome, email, datanasc from Escritor where codigo = ?");
                banco.comando.setInt(1, codigo);
            
            banco.tabela = banco.comando.executeQuery();

            Banco.conexao.close();

            return (banco.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro ao listar artigos: " + ex.getMessage());
        }
    }
}
