package pe.isil.order;

public record OrderItem(
        Integer id,
        String productCode,
        Integer quantity,
        Double unitPrice
) {
}
