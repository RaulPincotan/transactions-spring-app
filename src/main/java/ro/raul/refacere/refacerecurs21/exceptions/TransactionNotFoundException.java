package ro.raul.refacere.refacerecurs21.exceptions;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String msg) {
        super(msg);
    }
}
