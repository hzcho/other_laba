package laba6.exception;

public class TransportRuntimeException extends RuntimeException{
    public TransportRuntimeException(String message, Throwable err){
        super(message, err);
    }
}
