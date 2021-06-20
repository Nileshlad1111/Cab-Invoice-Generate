package com.bridgelabz;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class InvoiceGeneratorTest {
    @Test
    public void givenDistanceTime_ReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(10, 10);
        double totalFare = invoiceGenerator.getTotalFare();
        Assert.assertEquals(110, totalFare, 0);
    }

    @Test
    public void givenLessDistanceTime_ReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(0.1, 1);
        double totalFare = invoiceGenerator.getTotalFare();
        Assert.assertEquals(5, totalFare, 0);
    }

    @Test
    public void givenDistanceTimeForRides_ReturnInvoiceSummary() {
        ArrayList<Ride> rides = new ArrayList<>(Arrays.asList(new Ride(12, 10)
                , new Ride(6, 12), new Ride(24, 12)));
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double totalFare = invoiceGenerator.getTotalFare(rides);
        Assert.assertEquals(454, totalFare, 0);
    }

}
