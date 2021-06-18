package com.bridgelabz;

public class InvoiceGenerator {
    private int COST_PER_KILOMETER = 10;
    private int COST_PER_MINUTE = 1;
    private int MINIMUM_COST = 5;
    double distance;
    double time;

    public InvoiceGenerator(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public double getTotalFare() {
        double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return totalFare;
    }
}
