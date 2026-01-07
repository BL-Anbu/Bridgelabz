package Day_30_Practice_Problem.model;

public class InvoiceSummary {
    public final int totalRides;
    public final double totalFare;
    public final double averageFare;

    public InvoiceSummary(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare = totalFare / totalRides;
    }
}
