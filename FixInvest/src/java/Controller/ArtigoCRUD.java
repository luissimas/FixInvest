/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Artigo;
import Model.Banco;
import java.sql.ResultSet;

/**
 *
 * @author Padawan
 */
public class ArtigoCRUD {

    public int gravar(Artigo artigo) throws Exception {
        Banco banco = new Banco();
        int linhasAfetadas = 0;

        try {
            banco.comando = Banco.conexao.prepareStatement("insert into artigo(categoria, titulo, texto, codEscritor) values(?, ?, ?, ?)");

            banco.comando.setString(1, artigo.getCategoria());
            banco.comando.setString(2, artigo.getTitulo());
            banco.comando.setString(3, artigo.getTexto());
            banco.comando.setInt(4, artigo.getCodEscritor());

            linhasAfetadas = banco.comando.executeUpdate();

            Banco.conexao.close();

            return (linhasAfetadas);
        } catch (Exception ex) {
            throw new Exception("Erro ao gravar artigo:" + ex.getMessage());
        }
    }

    public ResultSet listar(String categoria) throws Exception {
        Banco banco = new Banco();

        try {
            if(categoria.trim().length()>1){
                banco.comando = Banco.conexao.prepareStatement("select codigo, categoria, titulo, texto, data, codEscritor from Artigo where categoria ilike ?");
                banco.comando.setString(1, categoria);
            }else{
                banco.comando = Banco.conexao.prepareStatement("select codigo, categoria, titulo, texto, data, codEscritor from Artigo");
            }
            
            banco.tabela = banco.comando.executeQuery();

            Banco.conexao.close();

            return (banco.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro ao listar artigos: " + ex.getMessage());
        }
    }
    
    public ResultSet listarCodigo(int codigo) throws Exception {
        Banco banco = new Banco();

        try {
            banco.comando = Banco.conexao.prepareStatement("select codigo, categoria, titulo, texto, data, codEscritor from Artigo where codigo = ?");
                banco.comando.setInt(1, codigo);
            
            banco.tabela = banco.comando.executeQuery();

            Banco.conexao.close();

            return (banco.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro ao listar artigos: " + ex.getMessage());
        }
    }

}
