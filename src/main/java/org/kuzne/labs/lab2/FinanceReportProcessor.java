package org.kuzne.labs.lab2;

import java.util.ArrayList;
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

    static int sumPaymentOnDate(FinanceReport report, String date) {
        int dd,mm,yy;
        int sum = 0;
        dd = Integer.parseInt(date.substring(0,2));
        mm = Integer.parseInt(date.substring(3,5));
        yy = Integer.parseInt(date.substring(6,10));
        for (Payment payment: report.getPaymentsArray()) {
            if (payment.getPaymentDay() == dd && payment.getPaymentMonth() == mm && payment.getPaymentYear() == yy) {
                sum+=payment.getPaymentAmount();
            }
        }
        return sum;
    }

    static String monthsWithoutPayment(FinanceReport report, int yy) {
        ArrayList<Integer> monthsWithPayment = new ArrayList<>();
        ArrayList<String> monthsWithoutPayment = new ArrayList<>();
        for (Payment payment: report.getPaymentsArray()) {
            if (payment.getPaymentYear() == yy) { monthsWithPayment.add(payment.getPaymentMonth()); }
        }
        for (int i = 1; i <= 12; i++) {
            if (!monthsWithPayment.contains(i)) {
                switch (i) {
                    case 1: monthsWithoutPayment.add("Январь"); break;
                    case 2: monthsWithoutPayment.add("Февраль"); break;
                    case 3: monthsWithoutPayment.add("Март"); break;
                    case 4: monthsWithoutPayment.add("Апрель"); break;
                    case 5: monthsWithoutPayment.add("Май"); break;
                    case 6: monthsWithoutPayment.add("Июнь"); break;
                    case 7: monthsWithoutPayment.add("Июль"); break;
                    case 8: monthsWithoutPayment.add("Август"); break;
                    case 9: monthsWithoutPayment.add("Сентябрь"); break;
                    case 10: monthsWithoutPayment.add("Октябрь"); break;
                    case 11: monthsWithoutPayment.add("Ноябрь"); break;
                    case 12: monthsWithoutPayment.add("Декабрь"); break;
                }

            }
        }
        return monthsWithoutPayment.toString();
    }
}
