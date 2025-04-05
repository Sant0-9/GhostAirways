import java.util.*;

public class TicketManager {
    private List<Ticket> tickets = new ArrayList<>(); // List to store all tickets

    // Method to add a new ticket to the list
    public void addTicket(Ticket t) {
        tickets.add(t);
    }

    // Method to display all tickets sorted by class and number of options/upgrades
    public void displayAllSorted() {
        Collections.sort(tickets); // Sort tickets using the Comparable interface implemented in Ticket
        for (Ticket t : tickets) {
            t.display(); // Display each ticket
        }
    }

    // Method to display tickets filtered by a specific upgrade
    public void displayByUpgrade(String upgrade) {
        for (Ticket t : tickets) {
            if (upgrade.equals("thrill") && t.thrillSeeker) { // Check if the Thrill Seeker upgrade is selected
                t.display();
            } else if (upgrade.equals("wing") && t.wingman) { // Check if the Wingman upgrade is selected
                t.display();
            }
        }
    }

    // Method to display tickets with no options or upgrades selected
    public void displayNoOptions() {
        for (Ticket t : tickets) {
            if (t.getTotalOptionsAndUpgrades() == 0) { // Check if no options/upgrades are selected
                t.display();
            }
        }
    }
}
