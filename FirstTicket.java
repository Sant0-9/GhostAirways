public class FirstTicket extends Ticket {
    private boolean yokePedals; // Indicates if the passenger selected the Yoke & Pedals option

    // Constructor initializes the ticket with the "first" class and selected
    // options
    public FirstTicket(boolean yokePedals) {
        super("first");
        this.yokePedals = yokePedals;
        if (yokePedals) // Increment option count if Yoke & Pedals option is selected
            optionCount++;
    }

    // Display method to show ticket details for First class
    @Override
    public void display() {
        System.out.println("Class: First");
        System.out.println("Perks: Seat with captain, instruments, 2 bathroom passes, drinks");
        if (yokePedals) // Print Yoke & Pedals option if selected
            System.out.println("Option: Yoke & Pedals");

        // Print selected upgrades
        System.out.println("Upgrades: " + (thrillSeeker ? "Thrill Seeker " : "") +
                (wingman ? "Wingman (" + wingSide + ")" : "None"));

        // Print total number of options and upgrades selected
        System.out.println("Total Options + Upgrades: " + getTotalOptionsAndUpgrades());
        System.out.println();
    }
}
