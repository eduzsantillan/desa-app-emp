package lecturas.semana6.polimorfismo;

public abstract class Pago {
    public abstract void realizarPago(double monto);
    public abstract void realizarPago(double monto, String numeroTarjeta);
}
