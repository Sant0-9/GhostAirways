public class CoachTicket extends Ticket {
    private boolean handrail; // Indicates if the passenger selected the handrail option
    private boolean carryOn; // Indicates if the passenger selected the carry-on option

    // Constructor initializes the ticket with the "coach" class and selected
    // options
    public CoachTicket(boolean handrail, boolean carryOn) {
        super("coach");
        this.handrail = handrail;
        this.carryOn = carryOn;
        if (handrail) // Increment option count if handrail option is selected
            optionCount++;
        if (carryOn) // Increment option count if carry-on option is selected
            optionCount++;
    }

    // Display method to show ticket details for Coach class
    @Override
    public void display() {
        System.out.println("Class: Coach");
        if (handrail) // Print handrail option if selected
            System.out.println("Option: Handrail");
        if (carryOn) // Print carry-on option if selected
            System.out.println("Option: Carry-on (stand on it)");

        // Print selected upgrades
        System.out.println("Upgrades: " + (thrillSeeker ? "Thrill Seeker " : "") +
                (wingman ? "Wingman (" + wingSide + ")" : "None"));

        // Print total number of options and upgrades selected
        System.out.println("Total Options + Upgrades: " + getTotalOptionsAndUpgrades());
        System.out.println();
    }
}
