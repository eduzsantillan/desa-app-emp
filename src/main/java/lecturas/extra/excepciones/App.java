package lecturas.extra.excepciones;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main (String [] args){
//        try (Scanner scanner = new Scanner(System.in)) {
//            try{
//                System.out.println("Ingrese un numero");
//                int numero = Integer.parseInt(scanner.next());
//                System.out.println("Numero :" + numero);
//            }catch (NumberFormatException nfe){
//                System.out.println("Ingresa un numero pues hermano! ");
//            }
//        }

        File file = new File("example.txt");
        try{
            throw new IOException("Test");
//            file.createNewFile();

        }catch (IOException ioe){
            System.out.println("Excepcion controlada");
        }

    }
}
