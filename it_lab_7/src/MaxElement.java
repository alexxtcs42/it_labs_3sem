import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MaxElement {
    public static void main(String[] args) throws InterruptedException {
        Random rnd = new Random();
        int n = rnd.nextInt(2, 6);
        int m = rnd.nextInt(2, 6);
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = rnd.nextInt(100);
            }
        }
        ExecutorService service = Executors.newFixedThreadPool(n);
        int[] maxElements = new int[n];
        for (int k = 0; k < n; k++) {
            int finalK = k;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    maxElements[finalK] = findMax(matrix[finalK]);
                    System.out.println("Row's max: " + findMax(matrix[finalK]));
                }
            });
        }
        service.shutdown();
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Max element: " + findMax(maxElements));
        service.shutdown();
    }
    public static int findMax(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        return m;
    }
}
