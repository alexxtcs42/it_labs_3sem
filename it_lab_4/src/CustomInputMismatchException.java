import java.util.InputMismatchException;

public class CustomInputMismatchException extends InputMismatchException {
    public CustomInputMismatchException() { super(); }
    public CustomInputMismatchException(String message) { super(message); }
    public CustomInputMismatchException(String message, Throwable cause) { super(message); }
    public CustomInputMismatchException(Throwable cause) { super(String.valueOf(cause)); }
}
