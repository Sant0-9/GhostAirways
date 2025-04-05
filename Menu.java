import java.util.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in); // Scanner for user input
    private TicketManager manager = new TicketManager(); // Manages the list of tickets

    // Start method to display the menu and handle user input
    public void start() {
        while (true) {
            System.out.println("\n--- Ghost Airways Ticketing System ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Display All Tickets");
            System.out.println("3. Display Tickets with Thrill Seeker Upgrade");
            System.out.println("4. Display Tickets with Wingman Upgrade");
            System.out.println("5. Display Tickets with No Options or Upgrades");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    addTicket(); // Add a new ticket
                    break;
                case 2:
                    manager.displayAllSorted(); // Display all tickets sorted
                    break;
                case 3:
                    manager.displayByUpgrade("thrill"); // Display tickets with Thrill Seeker upgrade
                    break;
                case 4:
                    manager.displayByUpgrade("wing"); // Display tickets with Wingman upgrade
                    break;
                case 5:
                    manager.displayNoOptions(); // Display tickets with no options/upgrades
                    break;
                case 6:
                    return; // Exit the program
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Method to add a new ticket based on user input
    private void addTicket() {
        System.out.print("Enter class (steerage/coach/business/first): ");
        String cls = scanner.nextLine().toLowerCase(); // Read class of ticket
        Ticket t = null;

        // Create a ticket based on the selected class
        switch (cls) {
            case "steerage":
                t = new SteerageTicket(prompt("Sit on cargo? (y/n): "));
                break;
            case "coach":
                t = new CoachTicket(prompt("Handrail? (y/n): "), prompt("Carry-on? (y/n): "));
                break;
            case "business":
                t = new BusinessTicket(prompt("Aisle/Window seat? (y/n): "), prompt("Overhead bin? (y/n): "));
                break;
            case "first":
                t = new FirstTicket(prompt("Yoke/Pedals? (y/n): "));
                break;
            default:
                System.out.println("Invalid class entered.");
                return;
        }

        // Add optional upgrades
        if (prompt("Add Thrill Seeker upgrade? (y/n): ")) {
            t.setThrillSeeker(true);
        }
        if (prompt("Add Wingman upgrade? (y/n): ")) {
            System.out.print("Which wing (left/right): ");
            String side = scanner.nextLine();
            t.setWingman(true, side); // Set wing side for Wingman upgrade
        }

        manager.addTicket(t); // Add the ticket to the ticket manager
        System.out.println("Ticket added successfully.");
    }

    // Method to prompt user with a yes/no question and return the response
    private boolean prompt(String message) {
        System.out.print(message);
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y"); // Return true if user answers "y"
    }
}
