package lecturas.semana2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static utilitarios.DBUtilitario.obtenerConexion;

public class Semana2Tarea {

    public static void main (String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Ingrese el usuario");
                String entradaUsuario = scanner.nextLine();
                if(!validarEntradaUsuario(entradaUsuario)){
                    break;
                }
                System.out.println("Ingrese el passsword");
                String entradaPassword = scanner.nextLine();
                if(!validarEntradaUsuario(entradaPassword)){
                    break;
                }

                try{
                    String out = ingresarAlSistema(entradaUsuario, entradaPassword);
                    System.out.println(String.format("Bienvenido %s !!! ",out));
                }catch (IngresoSistemaException ise){
                    System.out.println(ise.getMessage());
                    volverIntentar();
                }catch (Exception e){
                    System.out.println(e);
                }
            }

        }
    }

    private static void volverIntentar(){
        System.out.println("Volviendo a intentar...");
    }

    private static String ingresarAlSistema(String user, String pass) throws SQLException {
        String sql = "select * from usuario where UPPER(user) = ? " +
                "and UPPER(password) = ?";
        PreparedStatement ps = obtenerConexion().prepareStatement(sql);
        ps.setString(1, user.toUpperCase());
        ps.setString(2, pass.toUpperCase());

        ResultSet rs = ps.executeQuery();
        String resultado = null;
        while(rs.next()){
            resultado = rs.getString("nombres_completos");
        }
        if (resultado == null){
            throw new IngresoSistemaException("Usuario y/o clave incorrectos");
        }
        return  resultado;
    }

    private static boolean validarEntradaUsuario(String entrada){
        return !"salir".equalsIgnoreCase(entrada) && !"fin".equalsIgnoreCase(entrada);
    }
}
