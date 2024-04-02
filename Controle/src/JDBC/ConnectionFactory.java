package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
    public Connection getConnection(){

        try {            
       
        String nomeUsuario = "root";
        String senhaUsuario = "1234";
        String enderecoServidor = "localhost";
        String nomeDoBanco = "DataBase";
        return DriverManager.getConnection("jdbc:mysql://"+enderecoServidor+"/"+nomeDoBanco, nomeUsuario,senhaUsuario);

    } catch (SQLException e) {
        System.out.println("Falha de conexão");
        throw new RuntimeException(e); 
        
    }

        

    }
}
