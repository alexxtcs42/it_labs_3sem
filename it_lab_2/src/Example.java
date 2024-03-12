public class Example {
    public static void main(String[] args) {
        System.out.println(Dishwasher.numberOfDishwashers);
        Dishwasher newDishwasher = new Dishwasher();
        System.out.println(Dishwasher.numberOfDishwashers);
        Dishwasher anotherDishwasher = new Dishwasher("Posudomojka 2: comeback of the year", 2024,
                "green", false, 31337, 420, false);
        System.out.println(Dishwasher.numberOfDishwashers);
    }
}
