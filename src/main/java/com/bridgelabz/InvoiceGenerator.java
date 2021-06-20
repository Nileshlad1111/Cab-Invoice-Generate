package com.bridgelabz;

import java.util.ArrayList;

public class InvoiceGenerator {
    private int COST_PER_KILOMETER = 10;
    private int COST_PER_MINUTE = 1;
    private int MINIMUM_COST = 5;
    private double distance;
    private double time;
    private double totalFare;

    public InvoiceGenerator(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public InvoiceGenerator() {

    }

    public double getTotalFare() {
        double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return (totalFare > MINIMUM_COST) ? totalFare : MINIMUM_COST;
    }

    public double getTotalFare(ArrayList<Ride> rides) {
        for (Ride ride :
                rides) {
            this.distance = ride.distance;
            this.time = ride.time;
            this.totalFare += getTotalFare();
        }
        return totalFare;
    }
}
