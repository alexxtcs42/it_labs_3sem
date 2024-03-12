import java.util.List;

@DataProcessor
public abstract class Processor {
    protected List<Integer> integerList;
    public Processor(List<Integer> values) {
        integerList = values;
    }
    public List<Integer> processValues() {
        return integerList;
    }
}
