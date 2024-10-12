package lecturas.extra.poo.herencia;

public class Moto extends Vehiculo{
    private int cilindraje;

    public Moto(String placa, String modelo, int cilindraje) {
        super(placa, modelo);
        this.cilindraje = cilindraje;
    }

    public void encender() {
        super.encender();
        System.out.println("Encendiendo moto...");
    }
}
