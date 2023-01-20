//Class Code
public class Emissions {
//<-   -   -   -   -   -     Daniel    -   -   -   -   -   ->
    //Variables to get
    private String schoolName;
    private double hoursUsedPerDay;
    private double wattsPerBulb;
    private int numOfBulbs;
    private int numberOfStudents;
    
    //Variables final
    private final int treeAbsorption = 12; // 12kg per tree
    private final int schoolDaysAYear = 194; // @ https://www.dpcdsb.org/schools/school-year-calendar
    private final double emissionsPerkWh = 0.180; //As per cpt instructional pdf

    // Constructor
    public Emissions( String name, double hours, double wattage, int bulbs, int students) {
        schoolName = name;
        hoursUsedPerDay = hours;
        wattsPerBulb = wattage;
        numOfBulbs = bulbs;
        numberOfStudents = students;
    }

    // new modifier
    public Double averageWattage() {
        return wattsPerBulb * numOfBulbs / 1000;
    }
    
    // new modifier
    public Double averageYearlyPower() {
        return (double) (hoursUsedPerDay * schoolDaysAYear * averageWattage());
    }
    
    // new modifier 
    public Double yearlyEmissions() {
        return emissionsPerkWh * averageYearlyPower();
    }

    // new modifier 
    public Double studentEmissions() {
        return yearlyEmissions() / numberOfStudents;
    }

    // new modifier 
    public Integer carbonOffset() {
        return (int) ((yearlyEmissions() / treeAbsorption) + 0.5);
    }

//<-   -   -   -   -   -     Marcus    -   -   -   -   -   ->
    // new accessor 
    public String getSchoolName() {
        return schoolName;
    }

    // new accessor 
    public Double getHoursUsedPerDay() {
        return hoursUsedPerDay;
    }

    // new accessor 
    public Double getWattsPerBulb() {
        return wattsPerBulb;
    }

    // new accessor 
    public Integer getNumOfBulbs() {
        return numOfBulbs;
    }

    // new accessor 
    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }
//<-   -   -   -   -   -      Ryan     -   -   -   -   -   ->
    // returns all data given and created
    public String toString() {
        return 
        "School: "                                              + getSchoolName() + 
        "\n\tNumber of students: "                              + getNumberOfStudents()  + 
        "\n\tNumber of bulbs: "                                 + getNumOfBulbs()  + 
        "\n\tWatts per bulbs: "                                 + getWattsPerBulb() + 
        "\n\tHours in use: "                                    + getHoursUsedPerDay() +
        "\n\t\tAverage wattage per bulb: "                      + String.format("%.2f",averageWattage()) + " kW" +
        "\n\t\tAverage yearly kWh: "                            + String.format("%.2f", averageYearlyPower()) + " kWh/year" +
        "\n\t\tYearly total Co2 emissions: "                    + String.format("%.2f", yearlyEmissions()) + " kg/year" +
        "\n\t\tAverage Co2 emissions per student per year: "    + String.format("%.2f", studentEmissions()) + " kg/year" +
        "\nTrees needed to offset emissions: "                  + carbonOffset() + "\n" ;
    }
}
