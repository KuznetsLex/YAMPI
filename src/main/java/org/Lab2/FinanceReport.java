package org.Lab2;

import java.util.Arrays;
import java.util.Objects;

public class FinanceReport {
    final private Payment[] paymentsArray;
    final private String authorName;
    final private String creationDate; //число, месяц, год

    public FinanceReport(Payment[] paymentsArray, String authorName, String creationDate) {
        this.paymentsArray = paymentsArray;
        this.authorName = authorName;
        this.creationDate = creationDate;
    }

    public FinanceReport(FinanceReport report) {
        int i = 0;
        this.paymentsArray = new Payment[report.getPaymentQuantity()];
        for (Payment item : report.paymentsArray) {
            this.paymentsArray[i] = new Payment(item.getName(), item.getPaymentDate(), item.getPaymentAmount());
            i++;
        }
        authorName = report.authorName;
        creationDate = report.creationDate;
    }

    public int getPaymentQuantity() {
        return paymentsArray.length;
    }

    public void setPayment(int paymentIndex, Payment payment) {
        paymentsArray[paymentIndex].setName(payment.getName());
        paymentsArray[paymentIndex].setPaymentDate(payment.getPaymentDate());
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
        return Arrays.equals(paymentsArray, that.paymentsArray) && Objects.equals(authorName, that.authorName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(authorName, creationDate);
        result = 31 * result + Arrays.hashCode(paymentsArray);
        return result;
    }

    @Override
    public String toString() {
        String report = String.format("Автор: %s, дата: %s, Платежи: \n", authorName, creationDate);
        for (Payment item : paymentsArray) {
            report += String.format("Плательщик: %s, дата: %s, сумма: %.0f руб. %.0f коп.\n",
                    item.getName(), item.getPaymentDate(), Math.floor(item.getPaymentAmount()),item.getPaymentAmount()%1*100);
        }
        return report;
    }
}
