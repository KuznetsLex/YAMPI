package org.Lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinanceReportProcessorTest {
    private FinanceReport reportInput;
    private FinanceReport reportSurnameSearchOutput;
    private FinanceReport reportGetLittlePaymentsOutput;
    @BeforeEach
    void setUp() {
        Payment payment1 = new Payment("Kuznetsov Alexey", "08.12.2004", 1337.42);
        Payment payment2 = new Payment("Khmelev Daniil", "01.01.2000", 7.08);
        Payment payment3 = new Payment("Derisheva Katya", "08.04.2004", 73.72);
        Payment[] paymentArrayInput = {payment1, payment2, payment3};
        reportInput = new FinanceReport(paymentArrayInput, "Alexey Kuznetsov", "03.10.2023");
        Payment[] paymentArraySurnameSearchOutput = {payment1, payment2};
        reportSurnameSearchOutput = new FinanceReport(paymentArraySurnameSearchOutput, "Alexey Kuznetsov", "03.10.2023");
        Payment[] paymentArrayGetLittlePaymentsOutput = {payment2};
        reportGetLittlePaymentsOutput = new FinanceReport(paymentArrayGetLittlePaymentsOutput, "Alexey Kuznetsov", "03.10.2023");
    }

    @Test
    void surnameSearch() {
        assertEquals(reportSurnameSearchOutput, FinanceReportProcessor.surnameSearch(reportInput, 'K', "Alexey Kuznetsov", "03.10.2023"));
    }

    @Test
    void getLittlePayments() {
        assertEquals(reportGetLittlePaymentsOutput, FinanceReportProcessor.getLittlePayments(reportInput, 73, "Alexey Kuznetsov", "03.10.2023"));
    }
}