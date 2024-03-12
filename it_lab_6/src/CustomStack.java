import java.util.Arrays;

public class CustomStack<T> {
    public void main(String[] args) {
        CustomStack stack = new CustomStack(10);
        stack.push("нулевой элемент");
        stack.push("первый элемент");
        System.out.println(stack.pop());
        stack.push("новый элемент");
    }
    private int size;
    private T[] data;

    public CustomStack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            System.out.println("Stack overflow");
        } else {
            data[size] = element;
            size++;
        }
    }

    public T pop() {
        if (size == 0) {
            System.out.println("Stack underflow");
            return null;
        } else {
            T element = data[size - 1];
            data[size - 1] = null;
            size--;
            return element;
        }
    }

    public T peek() {
        if (size == 0) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return data[size - 1];
        }
    }
}
