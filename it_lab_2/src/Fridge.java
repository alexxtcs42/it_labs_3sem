public class Fridge extends Appliance {
    private double fridgeVolume;
    private int numberOfShelves;
    private boolean foodInsideTheFridge;
    public Fridge(String n, int year, String c, boolean power, double v, int shelves, boolean food) {
        super(n, year, c, power);
        fridgeVolume = v;
        numberOfShelves = shelves;
        foodInsideTheFridge = food;
    }
    public Fridge() {this("el Cholodos", 2023, "white", false,
            295, 6, false);}
    public double getFridgeVolume() {return fridgeVolume;}
    public int getNumberOfShelves() {return numberOfShelves;}
    public boolean isFoodInsideTheFridge() {return foodInsideTheFridge;}
    public String fillTheFridge() {
        if (!foodInsideTheFridge) {
            foodInsideTheFridge = true;
            return "The fridge is now full";
        }
        else {
            return "The fridge is already full";
        }
    }
    public String emptyTheFridge() {
        if (foodInsideTheFridge) {
            foodInsideTheFridge = false;
            return "Bon appetit!";
        }
        else {
            return "Sorry, but you're a student";
        }
    }
}
