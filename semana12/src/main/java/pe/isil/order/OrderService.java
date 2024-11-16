package pe.isil.order;

import java.util.List;

public class OrderService {

    public Order createOrder(String customerCode, List<OrderItem> items) {
        if(customerCode == null || customerCode.isBlank()){
            throw new IllegalArgumentException("El codigo del cliente no puede ser nulo o vacio");
        }
        if(items == null || items.isEmpty()){
            throw new IllegalArgumentException("La lista de items no puede ser nula o vacia");
        }
        int totalItems = 0;
        for(OrderItem item : items){
            if(item.quantity() <= 0){
                throw new IllegalArgumentException("La cantidad de items debe ser mayor a 0");
            }
            totalItems += item.quantity();
        }
//        Integer totalItems = items.stream()
//                .mapToInt(OrderItem::quantity)
//                .sum();
        boolean isStockAvailable = StockService.isStockAvailable(totalItems);
        if(!isStockAvailable){
            throw new IllegalArgumentException("No hay stock suficiente para los items solicitados");
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
