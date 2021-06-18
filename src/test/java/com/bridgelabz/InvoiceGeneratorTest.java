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
}
