import java.util.List;
import java.util.stream.Collectors;

@DataProcessor
public class Filter extends Processor {
    private boolean expression;
    public Filter(List<Integer> values, boolean expr) {
        super(values);
        expression = expr;
    }
    public List<Integer> processValues() {
        return integerList.stream().filter(x -> expression).collect(Collectors.toList());
    }
}
