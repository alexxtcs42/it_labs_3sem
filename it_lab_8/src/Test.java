import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        ArrayList<Processor> arrlist = new ArrayList<>();
        DataManager manager = new DataManager(new File("source.txt"), new File("destination.txt"), arrlist);
        manager.loadData();
//        manager.registerDataProcessor(new Sort(manager.loadedData));
        manager.registerDataProcessor(new Limit(manager.loadedData, 3));
        manager.processData();
//        System.out.println(manager.loadedData);
        Sort sort = new Sort(manager.loadedData);
//        System.out.println(sort.processValues());
    }
}
