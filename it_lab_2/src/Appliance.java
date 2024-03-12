public abstract class Appliance {
    private String name;
    private int yearOfProduction;
    private String colour;
    protected boolean powered;
    public Appliance (String n, int year, String c, boolean power) {
        name = n;
        yearOfProduction = year;
        colour = c;
        powered = power;
    }
    public Appliance() {this("BytTech", 2023, "white", false);}
    public String getName() {return name;}
    public int getYear() {return yearOfProduction;}
    public String getColour() {return colour;}
    public boolean isPowered() {return powered;}
    public void setName(String value) {name = value;}
    public String powerOn() {
        if (!powered) {
            powered = true;
            return "Appliance is now powered";
        }
        else {
            return "Appliance is already powered";
        }
    }
    public String powerOff() {
        if (powered) {
            powered = false;
            return "Appliance is now turned off";
        }
        else {
            return "Appliance is already turned off";
        }
    }
}
