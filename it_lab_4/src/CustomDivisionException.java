public class CustomDivisionException extends ArithmeticException {
    public CustomDivisionException() { super(); }
    public CustomDivisionException(String message) { super(message); }
    public CustomDivisionException(String message, Throwable cause) { super(message); }
    public CustomDivisionException(Throwable cause) { super(String.valueOf(cause)); }
}