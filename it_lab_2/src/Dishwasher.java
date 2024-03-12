public class Dishwasher extends Appliance {
    private int numberOfPrograms;
    private int numberOfTemperatureRegimes;
    private boolean dishesInside;
    public static int numberOfDishwashers = 0;
    public Dishwasher(String n, int year, String c, boolean power,
                      int programs, int regimes, boolean dishes) {
        super(n, year, c, power);
        numberOfPrograms = programs;
        numberOfTemperatureRegimes = regimes;
        dishesInside = dishes;
        numberOfDishwashers += 1;
    }
    public Dishwasher() {this("Posudomojka", 2023, "white", false,
            5, 4, false);}
    public double getNumberOfPrograms() {return numberOfPrograms;}
    public int getNumberOfTemperatureRegimes() {return numberOfTemperatureRegimes;}
    public boolean areDishesInside() {return dishesInside;}
    public String putDishesIn() {
        if (!dishesInside) {
            dishesInside = true;
            return "The dishwasher is now full";
        }
        else {
            return "The dishwasher is already full";
        }
    }
    public String getDishesOut() {
        if (dishesInside) {
            dishesInside = false;
            return "The dishwasher is now empty";
        }
        else {
            return "The dishwasher is already empty";
        }
    }
}
