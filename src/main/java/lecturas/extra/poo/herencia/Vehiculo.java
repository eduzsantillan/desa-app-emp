package lecturas.extra.poo.herencia;

public class Vehiculo {
    protected String placa;
    protected String modelo;

    public Vehiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public void encender() {
        System.out.println("Encendiendo vehículo...");
    }
}
