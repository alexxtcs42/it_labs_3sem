public class TwoChamberFridge extends Fridge {
    private double freezerVolume;
    private int numberOfCompartments;
    private boolean foodInsideTheFreezer;
    public TwoChamberFridge(String n, int year, String c, boolean power, double v, int shelves, boolean food,
                            double fv, int compartments, boolean vareniki) {
        super(n, year, c, power, v, shelves, food);
        freezerVolume = fv;
        numberOfCompartments = compartments;
        foodInsideTheFreezer = vareniki;
    }
    public TwoChamberFridge() {this("Cholodos + Morozilka", 2023, "white", false,
            230, 3, false, 130, 4, false);}
    public double getFreezerVolume() {return freezerVolume;}
    public double getTotalVolume() {return (getFridgeVolume() + freezerVolume);}
    public int getNumberOfCompartments() {return numberOfCompartments;}
    public boolean isFoodInsideTheFreezer() {return foodInsideTheFreezer;}
    public String fillTheFreezer() {
        if (!foodInsideTheFreezer) {
            foodInsideTheFreezer = true;
            return "The freezer is now full";
        }
        else {
            return "The freezer is already full";
        }
    }
    public String emptyTheFreezer() {
        if (foodInsideTheFreezer) {
            foodInsideTheFreezer = false;
            return "Bon appetit!";
        }
        else {
            return "Sorry, but you're a student";
        }
    }
}
