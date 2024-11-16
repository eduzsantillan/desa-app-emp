package pe.isil.order.exceptions;

public class InvalidInputData extends RuntimeException{
    public InvalidInputData(String messge){
        super(messge);
    }
}
