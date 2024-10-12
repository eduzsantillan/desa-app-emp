package lecturas.extra.poo.encapsulamiento;

public class App {

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();
        cuenta.depositar(100);

        System.out.println("Saldo: " + cuenta.obtenerSaldo());
        System.out.println("Numero de cuenta: " + cuenta.obtenerNumeroCuenta());

    }
}
