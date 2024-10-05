package lecturas.semana6.herencia;

import lecturas.semana6.encapsulamiento.CuentaBancaria;

public class App {

    public static void main(String[] args) {
        Auto auto = new Auto("ABC123", "Toyota", 4);
        Moto moto = new Moto("XYZ456", "Yamaha", 150);
        auto.encender();
        moto.encender();
    }

}
