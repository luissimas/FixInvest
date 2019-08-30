package controller;

import model.Banco;
import model.Estudante;

public class EscritorCRUD {

    public int gravar(Escritor escritor) throws Exception {
        Banco banco = new Banco();
        int linhasAfetadas = 0;

        try {
            banco.comando = Banco.conexao.prepareStatement("insert into escritor(nome,login,senha,datanasc,email) values(?,?,?,?,?)");
            
            banco.comando.setString(1, escritor.getNome());
            banco.comando.setString(2, escritor.getLogin());
            banco.comando.setString(3, escritor.getSenha());
            banco.comando.setDate(3, escritor.getDataNasc());
            banco.comando.setString(3, escritor.getEmail());
            
            linhasAfetadas = banco.comando.executeUpdate();
            
            Banco.conexao.close();
            
            return (linhasAfetadas);
        } catch (Exception ex) {
            throw new Exception("Erro ao gravar escritor:" + ex.getMessage());
        }
    }
}
