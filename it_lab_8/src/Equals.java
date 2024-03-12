import java.util.List;

@DataProcessor
public class Equals extends Processor {
    private List<Integer> secondList;
    public Equals(List<Integer> values, List<Integer> values2) {
        super(values);
        secondList = values2;
    }
    public List<Integer> processValues() {
        boolean eq = integerList.stream().equals(secondList);
        int equals = 0;
        if (eq) {
            equals = 1;
        }
        return List.of(equals);
    }
}
