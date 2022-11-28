
public class ArrayIndexException extends RuntimeException {
    public ArrayIndexException() {
    }

    public ArrayIndexException(String message) {
        super(message);
    }

    public ArrayIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayIndexException(Throwable cause) {
        super(cause);
    }

    public ArrayIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
