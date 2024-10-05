package lecturas.semana6.abstraccion;

public class ConexionOracle extends ConexionBd {
    @Override
    public void conectar() {
        System.out.println("Conectando a Oracle con usuario: " + user + " y password: " + password);
    }
}
