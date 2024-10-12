package lecturas.extra.poo.abstraccion;

public abstract class ConexionBd {
    protected String user = "root";
    protected String password = "1234";

    public abstract void conectar();
}
