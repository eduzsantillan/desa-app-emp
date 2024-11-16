package pe.isil.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Or;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.isil.order.exceptions.InvalidInputData;
import pe.isil.order.exceptions.InvalidQuantyException;
import pe.isil.order.exceptions.StockNotAvailableException;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private StockClient stockClient;
    @InjectMocks
    private OrderService target;
    private List<OrderItem> items;
    private String customerCode;
    //    AAA - > Arange , Act, Assert

    @BeforeEach
    void setup(){
        items = List.of(
                new OrderItem(1, "P001", 2, 10.0),
                new OrderItem(2, "P002", 3, 20.0)
        );
        customerCode = "C001";
    }


    @Test
    void createOrder_whenCustomerCodeIsNull_thenThrowIllegalArgumentException(){
        customerCode =null;
        assertThrows(InvalidInputData.class, () -> target.createOrder(customerCode, items));
    }

    @Test
    void createOrder_whenCustomerCodeIsEmpty_thenThrowIllegalArgumentException(){
        customerCode = "   ";
        assertThrows(InvalidInputData.class, () -> target.createOrder(customerCode, items));
    }

    @Test
    void createOrder_whenItemsIsNull_thenThrowIllegalArgumentException(){
        assertThrows(InvalidInputData.class, () -> target.createOrder(customerCode, null));
    }

    @Test
    void createOrder_whenItemQuantyIsLowerThanZero_thenThrowIllegalArgumentException(){
        var itemsWithNotQuantity = List.of(
                new OrderItem(1, "P001", 0, 10.0),
                new OrderItem(2, "P002", 0, 20.0)
        );
        assertThrows(InvalidQuantyException.class, () -> target.createOrder(customerCode, itemsWithNotQuantity));
    }

    @Test
    void createOrder_whenNoStockAvailable_thenThrowIllegalArgumentException(){
        when(stockClient.isStockAvailable()).thenReturn(false);
        assertThrows(StockNotAvailableException.class, () -> target.createOrder(customerCode, items));
    }

    @Test
    void createOrder_whenAllDataIsValid_ThenReturnCreatedOrder(){
        //Arrange
        when(stockClient.isStockAvailable()).thenReturn(true);

        //Act
        var result = target.createOrder(customerCode, items);

        //Assert
        assertNotNull(result);
        assertEquals(OrderStatus.PENDIENTE, result.status());
        assertFalse(result.items().isEmpty());
        assertTrue(Objects.equals(customerCode, result.customerCode()));
    }

    @Test
    void getOrderTotal_whenOrderIsValid_ThenReturnTotal(){
        //Arrange
        var order = new Order(1,customerCode,items,OrderStatus.PENDIENTE);

        //Act
        var total = target.getOrderTotal(order);

        //Assert
        assertTrue(total>0);
    }
  
}