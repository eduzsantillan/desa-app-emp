package lecturas.semana6.polimorfismo;

import lecturas.semana6.herencia.Auto;
import lecturas.semana6.herencia.Moto;

public class App {

    public static void main(String[] args) {
        Pago pagoConTarjeta = new PagoConTarjeta();
        Pago pagoEfectivo = new PagoEnEfectivo();

        pagoConTarjeta.realizarPago(100, "1234567890");
        pagoEfectivo.realizarPago(200, "0987654321");
    }
}
