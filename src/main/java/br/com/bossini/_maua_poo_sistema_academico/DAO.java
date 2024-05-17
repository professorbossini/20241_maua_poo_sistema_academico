/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bossini._maua_poo_sistema_academico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ferraz
 */
import java.util.*;
public class DAO { //Objeto de Acesso a Dados
    //cláusula catch or declare
    public boolean existe(Usuario u) throws Exception{
        //jdbc: Java Database Connectivity
        
        //1. Especificar o comando SQL
        String sql = "SELECT * FROM tb_usuario WHERE nome = ? AND senha = ?";
        //2. Estabelecer uma conexão com o banco de dados
        Connection conexao = ConnectionFactory.obterConexao();
        //3. Preparar o comando
        PreparedStatement ps = conexao.prepareStatement(sql);
        //4. Substituir os eventuais placeholders
        ps.setString(1, u.getNome());
        ps.setString(2, u.getSenha());
        //5. Executar o comando
        ResultSet rs = ps.executeQuery();
        //6. Lidar com o resultado
        boolean achou = rs.next();
        //7. Fechar a conexão
        rs.close();
        ps.close();
        conexao.close();
        //8. Responder se o usuário existe ou não
        return achou;
    }
    
    //cláusula catch or declare (compilador impõe)
    public List<Curso> obterCursos() throws Exception{
        //1. Especificar o comando SQL
        var sql = "SELECT * FROM tb_curso";
        //2. Estabelecer uma conexão com o banco de dados
        //try-with-resources (Java 7+)
        //3. Preparar o comando
        //4. Substituir os eventuais placeholders
        //5. Executar o comando
        try(
            Connection conexao = ConnectionFactory.obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){            
            //6. Lidar com o resultado
            while(rs.next()){
                var nome = rs.getString("nome");
                System.out.println(nome);
            }
            //8. Fechar a conexão
            //já foi feito pelo try-with-resources
        }
        return null;
    }
    //apenas teste
    public static void main(String[] args) throws Exception{
        new DAO().obterCursos();
    }
}
