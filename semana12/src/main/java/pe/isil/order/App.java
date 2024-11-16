package pe.isil.order;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        System.out.println("Bienvenido a la tienda");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Ingrese el codigo del cliente (Ejemplo: C001)");

                String customerCode = scanner.nextLine();

                var orderItems = List.of(
                        new OrderItem(1, "PRD001", 15, 10.0),
                        new OrderItem(2, "PRD002", 23, 20.0)
                );

                try {
                    Order order = orderService.createOrder(customerCode, orderItems);
                    System.out.println("Se registro la orden correctamente");
                    System.out.println("El total de la orden es: " + orderService.getOrderTotal(order));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Presione cualquier tecla para salir");
                scanner.nextLine();
                break;

            }
        }
    }
}
