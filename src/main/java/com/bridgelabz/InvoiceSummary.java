package com.bridgelabz;

public class InvoiceSummary {
    double noOfRides;
    double totalFare;
    double averageFare;

    public InvoiceSummary(double noOfRides, double totalFare, double averageFare) {
        this.noOfRides = noOfRides;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(that.noOfRides, noOfRides) == 0 &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.averageFare, averageFare) == 0;
    }
}
