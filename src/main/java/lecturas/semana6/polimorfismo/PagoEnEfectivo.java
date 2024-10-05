package lecturas.semana6.polimorfismo;

public class PagoEnEfectivo extends Pago {
   @Override
    public void realizarPago(double monto) {
        System.out.println("Pago en efectivo por: " + monto);
    }

    @Override
    public void realizarPago(double monto, String numeroTarjeta) {
        this.realizarPago(monto);
        System.out.println(" con tarjeta: " + numeroTarjeta);
    }
}
