package org.Lab2;
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
    public String toString() {
        String report = String.format("Автор: %s, дата: %s, Платежи: \n", authorName, creationDate);
        for (Payment item : paymentsArray) {
            report += String.format("Плательщик: %s, дата: %s, сумма: %.0f руб. %.0f коп.\n",
                    item.getName(), item.getPaymentDate(), Math.floor(item.getPaymentAmount()),item.getPaymentAmount()%1*100);
        }
        return report;
    }
}
