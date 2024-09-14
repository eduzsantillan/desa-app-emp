package lecturas;

import utilitarios.DBUtilitario;

import java.sql.*;

public class Semana1 {

    public static void main(String[] args) throws SQLException {

        String sqlQuery = "select * from curso";

        Connection conn = DBUtilitario.obtenerConexion();

        //3. Creamos el objeto Statement
        Statement statement = conn.createStatement();

        //4. Obtenemos el resultset a partir del objeto statement
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        //5. Iteramos sobre el ResultSet
        while (resultSet.next()){
            System.out.println("Resultado de la fila :\n"  + resultSet.getInt("id") + "\n" + resultSet.getString("descripcion")
                    + "\n" + resultSet.getString("categoria") + "\n" + resultSet.getInt("horas"));
        }
    }
}
