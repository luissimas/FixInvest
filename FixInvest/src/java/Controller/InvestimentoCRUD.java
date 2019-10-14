/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Banco;
import Model.Investimento;
import java.sql.ResultSet;

/**
 *
 * @author Padawan
 */
public class InvestimentoCRUD {

    public ResultSet listar() throws Exception {
        Banco banco = new Banco();

        try {
            banco.comando = Banco.conexao.prepareStatement("select codigo, descr, rendimento from investimento");

            banco.tabela = banco.comando.executeQuery();

            Banco.conexao.close();

            return (banco.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro ao listar artigos: " + ex.getMessage());
        }
    }

    public ResultSet listarCodigo(Integer codigo) throws Exception {
        Banco banco = new Banco();

        try {
            banco.comando = Banco.conexao.prepareStatement("select codigo, descr, rendimento from investimento where codigo = ?");
            banco.comando.setInt(1, codigo);

            banco.tabela = banco.comando.executeQuery();

            Banco.conexao.close();

            return (banco.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro ao listar artigos: " + ex.getMessage());
        }
    }

}
