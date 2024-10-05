package lecturas.semana6.herencia;

public class Auto extends Vehiculo {
    private int numPuertas;

    public Auto(String placa, String modelo, int numPuertas) {
        super(placa, modelo);
        this.numPuertas = numPuertas;
    }

    public void encender() {
        super.encender();
        System.out.println("Encendiendo auto...");
    }
}
