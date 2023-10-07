package org.Lab2;

import java.util.Arrays;

public class FinanceReportProcessor {
    static FinanceReport surnameSearch(FinanceReport report, char surnameChar, String authorName, String creationDate) {
        Payment[] surnamePaymentsArrayFull = new Payment[report.getPaymentQuantity()];
        int j = 0;
        for (int i = 0; i < report.getPaymentQuantity(); i++) {
            if (report.getPayment(i).getName().charAt(0) == surnameChar) {
                surnamePaymentsArrayFull[j] = report.getPayment(i);
                j++;
            }
        }
        Payment[] surnamePaymentsArrayCut = Arrays.copyOfRange(surnamePaymentsArrayFull, 0, j);
        return new FinanceReport(surnamePaymentsArrayCut,authorName, creationDate);
    }

    static FinanceReport getLittlePayments(FinanceReport report, double minPaymentAmount, String authorName, String creationDate) {
        Payment[] lessThenMinPaymentsArrayFull = new Payment[report.getPaymentQuantity()];
        int j = 0;
        for (int i = 0; i < report.getPaymentQuantity(); i++) {
            if (report.getPayment(i).getPaymentAmount() < minPaymentAmount) {
                lessThenMinPaymentsArrayFull[j] = report.getPayment(i);
                j++;
            }
        }
        Payment[] lessThenMinPaymentsArrayCut = Arrays.copyOfRange(lessThenMinPaymentsArrayFull, 0, j);
        return new FinanceReport(lessThenMinPaymentsArrayCut,authorName, creationDate);
    }
}
