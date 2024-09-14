package lecturas.semana3;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main (String []args) throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Ingrese el nombre de la persona");
                String nombre = scanner.nextLine();
                if(!validarEntradaSalida(nombre)){
                    return;
                }
                System.out.println("Validando en base de datos...");

                PersonaDao personaDao = new PersonaDao();
                try{
                    Persona persona = personaDao.obtenerPersonaPorNombre(nombre.trim());
                    boolean esMayorEdad = validarPersonaMayorEdad(persona.edad);
                    if(esMayorEdad){
                        System.out.println(String.format("La persona %s es mayor de edad", nombre));
                    }else{
                        System.out.println(String.format("La persona %s es menor de edad", nombre));
                    }
                }catch (PersonaNoEncontradaException e){
                    System.out.println("La persona con nombre: " + nombre +" no fue encontrada.");
                }
            }
        }
    }

    private static boolean validarPersonaMayorEdad(int edad){
        return edad >= 18;
    }

    private static boolean validarEntradaSalida(String param){
        if ("exit".equalsIgnoreCase(param) || "bye".equalsIgnoreCase(param)) {
            return false;
        }else{
            return true;
        }
    }
}
