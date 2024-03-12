import java.util.List;

@DataProcessor
public class Count extends Processor {
    public Count(List<Integer> values) {
        super(values);
    }
    public List<Integer> processValues() {
        int c = (int) integerList.stream().count();
        return List.of(c);
    }
}
