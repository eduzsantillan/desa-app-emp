package pe.isil.order;

public class StockService {
    static int stock = 10;
    public static void updateStock(int quantity){
        stock -= quantity;
    }
    public static boolean isStockAvailable(int quantity){
        return stock >= quantity;
    }
}
