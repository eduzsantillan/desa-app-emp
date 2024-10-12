package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConexion extends ConexionBd{

    private static final String url = "jdbc:mysql://localhost:3306/escuela";
    private static final String user = "root";
    private static final String pass = "develop2024";
    private static Connection connection;

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        if(connection == null ){
            return DriverManager.getConnection(url,user,pass);
        }else{
            return connection;
        }
    }
}
