package controller;

import model.Banco;
import model.Estudante;

public class EstudanteCRUD {

    public int gravar(Estudante estudante) throws Exception {
        Banco banco = new Banco();
        int linhasAfetadas = 0;

        try {
            banco.comando = Banco.conexao.prepareStatement("insert into estudante(nome,login,senha,datanasc,email) values(?,?,?,?,?)");
            
            banco.comando.setString(1, estudante.getNome());
            banco.comando.setString(2, estudante.getLogin());
            banco.comando.setString(3, estudante.getSenha());
            banco.comando.setDate(3, estudante.getDataNasc());
            banco.comando.setString(3, estudante.getEmail());
            
            linhasAfetadas = banco.comando.executeUpdate();
            
            Banco.conexao.close();
            
            return (linhasAfetadas);
        } catch (Exception ex) {
            throw new Exception("Erro ao gravar estudante:" + ex.getMessage());
        }
    }
}
