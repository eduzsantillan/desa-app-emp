package lecturas.semana6.encapsulamiento;

public class CuentaBancaria {

    private double saldo;
    private String numeroCuenta = "123456";

    public double obtenerSaldo() {
        return saldo;
    }

    public String obtenerNumeroCuenta() {
        return numeroCuenta;
    }

    public void retirar(double monto) {
        if(monto > 0){
            if(saldo >= monto){
                saldo -= monto;
            }else {
                throw new IllegalArgumentException("Saldo insuficiente");
            }
        }else {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero");
        }
    }

    public void depositar(double monto) {
        if(monto > 0){
            saldo += monto;
        }else {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero");
        }
    }



}
