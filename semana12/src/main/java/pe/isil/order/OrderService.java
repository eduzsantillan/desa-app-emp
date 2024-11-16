package pe.isil.order;

import pe.isil.order.exceptions.InvalidInputData;
import pe.isil.order.exceptions.InvalidQuantyException;
import pe.isil.order.exceptions.StockNotAvailableException;

import java.util.List;

public class OrderService {

    private final StockClient stockClient;

    public OrderService(StockClient stockClient){
        this.stockClient = stockClient;
    }

    public Order createOrder(String customerCode, List<OrderItem> items) {
        if(customerCode == null || customerCode.isBlank()){
            throw new InvalidInputData("El codigo del cliente no puede ser nulo o vacio");
        }
        if(items == null || items.isEmpty()){
            throw new InvalidInputData("La lista de items no puede ser nula o vacia");
        }
        int totalItems = 0;
        for(OrderItem item : items){
            if(item.quantity() <= 0){
                throw new InvalidQuantyException("La cantidad de items debe ser mayor a 0");
            }
            totalItems += item.quantity();
        }
//        Integer totalItems = items.stream()
//                .mapToInt(OrderItem::quantity)
//                .sum();
//        boolean isStockAvailable = StockService.isStockAvailable(totalItems);
        boolean isStockAvailable = stockClient.isStockAvailable();
        if(!isStockAvailable){
            throw new StockNotAvailableException("No hay stock suficiente para los items solicitados");
        }

        return new Order(generateId(), customerCode, items, OrderStatus.PENDIENTE);
    }

    private int generateId(){
        return (int) (Math.random() * 1000);
    }


    public Double getOrderTotal(Order order){
//        return order.items().stream()
//                .mapToDouble(item -> item.quantity() * item.unitPrice())
//                .sum();
        double total = 0;
        for(OrderItem item : order.items()){
            total += item.quantity() * item.unitPrice();
        }
        return total;
    }
}
