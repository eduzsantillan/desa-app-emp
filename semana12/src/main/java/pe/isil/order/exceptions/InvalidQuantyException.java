package pe.isil.order.exceptions;

public class InvalidQuantyException extends RuntimeException{
    public InvalidQuantyException(String messge){
        super(messge);
    }
}
