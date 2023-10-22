package org.kuzne.labs.lab2;

import java.util.Arrays;
import java.util.Objects;

public class FinanceReport {
    private final Payment[] paymentsArray;
    private final String authorName;
    private final int paymentDay;
    private final int paymentMonth;
    private final int paymentYear;


    public FinanceReport(Payment[] paymentsArray, String authorName, int paymentDay, int paymentMonth, int paymentYear) throws IllegalArgumentException {
        if (paymentMonth > 12) { throw new IllegalArgumentException("There are only 12 months in a year"); }
        if (paymentDay > 31) { throw new IllegalArgumentException("There are 28-31 days in a month"); }
        this.paymentsArray = paymentsArray;
        this.authorName = authorName;
        this.paymentDay = paymentDay;
        this.paymentMonth = paymentMonth;
        this.paymentYear = paymentYear;
    }

    public FinanceReport(FinanceReport report) {
        int i = 0;
        this.paymentsArray = new Payment[report.getPaymentQuantity()];
        for (Payment item : report.paymentsArray) {
            this.paymentsArray[i] = new Payment(item.getName(), item.getPaymentDay(), item.getPaymentMonth(), item.getPaymentYear(), item.getPaymentAmount());
            i++;
        }
        authorName = report.authorName;
        paymentDay = report.paymentDay;
        paymentMonth = report.paymentMonth;
        paymentYear = report.paymentYear;
    }

    public int getPaymentQuantity() {
        return paymentsArray.length;
    }

    public void setPayment(int paymentIndex, Payment payment) {
        paymentsArray[paymentIndex].setName(payment.getName());
        paymentsArray[paymentIndex].setPaymentDay(payment.getPaymentDay());
        paymentsArray[paymentIndex].setPaymentMonth(payment.getPaymentMonth());
        paymentsArray[paymentIndex].setPaymentYear(payment.getPaymentYear());
        paymentsArray[paymentIndex].setPaymentAmount(payment.getPaymentAmount());
    }

    public Payment getPayment(int paymentIndex) {
        return paymentsArray[paymentIndex];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceReport that = (FinanceReport) o;
        return paymentDay == that.paymentDay && paymentMonth == that.paymentMonth && paymentYear == that.paymentYear && Arrays.equals(paymentsArray, that.paymentsArray) && Objects.equals(authorName, that.authorName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(authorName, paymentDay, paymentMonth, paymentYear);
        result = 31 * result + Arrays.hashCode(paymentsArray);
        return result;
    }

    @Override
    public String toString() {
        String report = String.format("Автор: %s, дата: %d.%d.%d, Платежи: \n", authorName, paymentDay, paymentMonth, paymentYear);
        for (Payment item : paymentsArray) {
            report += String.format("\tПлательщик: %s, дата: %d.%d.%d, сумма: %d руб. %d коп.\n",
                    item.getName(), item.getPaymentDay(), item.getPaymentMonth(), item.getPaymentYear(), item.getPaymentAmount()/100,item.getPaymentAmount()%100);
        }
        return report;
    }
}
