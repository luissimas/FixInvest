package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Banco {

    public static Connection conexao;
    public PreparedStatement comando;
    public ResultSet tabela;

    public Banco() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");

            if ((conexao == null) || (conexao.isClosed())) {
                conexao = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/FixInvest", "postgres", "ifsp");
            }
        } catch (Exception ex) {
            throw new Exception("Erro de conexão com o banco: " + ex.getMessage());
        }
    }
}
