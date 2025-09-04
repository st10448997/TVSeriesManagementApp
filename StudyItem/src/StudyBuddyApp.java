import java.util.Scanner;

public class StudyBuddyApp {
    private static Subject[] subjects = new Subject[10]; // max 10 subjects
    private static int subjectCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int choice = 0;

        do {
            System.out.println("\n Welcome to StudyBuddy!");
            System.out.println("1. Add Subject");
            System.out.println("2. View Schedule");
            System.out.println("3. Update Subject Status");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            input = scanner.nextLine();

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("️ Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    addSubject(scanner);
                    break;
                case 2:
                    viewSchedule();
                    break;
                case 3:
                    updateStatus(scanner);
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println(" Goodbye, and happy studying!");
                    break;
                default:
                    System.out.println("️ Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addSubject(Scanner scanner) {
        if (subjectCount >= subjects.length) {
            System.out.println("️ Subject limit reached.");
            return;
        }

        System.out.print("Enter subject name: ");
        String name = scanner.nextLine();
        System.out.print("Enter study hours: ");
        int hours = 0;

        try {
            hours = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("️ Invalid number. Subject not added.");
            return;
        }

        subjects[subjectCount] = new Subject(name, hours);
        subjectCount++;
        System.out.println(" Subject added successfully.");
    }

    private static void viewSchedule() {
        System.out.println("\n Your Weekly Schedule:");
        for (int i = 0; i < subjectCount; i++) {
            Subject s = subjects[i];
            System.out.println((i + 1) + ". " + s.getName() + " - " + s.getHours() + " hours - " + s.getStatus());
        }
    }

    private static void updateStatus(Scanner scanner) {
        viewSchedule();
        System.out.print("Enter subject number to update: ");
        int index = 0;

        try {
            index = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("️ Invalid number.");
            return;
        }

        if (index < 1 || index > subjectCount) {
            System.out.println("️ Invalid subject number.");
            return;
        }

        System.out.print("Enter new status (Completed/In Progress): ");
        String status = scanner.nextLine();
        subjects[index - 1].setStatus(status);
        System.out.println(" Status updated.");
    }

    private static void generateReport() {
        int totalHours = 0;
        System.out.println("\n Study Report:");
        for (int i = 0; i < subjectCount; i++) {
            Subject s = subjects[i];
            System.out.println("- " + s.getName() + ": " + s.getHours() + " hours (" + s.getStatus() + ")");
            totalHours += s.getHours();
        }
        System.out.println(" Total Study Hours: " + totalHours);
    }
}
