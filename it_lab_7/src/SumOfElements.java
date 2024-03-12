import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SumOfElements {
    public static void main(String[] args) {
        Random rnd = new Random();
        int n = rnd.nextInt(2, 51);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(100);
        }
        int m = n;
        for (int j = 2; j < n / 2; j++) {
            if (n % j == 0) {
                m = j;
                break;
            }
        }
        ExecutorService service = Executors.newFixedThreadPool(m);
        final int[] finalSum = {0};
        for (int k = 0; k < m; k++) {
            int finalK = k;
            int finalM = m;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    finalSum[0] += findSum(arr, finalK * (n / finalM), (finalK + 1) * (n / finalM));
                    System.out.println("//Thread's sum: " +
                            findSum(arr, finalK * (n / finalM), (finalK + 1) * (n / finalM)));
                }
            });
        }
        service.shutdown();
        System.out.println("Array: " + Arrays.toString(arr));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final sum: " + finalSum[0]);
        service.shutdown();
    }
    public static int findSum(int[] arr, int from, int to) {
        int sum = 0;
        for (int i = from; i < to; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int findSum(Stack<Integer> stack, int from, int to) {
        int sum = 0;
        for (int i = from; i < to; i++) {
            sum += stack.elementAt(i);
        }
        return sum;
    }
}
