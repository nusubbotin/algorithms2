
public class ArrayLengthExceptiom extends RuntimeException {
    public ArrayLengthExceptiom() {
    }

    public ArrayLengthExceptiom(String message) {
        super(message);
    }

    public ArrayLengthExceptiom(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayLengthExceptiom(Throwable cause) {
        super(cause);
    }

    public ArrayLengthExceptiom(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
