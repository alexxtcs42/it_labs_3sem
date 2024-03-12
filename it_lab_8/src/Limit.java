import java.util.List;
import java.util.stream.Collectors;

@DataProcessor
public class Limit extends Processor {
    private int limit;
    public Limit(List<Integer> values, int n) {
        super(values);
        limit = n;
    }
    public List<Integer> processValues() {
        return integerList.stream().limit(limit).collect(Collectors.toList());
    }
}
