package lecturas.extra.poo.abstraccion;

public class ConexionMysql extends ConexionBd implements Transacciones {
    @Override
    public void conectar() {
        System.out.println("Conectando a MySQL con usuario: " + user + " y password: " + password);
    }

    @Override
    public void insertar() {
        System.out.println("Insertando en MySQL");
    }

    @Override
    public void actualizar() {
        System.out.println("Actualizando en MySQL");
    }

    @Override
    public void eliminar() {
        System.out.println("Eliminando en MySQL");
    }


    public void metodoPropio() {
        System.out.println("Método propio de la clase ConexionMysql");
    }
}
