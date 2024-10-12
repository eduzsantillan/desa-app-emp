package lecturas.extra.poo.polimorfismo;

public class PagoConTarjeta extends Pago{
    @Override
    public void realizarPago(double monto) {
        System.out.println("Pago con tarjeta por: " + monto);
    }

    @Override
    public void realizarPago(double monto, String numeroTarjeta) {
        this.realizarPago(monto);
        System.out.println(" con tarjeta: " + numeroTarjeta);
    }
}
