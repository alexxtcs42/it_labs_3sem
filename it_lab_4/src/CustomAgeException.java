public class CustomAgeException extends Exception{
    public CustomAgeException() { super(); }
    public CustomAgeException(String message) { super(message); }
    public CustomAgeException(String message, Throwable cause) { super(message, cause); }
    public CustomAgeException(Throwable cause) { super(cause); }
}
