package com.bridgelabz;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


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
        Ride[] rides = {new Ride(12, 10)
                , new Ride(6, 12)
                , new Ride(24, 12)};
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        InvoiceSummary invoiceSummary = invoiceGenerator.getTotalFare(rides);
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(3, 454, 151.33333333333334);
        Assert.assertEquals(invoiceSummaryExpected, invoiceSummary);
    }

    @Test
    public void givenDistanceTimeAndUserIdForRides_ReturnInvoiceSummary() {
        try {
            Ride[] rides = {new Ride(12, 10)
                    , new Ride(6, 12)
                    , new Ride(24, 12)};
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            int userId = 1;
            invoiceGenerator.addRides(userId, rides);
            InvoiceSummary invoiceSummary = invoiceGenerator.getTotalFare(userId);
            InvoiceSummary invoiceSummaryExpected = invoiceGenerator.getTotalFare(rides);
            Assert.assertEquals(invoiceSummaryExpected, invoiceSummary);
        } catch (RideRepositoryException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenDistanceTimeAndUserIdForRides_WhenRidesNull_ThenThrowException() {
        try {
            Ride[] rides = {new Ride(12, 10)
                    , new Ride(6, 12)
                    , new Ride(24, 12)};
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            int userId = 1;
            invoiceGenerator.addRides(userId, rides);
            InvoiceSummary invoiceSummary = invoiceGenerator.getTotalFare(userId);
            InvoiceSummary invoiceSummaryExpected = invoiceGenerator.getTotalFare(rides);
            Assert.assertEquals(invoiceSummaryExpected, invoiceSummary);
        } catch (RideRepositoryException e) {
            Assert.assertEquals(RideRepositoryException.ExceptionType.NULL_LIST, e.type);
        }
    }

    @Test
    public void givenDistanceTimeAndUserIdForRides_WhenUserIdDoesNotExist_ThenThrowException() {
        try {
            Ride[] rides = {new Ride(12, 10)
                    , new Ride(6, 12)
                    , new Ride(24, 12)};
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            int userId = 1;
            int wrongUserId = 2;
            invoiceGenerator.addRides(userId, rides);
            InvoiceSummary invoiceSummary = invoiceGenerator.getTotalFare(wrongUserId);
            InvoiceSummary invoiceSummaryExpected = invoiceGenerator.getTotalFare(rides);
            Assert.assertEquals(invoiceSummaryExpected, invoiceSummary);
        } catch (RideRepositoryException e) {
            Assert.assertEquals(RideRepositoryException.ExceptionType.NO_VALUE_FOUND, e.type);
        }
    }

    @Test
    public void givenDistanceTimeAndUserIdForRides_WhenSameUserId_ThenAddRidesToSameArrayList() {
        try {
            Ride[] rides = {new Ride(12, 10)
                    , new Ride(6, 12)
                    , new Ride(24, 12)};
            Ride[] ridesNew = {new Ride(3, 7)
                    , new Ride(3, 23)
                    , new Ride(8, 22)};
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            int userId = 1;
            invoiceGenerator.addRides(userId, rides.clone());
            invoiceGenerator.addRides(userId, ridesNew.clone());
            Ride[] resultingArray = new Ride[rides.length + ridesNew.length];
            System.arraycopy(rides, 0, resultingArray, 0, rides.length);
            System.arraycopy(ridesNew, 0, resultingArray, rides.length, ridesNew.length);
            InvoiceSummary invoiceSummary = invoiceGenerator.getTotalFare(userId);
            InvoiceSummary invoiceSummaryExpected = invoiceGenerator.getTotalFare(resultingArray);
            Assert.assertEquals(invoiceSummaryExpected, invoiceSummary);
        } catch (RideRepositoryException e) {
            e.printStackTrace();
        }
    }
}