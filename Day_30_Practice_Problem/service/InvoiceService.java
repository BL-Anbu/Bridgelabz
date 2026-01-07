package Day_30_Practice_Problem.service;

import Day_30_Practice_Problem.model.InvoiceSummary;
import Day_30_Practice_Problem.model.Ride;
import Day_30_Practice_Problem.repository.RideRepository;

public class InvoiceService {

    private final RideRepository repository;
    private final CabInvoiceGenerator generator;

    public InvoiceService(RideRepository repository) {
        this.repository = repository;
        this.generator = new CabInvoiceGenerator();
    }

    public InvoiceSummary getInvoice(String userId) {
        Ride[] rides = repository.getRides(userId);
        return generator.calculateFare(rides);
    }
}

