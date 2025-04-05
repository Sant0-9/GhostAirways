public abstract class Ticket implements Comparable<Ticket> {

    // Instance variables to hold the class and ticket details
    protected String passengerClass;
    protected int optionCount;
    protected boolean thrillSeeker;
    protected boolean wingman;
    protected String wingSide;

    // Constructor that initializes the passenger class
    public Ticket(String passengerClass) {
        this.passengerClass = passengerClass;
        this.optionCount = 0; // Initializes option count to 0
    }

    // Getter method for passengerClass
    public String getPassengerClass() {
        return passengerClass;
    }

    // Method to calculate the total number of options and upgrades selected
    public int getTotalOptionsAndUpgrades() {
        int count = optionCount; // Start with the base option count
        if (thrillSeeker)
            count++; // Add one if the Thrill Seeker upgrade was selected
        if (wingman)
            count++; // Add one if the Wingman upgrade was selected
        if (wingman && wingSide != null && !wingSide.isEmpty())
            count++; // Add one if the Wingman upgrade was selected and a side is specified
        return count; // Return the total number of options + upgrades
    }

    // Setter method for the thrillSeeker upgrade
    public void setThrillSeeker(boolean value) {
        this.thrillSeeker = value;
    }

    // Setter method for the wingman upgrade and side (left/right)
    public void setWingman(boolean value, String side) {
        this.wingman = value;
        this.wingSide = side;
    }

    public abstract void display();

    // Comparison method to sort tickets by class and then by the number of
    // options/upgrades
    @Override
    public int compareTo(Ticket other) {
        // Compare classes based on predefined ranks
        int thisRank = getClassRank(this.passengerClass);
        int otherRank = getClassRank(other.passengerClass);

        // If class ranks are different, return comparison result
        if (thisRank != otherRank)
            return Integer.compare(thisRank, otherRank);

        // If classes are the same, compare by the total number of options and upgrades
        return Integer.compare(this.getTotalOptionsAndUpgrades(), other.getTotalOptionsAndUpgrades());
    }

    // Helper method to assign a rank to a class
    private int getClassRank(String cls) {
        switch (cls.toLowerCase()) {
            case "steerage":
                return 1; // Steerage class gets rank 1
            case "coach":
                return 2; // Coach class gets rank 2
            case "business":
                return 3; // Business class gets rank 3
            case "first":
                return 4; // First class gets rank 4
            default:
                return 5; // For invalid class
        }
    }
}
