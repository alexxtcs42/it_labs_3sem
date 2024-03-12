public class VacuumCleaner extends Appliance {
    private String cleaningType;
    private double volumeOfTheDustCollector;
    private int numberOfNozzles;
    public VacuumCleaner(String n, int year, String c, boolean power,
                         String type, double volume, int nozzles) {
        super(n, year, c, power);
        cleaningType = type;
        volumeOfTheDustCollector = volume;
        numberOfNozzles = nozzles;
    }
    public VacuumCleaner() {
        this("PyleSOS", 2023, "white", false,
                "dry", 1.2, 3);
    }
    public String getCleaningType() {return cleaningType;}
    public double getVolumeOfTheDustCollector() {return volumeOfTheDustCollector;}
    public int getNumberOfNozzles() {return numberOfNozzles;}
    @Override
    public String powerOn() {
        if (!powered) {
            powered = true;
            return "Appliance is now powered. Make sure all cats are safe";
        }
        else {
            return "Appliance is already powered";
        }
    }
    @Override
    public String powerOff() {
        if (powered) {
            powered = false;
            return "Appliance is now turned off. Not a single cat was injured";
        }
        else {
            return "Appliance is already turned off";
        }
    }
}
