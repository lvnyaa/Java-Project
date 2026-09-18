import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BillingService {
    private static final String LOG_FILE = "transactions.txt";

    public static String generateInvoice(Trip trip) {
        double baseFare = FareCalculator.calculateBaseFare();
        double distFare = FareCalculator.calculateDistanceFare(trip.getDistanceKm());
        double timeFare = FareCalculator.calculateTimeFare(trip.getDurationMinutes());
        double totalFare = FareCalculator.calculateTotalFare(trip);

        StringBuilder invoice = new StringBuilder();
        invoice.append("\n============================================\n");
        invoice.append("         TAXI TRIP BILLING INVOICE          \n");
        invoice.append("============================================\n");
        invoice.append("Passenger Name : ").append(trip.getPassengerName()).append("\n");
        invoice.append("Driver Name    : ").append(trip.getDriverName()).append("\n");
        invoice.append("Distance       : ").append(trip.getDistanceKm()).append(" km\n");
        invoice.append("Duration       : ").append(trip.getDurationMinutes()).append(" mins\n");
        invoice.append("Time of Trip   : ").append(trip.getHourOfDay()).append(":00 hrs\n");
        invoice.append("--------------------------------------------\n");
        invoice.append(String.format("Base Fare      : INR %.2f\n", baseFare));
        invoice.append(String.format("Distance Fare  : INR %.2f\n", distFare));
        invoice.append(String.format("Time Fare      : INR %.2f\n", timeFare));
        invoice.append("Night Surcharge: ").append(trip.isNightTrip() ? "Applied (1.25x)" : "None").append("\n");
        invoice.append("Peak Hour Surge: ").append(trip.isPeakHour() ? "Applied (1.50x)" : "None").append("\n");
        invoice.append(String.format("Toll Charges   : INR %.2f\n", trip.getTollFees()));
        invoice.append("--------------------------------------------\n");
        invoice.append(String.format("TOTAL FARE     : INR %.2f\n", totalFare));
        invoice.append("============================================\n");

        saveTransactionToFile(trip, totalFare);
        return invoice.toString();
    }

    private static void saveTransactionToFile(Trip trip, double totalFare) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pw.printf("[%s] Passenger: %s | Distance: %.2f km | Total: INR %.2f\n",
                    timestamp, trip.getPassengerName(), trip.getDistanceKm(), totalFare);
        } catch (IOException e) {
            System.err.println("Error writing transaction to log file: " + e.getMessage());
        }
    }
}