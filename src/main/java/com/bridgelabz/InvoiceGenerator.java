package com.bridgelabz;

import java.util.ArrayList;

public class InvoiceGenerator {

    private double totalFare;
    private double averageFare;
    RideRepository rideRepository;
    RideCategory rideCategory;

    public InvoiceGenerator(RideCategory.rideType type) {
        rideRepository = new RideRepository();
        rideCategory = new RideCategory(type);
    }

    public double getTotalFare(double distance, double time) {
        totalFare = distance * rideCategory.COST_PER_KILOMETER + time * rideCategory.COST_PER_MINUTE;
        return (totalFare > rideCategory.MINIMUM_COST) ? totalFare : rideCategory.MINIMUM_COST;
    }

    public InvoiceSummary getTotalFare(Ride[] rides) {
        totalFare = 0;
        for (Ride ride :
                rides) {
            totalFare += getTotalFare(ride.distance, ride.time);
        }
        averageFare = totalFare / rides.length;
        return new InvoiceSummary(rides.length, totalFare, averageFare);
    }

    public InvoiceSummary getTotalFare(int userId) throws RideRepositoryException {
        return this.getTotalFare(rideRepository.getRides(userId));
    }

    public void addRides(int userId, Ride[] rides) throws RideRepositoryException {
        rideRepository.addRides(userId, rides);
    }
}