package pe.isil.order;

import java.util.List;

public record Order(
     Integer id,
     String customerCode,
     List<OrderItem> items,
     OrderStatus status
) {
}
