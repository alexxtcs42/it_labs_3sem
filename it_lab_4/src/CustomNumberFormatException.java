public class CustomNumberFormatException extends NumberFormatException {
    public CustomNumberFormatException() { super(); }
    public CustomNumberFormatException(String message) { super(message); }
    public CustomNumberFormatException(String message, Throwable cause) { super(message); }
    public CustomNumberFormatException(Throwable cause) { super(String.valueOf(cause)); }
}
