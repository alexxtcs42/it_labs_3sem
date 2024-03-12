import java.util.List;
import java.util.stream.Collectors;

@DataProcessor
public class Sort extends Processor {
    public Sort(List<Integer> values) {
        super(values);
    }
    public List<Integer> processValues() {
        return integerList.stream().sorted().collect(Collectors.toList());
    }
}
