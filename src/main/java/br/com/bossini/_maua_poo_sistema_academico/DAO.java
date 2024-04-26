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
public class DAO { //Objeto de Acesso a Dados
    //cláusula catch or declare
    public boolean existe(Usuario u) throws Exception{
        //jdbc: Java Database Connectivity
        
        //1. Especificar o comando SQL
        String sql = "SELECT * FROM tb_usuario WHERE login = ? AND senha = ?";
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
}
