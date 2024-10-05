package lecturas.semana6.abstraccion;

import lecturas.semana6.encapsulamiento.CuentaBancaria;

public class App {

    public static void main(String[] args) {
        ConexionBd conexion = new ConexionMysql();
        conexion.conectar();
        ((ConexionMysql) conexion).metodoPropio();
        Transacciones transaccion = (Transacciones)  conexion;
        transaccion.eliminar();

    }
}
