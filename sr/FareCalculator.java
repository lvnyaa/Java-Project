public class FareCalculator {
    private static final double BASE_FARE = 50.0;
    private static final double RATE_PER_KM = 15.0;
    private static final double RATE_PER_MINUTE = 2.0;
    private static final double NIGHT_SURCHARGE_FACTOR = 1.25; // 25% extra for night trips
    private static final double PEAK_SURGE_FACTOR = 1.50;      // 50% extra during peak hours

    public static double calculateBaseFare() {
        return BASE_FARE;
    }

    public static double calculateDistanceFare(double distanceKm) {
        return distanceKm * RATE_PER_KM;
    }

    public static double calculateTimeFare(double durationMinutes) {
        return durationMinutes * RATE_PER_MINUTE;
    }

    public static double calculateTotalFare(Trip trip) {
        double subtotal = BASE_FARE + calculateDistanceFare(trip.getDistanceKm()) + calculateTimeFare(trip.getDurationMinutes());

        if (trip.isNightTrip()) {
            subtotal *= NIGHT_SURCHARGE_FACTOR;
        }

        if (trip.isPeakHour()) {
            subtotal *= PEAK_SURGE_FACTOR;
        }

        return subtotal + trip.getTollFees();
    }
}