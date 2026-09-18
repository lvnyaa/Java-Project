import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=============================================");
        System.out.println(" WELCOME TO TAXI BILLING & FLEET SYSTEM ");
        System.out.println("=============================================");

        while (running) {
            System.out.println("\nSelect Option:");
            System.out.println("1. Calculate Fare & Generate Receipt");
            System.out.println("2. Exit System");
            System.out.print("Enter choice (1-2): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Passenger Name: ");
                        String passenger = scanner.nextLine();

                        System.out.print("Enter Driver Name: ");
                        String driver = scanner.nextLine();

                        System.out.print("Enter Trip Distance (in km): ");
                        double distance = scanner.nextDouble();

                        System.out.print("Enter Trip Duration (in minutes): ");
                        double duration = scanner.nextDouble();

                        System.out.print("Enter Hour of Day (0-23): ");
                        int hour = scanner.nextInt();

                        System.out.print("Enter Toll Fees (in INR): ");
                        double tolls = scanner.nextDouble();

                        System.out.print("Is it Peak Hour Traffic? (true/false): ");
                        boolean isPeak = scanner.nextBoolean();

                        Trip trip = new Trip(passenger, driver, distance, duration, hour, tolls, isPeak);
                        String invoice = BillingService.generateInvoice(trip);
                        System.out.println(invoice);

                    } catch (Exception e) {
                        System.out.println("\n[ERROR] Invalid input! " + e.getMessage());
                        scanner.nextLine(); // Clear buffer
                    }
                    break;

                case 2:
                    System.out.println("Exiting system. Thank you!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1 or 2.");
            }
        }
        scanner.close();
    }
}