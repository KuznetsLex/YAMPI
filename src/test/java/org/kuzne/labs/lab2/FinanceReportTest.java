package org.kuzne.labs.lab2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinanceReportTest {
    private static Payment[] paymentArray;
    @BeforeAll
    static void setUp() {
        Payment payment1 = new Payment("Kuznetsov Alexey", 8,12,2004, 133742);
        Payment payment2 = new Payment("Khmelev Daniil", 2,3,2000, 708);
        Payment payment3 = new Payment("Derisheva Katya", 8,4,2004, 7372);
        paymentArray = new Payment[]{payment1, payment2, payment3};
    }

    @Test
    void constructor_13month_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new FinanceReport(paymentArray, "Alexey Kuznetsov", 3,13,2023));
    }

    @Test
    void constructor_32day_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new FinanceReport(paymentArray, "Alexey Kuznetsov", 32,11,2023));
    }

    @Test
    void copy_constructor() {
        FinanceReport financeReport = new FinanceReport(paymentArray, "Alexey Kuznetsov", 3,12,2023);
        FinanceReport copyReport = new FinanceReport(financeReport);
        assertEquals(financeReport, copyReport);
        Payment payment = new Payment("Kuznetsov", 9,8,2004, 133742);
        copyReport.setPayment(0, payment);
        assertNotEquals(copyReport, financeReport);
    }
}