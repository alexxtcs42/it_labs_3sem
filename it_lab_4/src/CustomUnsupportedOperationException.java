public class CustomUnsupportedOperationException extends UnsupportedOperationException {
    public CustomUnsupportedOperationException() { super(); }
    public CustomUnsupportedOperationException(String message) { super(message); }
    public CustomUnsupportedOperationException(String message, Throwable cause) { super(message, cause); }
    public CustomUnsupportedOperationException(Throwable cause) { super(cause); }
}
