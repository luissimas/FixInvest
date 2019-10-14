/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */

/*
create table Escritor(
	codigo serial primary key,
	nome varchar(50), 
	senha varchar(30) not null,
	email varchar(40), 
	datanasc date not null,
	constraint ce02 unique(email));
                                                      
create table Estudante(
	codigo serial primary key,
	nome varchar(50), 
	senha varchar(30) not null,
	email varchar(40), 
	datanasc date not null,
	escola varchar(40),
	perfil varchar(40),
	constraint ca02 unique(email));
		
create table Artigo(
	codigo serial primary key,
	codEscritor varchar(30)not null,
	data TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
	categoria varchar(20)not null,
	titulo varchar(50)not null,
	texto text not null);
	
create table Investimento(
	codigo serial primary key,
	descr varchar(50),
	rendimento real);

select * from Escritor;
select * from Estudante;
select * from Artigo;
select * from Investimento;
 */

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
