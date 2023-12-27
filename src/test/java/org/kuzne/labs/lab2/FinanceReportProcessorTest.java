package org.kuzne.labs.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinanceReportProcessorTest {
    private FinanceReport reportInput;
    private FinanceReport reportSurnameSearchOutput;
    private FinanceReport reportGetLittlePaymentsOutput;
    @BeforeEach
    void setUp() {
        Payment payment1 = new Payment("Kuznetsov Alexey", 8,12,2004, 133742);
        Payment payment2 = new Payment("Khmelev Daniil", 1,1,2000, 708);
        Payment payment3 = new Payment("Derisheva Katya", 8,12,2004, 7372);
        Payment[] paymentArrayInput = {payment1, payment2, payment3};
        reportInput = new FinanceReport(paymentArrayInput, "Alexey Kuznetsov", 3,10,2023);
        Payment[] paymentArraySurnameSearchOutput = {payment1, payment2};
        reportSurnameSearchOutput = new FinanceReport(paymentArraySurnameSearchOutput, "Alexey Kuznetsov", 3,10,2023);
        Payment[] paymentArrayGetLittlePaymentsOutput = {payment2};
        reportGetLittlePaymentsOutput = new FinanceReport(paymentArrayGetLittlePaymentsOutput, "Alexey Kuznetsov", 3,10,2023);
    }

    @Test
    void surnameSearch() {
        assertEquals(reportSurnameSearchOutput, FinanceReportProcessor.surnameSearch(reportInput, 'K', "Alexey Kuznetsov", 3,10,2023));
    }

    @Test
    void getLittlePayments() {
        assertEquals(reportGetLittlePaymentsOutput, FinanceReportProcessor.getLittlePayments(reportInput, 7300, "Alexey Kuznetsov", 3,10,2023));
    }

    @Test
    void sumPaymentOnDate() {
        assertEquals(141114, FinanceReportProcessor.sumPaymentOnDate(reportInput,"08.12.2004"));
    }

    @Test
    void monthsWithoutPayment1() {
        assertEquals("[Февраль, Март, Апрель, Май, Июнь, Июль, Август, Сентябрь, Октябрь, Ноябрь, Декабрь]", FinanceReportProcessor.monthsWithoutPayment(reportInput, 2000));
    }

    @Test
    void monthsWithoutPayment2() {
        assertEquals("[Январь, Февраль, Март, Апрель, Май, Июнь, Июль, Август, Сентябрь, Октябрь, Ноябрь]", FinanceReportProcessor.monthsWithoutPayment(reportInput, 2004));
    }
}