package utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilitario {

    private static final String url = "jdbc:mysql://localhost:3306/escuela";
    private static final String user = "root";
    private static final String pass = "develop2024";
    private static Connection connection;

    public static Connection obtenerConexion() throws SQLException {
        if(connection == null ){
            return DriverManager.getConnection(url,user,pass);
        }else{
            return connection;
        }
    }

}
