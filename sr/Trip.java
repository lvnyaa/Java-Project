public class Trip {
    private String passengerName;
    private String driverName;
    private double distanceKm;
    private double durationMinutes;
    private int hourOfDay; // 0 to 23
    private double tollFees;
    private boolean isPeakHour;

    public Trip(String passengerName, String driverName, double distanceKm, double durationMinutes, int hourOfDay, double tollFees, boolean isPeakHour) {
        if (distanceKm <= 0 || durationMinutes <= 0) {
            throw new IllegalArgumentException("Distance and duration must be positive values.");
        }
        if (hourOfDay < 0 || hourOfDay > 23) {
            throw new IllegalArgumentException("Hour of day must be between 0 and 23.");
        }
        if (tollFees < 0) {
            throw new IllegalArgumentException("Toll fees cannot be negative.");
        }

        this.passengerName = passengerName;
        this.driverName = driverName;
        this.distanceKm = distanceKm;
        this.durationMinutes = durationMinutes;
        this.hourOfDay = hourOfDay;
        this.tollFees = tollFees;
        this.isPeakHour = isPeakHour;
    }

    public String getPassengerName() { return passengerName; }
    public String getDriverName() { return driverName; }
    public double getDistanceKm() { return distanceKm; }
    public double getDurationMinutes() { return durationMinutes; }
    public int getHourOfDay() { return hourOfDay; }
    public double getTollFees() { return tollFees; }
    public boolean isPeakHour() { return isPeakHour; }

    public boolean isNightTrip() {
        return hourOfDay >= 22 || hourOfDay < 6;
    }
}