package lecturas.extra.poo.polimorfismo;

public class App {

    public static void main(String[] args) {
        Pago pagoConTarjeta = new PagoConTarjeta();
        Pago pagoEfectivo = new PagoEnEfectivo();

        pagoConTarjeta.realizarPago(100, "1234567890");
        pagoEfectivo.realizarPago(200, "0987654321");
    }
}
