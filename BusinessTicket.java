public class BusinessTicket extends Ticket {
    private boolean aisleOrWindow; // Indicates if the passenger selected the Aisle/Window seat option
    private boolean overheadBin; // Indicates if the passenger selected the overhead bin option

    // Constructor initializes the ticket with the "business" class and selected
    // options
    public BusinessTicket(boolean aisleOrWindow, boolean overheadBin) {
        super("business");
        this.aisleOrWindow = aisleOrWindow;
        this.overheadBin = overheadBin;
        if (aisleOrWindow) // Increment option count if Aisle/Window seat option is selected
            optionCount++;
        if (overheadBin) // Increment option count if Overhead Bin option is selected
            optionCount++;
    }

    // Display method to show ticket details for Business class
    @Override
    public void display() {
        System.out.println("Class: Business");
        System.out.println("Perks: Middle seat, 1 free carry-on (lap), 1 bathroom pass");
        if (aisleOrWindow) // Print Aisle/Window option if selected
            System.out.println("Option: Aisle or Window seat");
        if (overheadBin) // Print Overhead Bin option if selected
            System.out.println("Option: Overhead bin");

        // Print selected upgrades
        System.out.println("Upgrades: " + (thrillSeeker ? "Thrill Seeker " : "") +
                (wingman ? "Wingman (" + wingSide + ")" : "None"));

        // Print total number of options and upgrades selected
        System.out.println("Total Options + Upgrades: " + getTotalOptionsAndUpgrades());
        System.out.println();
    }
}
