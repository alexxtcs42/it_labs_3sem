import java.util.ArrayList;
import java.util.List;

public class CustomStack {
    private List<Object> stack;

    public CustomStack() {
        this.stack = new ArrayList<>();
    }

    public void push(Object item) {
        stack.add(item);
    }

    public Object pop() throws CustomEmptyStackException {
        if (stack.isEmpty()) {
            Logger ExceptionLogger = new Logger();
            ExceptionLogger.logToFile("Empty Stack");
            throw new CustomEmptyStackException("Empty Stack");
        } else {
            return stack.remove(stack.size() - 1);
        }
    }

    public Object peek() throws CustomEmptyStackException {
        if (stack.isEmpty()) {
            Logger ExceptionLogger = new Logger();
            ExceptionLogger.logToFile("Empty Stack");
            throw new CustomEmptyStackException("Empty Stack");
        } else {
            return stack.get(stack.size() - 1);
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}