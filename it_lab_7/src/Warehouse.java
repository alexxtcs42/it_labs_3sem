import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Warehouse {
    public static Stack<Integer> wh0 = new Stack<Integer>();
    public static Stack<Integer> wh1 = new Stack<Integer>();
    public static Stack<Integer> wh2 = new Stack<Integer>();
    public static void main(String[] args) throws InterruptedException {
        Random rnd = new Random();
        int n = rnd.nextInt(2, 51);
        for (int i = 0; i < n; i++) {
            wh0.push(rnd.nextInt(1, 20));
        }
        wh1.push(0);
        wh2.push(0);
        Object[] wh0_array = wh0.toArray();
        Arrays.sort(wh0_array, Collections.reverseOrder());
        for (int i = 0; i < wh0_array.length; i++) {
            wh1.push((Integer) wh0_array[i]);
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool(3);
        Loader loader1 = new Loader();
        Loader loader2 = new Loader();
        Loader loader3 = new Loader();
        System.out.println("Warehouse 1 before: " + wh1);
        System.out.println("Warehouse 2 before: " + wh2);
        forkJoinPool.invoke(loader1);
        forkJoinPool.invoke(loader2);
        forkJoinPool.invoke(loader3);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Warehouse 1 after: " + wh1);
        System.out.println("Warehouse 2 after: " + wh2);
        System.out.println("Warehouse 2 sum of elements: " +
                SumOfElements.findSum(Warehouse.wh2, 0, Warehouse.wh2.toArray().length));
    }
}
