/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bossini._maua_poo_sistema_academico;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rodrigo
 */
public class ConnectionFactory {
    private static String host = "mysql-31fb8d5a-poo-imt.h.aivencloud.com";
    private static String porta = "13661";
    private static String db = "sistema_academico";
    private static String usuario = "avnadmin";
    private static String senha =  "AVNS_WI_jIoTwQCNqA8R3mUl";
    
    public static Connection obterConexao()
        throws Exception{
        String url = String.format("jdbc:mysql://%s:%s/%s", host, porta, db);
        return DriverManager.getConnection(url, usuario, senha);
    }
}
