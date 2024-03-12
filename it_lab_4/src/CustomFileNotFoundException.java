import java.io.FileNotFoundException;

public class CustomFileNotFoundException extends FileNotFoundException {
    public CustomFileNotFoundException() { super(); }
    public CustomFileNotFoundException(String message) { super(message); }
    public CustomFileNotFoundException(String message, Throwable cause) { super(message); }
    public CustomFileNotFoundException(Throwable cause) { super(String.valueOf(cause)); }
}
