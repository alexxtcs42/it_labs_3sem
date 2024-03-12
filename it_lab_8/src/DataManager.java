import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataManager {
    protected ArrayList<Processor> processors;
    protected File source;
    protected File destination;
    protected List<Integer> loadedData;
    public DataManager(File src, File dstn, ArrayList<Processor> pr) {
        processors = pr;
        source = src;
        destination = dstn;
    }
    @DataProcessor
    public void registerDataProcessor(Processor proc) {
        processors.add(proc);
    }
    public void loadData() {
        int[] vals = new int[] {};
        ArrayList values = new ArrayList<>(Arrays.asList(vals));
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(source);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        byte[] buffer = new byte[1024];
        int bytesRead;
        while (true) {
            try {
                if (!((bytesRead = inputStream.read(buffer)) != -1)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            System.out.print(new String(buffer, 0, bytesRead));
            String[] nv = new String(buffer, 0, bytesRead).split(" ");
            int k = 0;
            for (String j : nv) {
//                System.out.println(k);
                values.add(k, Integer.parseInt(j));
                k += 1;
            }
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try {
//            BufferedReader in = new BufferedReader(new FileReader(source));
//            int i = 0;
//            while (true) {
//                try {
//                    values.set(i, Integer.parseInt(in.readLine()));
//                }
//                catch (Exception e) {
//                    break;
//                }
//            }
//            in.close();
//        }
//        catch (IOException e) {
//            System.out.println("Some error occurred while loading!");
//        }
        loadedData = (List<Integer>) values;
    }
    @DataProcessor
    public void processData() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (Processor pr : processors) {
            Runnable task = () -> {
                saveData(destination, pr.processValues());
            };
            executorService.execute(task);
        }
        executorService.shutdown();
    }
    public void saveData(final File dest, List<Integer> values) {
        PrintStream fileStream = null;
        try {
            fileStream = new PrintStream(dest);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        fileStream.println(String.valueOf(values));
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(dest));
//            writer.write(String.valueOf(values));
//            writer.flush();
//            writer.close();
//        }
//        catch (IOException e) {
//            System.out.println("Some error occurred while saving!");
//        }
    }
}
