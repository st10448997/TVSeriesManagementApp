import java.util.Scanner;

public class TVSeriesManagementApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        // Create an instance of the Series class to manage series-related tasks
        Series seriesManager = new Series();

        // Display the initial menu
        do {
            System.out.println("LATEST SERIES - 2025");
            System.out.println("**************************");
            System.out.println("Enter 1 to launch menu or any other key to exit");
            String input = scanner.nextLine();

            if (!input.equals("1")) {
                break;
            }

            // Display the second menu with options
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Display a series.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) View the latest series - 2015");
            System.out.println("(6) View series report");

            // Capture the user's choice
            option = scanner.nextInt();
            scanner.nextLine();  // Clear the newline character from the input buffer

            // Handle the menu options
            switch (option) {
                case 1:
                    seriesManager.captureSeries(scanner);
                    break;
                case 2:
                    seriesManager.searchSeries(scanner);
                    break;
                case 3:
                    System.out.println("Display a series...");
                    break;
                case 4:
                    seriesManager.deleteSeries(scanner);
                    break;
                case 5:
                    System.out.println("Viewing the latest series - 2015...");
                    break;
                case 6:
                    seriesManager.viewSeriesReport();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (true);

        System.out.println("Goodbye!");
        scanner.close();
    }
}


