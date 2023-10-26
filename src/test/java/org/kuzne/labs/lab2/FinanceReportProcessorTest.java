package org.Lab2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinanceReportProcessorTest {

    //TODO: Как обрабатывать исключения в конструкторах?
    private FinanceReport reportInput;
    private FinanceReport reportSurnameSearchOutput;
    private FinanceReport reportGetLittlePaymentsOutput;
    private FinanceReport reportInputExceptions;
    @BeforeEach
    void setUp() {
        Payment payment1 = new Payment("Kuznetsov Alexey", 8,12,2004, 133742);
        Payment payment2 = new Payment("Derisheva Katya", 8,4,2004, 7372);
        Payment payment3 = new Payment("Khmelev Daniil", 31,12,2000, 708);
        Payment[] paymentArrayInput = {payment1, payment2};
        reportInput = new FinanceReport(paymentArrayInput, "Alexey Kuznetsov", 3,10,2023);
        Payment[] paymentArraySurnameSearchOutput = {payment1};
        reportSurnameSearchOutput = new FinanceReport(paymentArraySurnameSearchOutput, "Alexey Kuznetsov", 3,10,2023);
        Payment[] paymentArrayGetLittlePaymentsOutput = {payment2};
        reportGetLittlePaymentsOutput = new FinanceReport(paymentArrayGetLittlePaymentsOutput, "Alexey Kuznetsov", 3,10,2023);

        Payment[] paymentArrayInputExceptions = {payment1, payment2, payment3};
        reportInputExceptions = new FinanceReport(paymentArrayInputExceptions,"Vasya", 20,12,2023);
    }

    @Test
    void surnameSearch() {
        assertEquals(reportSurnameSearchOutput, FinanceReportProcessor.surnameSearch(reportInput, 'K', "Alexey Kuznetsov", 3,10,2023));
    }

    @Test
    void getLittlePayments() {
        assertEquals(reportGetLittlePaymentsOutput, FinanceReportProcessor.getLittlePayments(reportInput, 7400, "Alexey Kuznetsov", 3,10,2023));
    }

    @Test
    void getLittlePayments_13monthsInReport_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> FinanceReportProcessor.getLittlePayments(reportInputExceptions,0,"Alexey",1,13,2001));
    }

    @Test
    void surnameSearch_32daysInReport_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> FinanceReportProcessor.getLittlePayments(reportInput,0,"Alexey",32,1,2001));
    }
}