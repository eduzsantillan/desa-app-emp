package lecturas.extra.poo.abstraccion;

public class ConexionOracle extends ConexionBd {
    @Override
    public void conectar() {
        System.out.println("Conectando a Oracle con usuario: " + user + " y password: " + password);
    }
}
