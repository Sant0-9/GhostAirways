public class SteerageTicket extends Ticket {
    private boolean sitOnCargo; // Indicates if the passenger chose to sit on cargo

    // Constructor initializes the ticket with the "steerage" class and the
    // sitOnCargo option
    public SteerageTicket(boolean sitOnCargo) {
        super("steerage");
        this.sitOnCargo = sitOnCargo;
        if (sitOnCargo) // Increment option count if sit-on-cargo option is selected
            optionCount++;
    }

    // Display method to show ticket details for Steerage class
    @Override
    public void display() {
        System.out.println("Class: Steerage");
        if (sitOnCargo) // Print sit-on-cargo option if selected
            System.out.println("Option: Sit on cargo");

        // Print selected upgrades
        System.out.println("Upgrades: " + (thrillSeeker ? "Thrill Seeker " : "") +
                (wingman ? "Wingman (" + wingSide + ")" : "None"));

        // Print total number of options and upgrades selected
        System.out.println("Total Options + Upgrades: " + getTotalOptionsAndUpgrades());
        System.out.println();
    }
}
