package org.kuzne.labs.lab2;

import java.util.Arrays;

public class FinanceReportProcessor {
    static FinanceReport surnameSearch(FinanceReport report, char surnameChar, String authorName,  int creationDay, int creationMonth, int creationYear) throws IllegalArgumentException {
        if (creationMonth > 12) { throw new IllegalArgumentException("There are only 12 months in a year"); }
        if (creationDay > 31) { throw new IllegalArgumentException("There are 28-31 days in a month"); }
        Payment[] surnamePaymentsArrayFull = new Payment[report.getPaymentQuantity()];
        int j = 0;
        for (int i = 0; i < report.getPaymentQuantity(); i++) {
            if (report.getPayment(i).getName().charAt(0) == surnameChar) {
                surnamePaymentsArrayFull[j] = report.getPayment(i);
                j++;
            }
        }
        Payment[] surnamePaymentsArrayCut = Arrays.copyOfRange(surnamePaymentsArrayFull, 0, j);
        return new FinanceReport(surnamePaymentsArrayCut, authorName, creationDay, creationMonth, creationYear);
    }

    static FinanceReport getLittlePayments(FinanceReport report, int minPaymentAmount, String authorName, int creationDay, int creationMonth, int creationYear) throws IllegalArgumentException {
        if (creationMonth > 12) { throw new IllegalArgumentException("There are only 12 months in a year"); }
        if (creationDay > 31) { throw new IllegalArgumentException("There are 28-31 days in a month"); }
        Payment[] lessThenMinPaymentsArrayFull = new Payment[report.getPaymentQuantity()];
        int j = 0;
        for (int i = 0; i < report.getPaymentQuantity(); i++) {
            if (report.getPayment(i).getPaymentAmount() < minPaymentAmount) {
                lessThenMinPaymentsArrayFull[j] = report.getPayment(i);
                j++;
            }
        }
        Payment[] lessThenMinPaymentsArrayCut = Arrays.copyOfRange(lessThenMinPaymentsArrayFull, 0, j);
        return new FinanceReport(lessThenMinPaymentsArrayCut,authorName, creationDay, creationMonth, creationYear);
    }
}
