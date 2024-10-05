package lecturas.semana4;

import utilitarios.DBUtilitario;

import java.sql.*;
import java.util.Scanner;

public class StoredProceduresJava {

    public static void main(String []args) throws SQLException {
        String username = "";
        String password  = "";

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Ingrese el usuario");
                username = scanner.nextLine();
                System.out.println("Ingrese el password");
                password = scanner.nextLine();
                Connection connection = DBUtilitario.obtenerConexion();
                CallableStatement callableStatement = connection.prepareCall("{CALL sp_login(?,?,?)}");
                callableStatement.setString(1, username);
                callableStatement.setString(2, password);
                callableStatement.registerOutParameter(3, Types.BOOLEAN);
                callableStatement.execute();
                boolean output = callableStatement.getBoolean(3);
                if (output) {
                    System.out.println(String.format("Bienvenido al sistema %s", username));
                    return;
                } else {
                    System.out.println("Usuario y clave incorrecto");
                    throw new RuntimeException("Errorrrr");
                }
            }
        }
    }
}
