/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giex.conexao;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author jjunior
 */
public class ConectaBanco {

    public Connection conecta() {

        
        Connection conn = null;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:/OracleDS");
            conn = ds.getConnection();
           
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao tentar se conectar ao banco");
        }
        return conn;
    }
}