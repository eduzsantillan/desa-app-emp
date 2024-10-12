package lecturas.extra.poo.abstraccion;

public class App {

    public static void main(String[] args) {
        ConexionBd conexion = new ConexionMysql();
        conexion.conectar();
        ((ConexionMysql) conexion).metodoPropio();
        Transacciones transaccion = (Transacciones)  conexion;
        transaccion.eliminar();

    }
}
