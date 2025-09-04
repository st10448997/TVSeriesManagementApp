import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class Series {
    private Map<String, SeriesModel> seriesDatabase = new HashMap<>();

    public void captureSeries(Scanner scanner) {
        System.out.println("Enter the TV Series Name:");
        String seriesName = scanner.nextLine();

        int seriesAge = -1;
        while (seriesAge < 2 || seriesAge > 18) {
            System.out.println("Enter the TV Series Age (between 2 and 18):");
            if (scanner.hasNextInt()) {
                seriesAge = scanner.nextInt();
                if (seriesAge < 2 || seriesAge > 18) {
                    System.out.println("Invalid input! Age must be between 2 and 18.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid number for age.");
                scanner.next();  // Consume the invalid input
            }
        }

        System.out.println("Enter the Number of Episodes:");
        int seriesNumberOfEpisodes = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        // Create the Series object using the data captured
        SeriesModel newSeries = new SeriesModel(seriesName, seriesAge, seriesNumberOfEpisodes);
        
        // Save the new series in the database
        seriesDatabase.put(seriesName, newSeries);

        System.out.println("New series captured: " + newSeries);
        System.out.println("The series details have been successfully saved!");
    }

    public void searchSeries(Scanner scanner) {
        System.out.println("Enter the series name to search:");
        String seriesName = scanner.nextLine();

        SeriesModel foundSeries = seriesDatabase.get(seriesName);
        if (foundSeries == null) {
            System.out.println("Series " + seriesName + " not found.");
            return;
        }

        System.out.println("Found series: " + foundSeries);
        System.out.println("Would you like to update or delete this series?");
        System.out.println("(1) Update the series.");
        System.out.println("(2) Delete the series.");
        System.out.println("(3) Do nothing.");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer
        switch (choice) {
            case 1:
                updateSeries(scanner, foundSeries);
                break;
            case 2:
                deleteSeries(scanner);
                break;
            case 3:
                System.out.println("No changes made.");
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    public void updateSeries(Scanner scanner, SeriesModel seriesToUpdate) {
        System.out.println("Enter new series name (press Enter to keep current):");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            seriesToUpdate.setSeriesName(newName);
        }

        System.out.println("Enter new age (press Enter to keep current):");
        String ageInput = scanner.nextLine();
        if (!ageInput.isEmpty()) {
            int newAge = Integer.parseInt(ageInput);
            if (newAge >= 2 && newAge <= 18) {
                seriesToUpdate.setSeriesAge(newAge);
            } else {
                System.out.println("Invalid age. No changes made.");
            }
        }

        System.out.println("Enter new number of episodes (press Enter to keep current):");
        String episodesInput = scanner.nextLine();
        if (!episodesInput.isEmpty()) {
            int newEpisodes = Integer.parseInt(episodesInput);
            seriesToUpdate.setSeriesNumberOfEpisodes(newEpisodes);
        }

        System.out.println("Series updated: " + seriesToUpdate);
    }

    public void deleteSeries(Scanner scanner) {
        System.out.println("Enter the series name to delete:");
        String seriesName = scanner.nextLine();

        if (!seriesDatabase.containsKey(seriesName)) {
            System.out.println("Series " + seriesName + " not found.");
            return;
        }

        System.out.println("Are you sure you want to delete the series " + seriesName + "? (Y/N)");
        String confirmation = scanner.nextLine().toUpperCase();

        if ("Y".equals(confirmation)) {
            seriesDatabase.remove(seriesName);
            System.out.println("Series " + seriesName + " has been deleted.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    public void viewSeriesReport() {
        if (seriesDatabase.isEmpty()) {
            System.out.println("No series available.");
            return;
        }

        System.out.println("Series Report:");
        System.out.println("**********************************");
        for (SeriesModel series : seriesDatabase.values()) {
            System.out.println("Series Name: " + series.getSeriesName());
            System.out.println("Age Restriction: " + series.getSeriesAge());
            System.out.println("Number of Episodes: " + series.getSeriesNumberOfEpisodes());
            System.out.println("-----------------------------");
        }
    }
    // Get the number of series in the database
    public int getSeriesCount() {
        return seriesDatabase.size();
    }
}
