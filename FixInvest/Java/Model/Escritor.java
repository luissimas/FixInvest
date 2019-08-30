package model;

public class Escritor {
    private int codigo;
    private String nome;
    private String login;
    private String senha;
    private Date dataNasc;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigoRecebido) {
        codigo = codigoRecebido;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nomeRecebido) {
        nome = nomeRecebido;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String loginRecebido) {
        login = loginRecebido;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String emailRecebido) {
        nome = emailRecebido;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senhaRecebida) {
        senha = senhaRecebida;
    }

    public String getDataNasc() {
        return dataNasc;
    }
    
    public void setSenha(Date dataNascRecebida) {
        dataNasc = dataNascRecebida;
    }
}