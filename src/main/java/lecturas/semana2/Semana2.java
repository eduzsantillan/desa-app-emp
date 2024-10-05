package lecturas.semana2;

import java.sql.*;
import java.util.Scanner;

import static utilitarios.DBUtilitario.obtenerConexion;

public class Semana2 {

    public static void main(String[] args) throws SQLException {
        Connection conn = obtenerConexion();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Ingrese los datos a registrar");
//                String idPorEliminar = scanner.nextLine();

                String desc = scanner.nextLine();
                if(!validarEntradaSalida(desc)){
                    break;
                }
                String categoria = scanner.nextLine();
                if(!validarEntradaSalida(categoria)){
                    break;
                }
                String horas = scanner.nextLine();
                if(!validarEntradaSalida(horas)){
                    break;
                }
                try {
//                    int filasEliminadas = eliminarCursoPorId(Integer.parseInt(idPorEliminar));
//                    System.out.println(String.format("Se elimino el curso de id %s correctamente, se eliminaron %s filas", idPorEliminar, filasEliminadas));
                    int filasCreadas = crearCurso(desc,categoria,Integer.parseInt(horas));
                    System.out.println("Se registro el curso correctamente");
                }catch (NumberFormatException numberFormatException){
                    System.out.println("El texto ingresado no es un entero");
                }catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private static boolean validarEntradaSalida(String param){
        if ("exit".equalsIgnoreCase(param) || "bye".equalsIgnoreCase(param)) {
            return false;
        }else{
            return true;
        }
    }

    private static int crearCurso(String desc, String categoria, int horas) throws SQLException {
        String sql = "INSERT INTO curso (descripcion,categoria,horas) VALUES (?,?,?)";
        PreparedStatement pstmt = obtenerConexion().prepareStatement(sql);
        pstmt.setString(1, desc);
        pstmt.setString(2, categoria);
        pstmt.setInt(3, horas);

        int filasAfectadas = pstmt.executeUpdate();

        if(filasAfectadas<1){
            throw new RuntimeException("El registro no pudo ser insertado");
        }else{
            return filasAfectadas;
        }
    }

    private static int eliminarCursoPorId(int id) throws SQLException {
        String query = "delete from curso where id = ?";
        PreparedStatement prepareStatement = obtenerConexion().prepareStatement(query);
        prepareStatement.setInt(1, id);
        int filasAfectadas = prepareStatement.executeUpdate();
        if(filasAfectadas<1){
            throw new RuntimeException("No se pudo eliminar el curso ya que no existe registro para id :" + id);
        }else{
            return filasAfectadas;
        }
    }

    private static String obtenerNombreCursoPstmt(int id) throws SQLException {
        String query = "select * from curso where id = ?";
        PreparedStatement prepareStatement = obtenerConexion().prepareStatement(query);
        prepareStatement.setInt(1, id);
        String resultado= "";
        ResultSet rs = prepareStatement.executeQuery();
        while(rs.next()){
            resultado = rs.getString("descripcion");
        }
        return resultado;
    }

    private static String obtenerNombreCursoStmt(int id) throws SQLException {
        String query = "select * from curso where id = " + id;
        ResultSet rs = obtenerConexion().createStatement().executeQuery(query);
        String resultado = "";
        while(rs.next()){
            resultado = rs.getString("descripcion");
        }
        return resultado;
    }
}
