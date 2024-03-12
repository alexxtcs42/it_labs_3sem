import java.util.concurrent.RecursiveAction;

public class Loader extends RecursiveAction {
    @Override
    protected void compute() {
        while ((SumOfElements.findSum(Warehouse.wh2, 0, Warehouse.wh2.toArray().length) + Warehouse.wh1.peek() < 150) &&
                (Warehouse.wh1.toArray().length > 1)) {
            Warehouse.wh2.push(Warehouse.wh1.pop());
        }
    }
}
