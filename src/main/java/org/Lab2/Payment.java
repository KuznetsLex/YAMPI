package org.Lab2;

import java.util.Objects;

public class Payment {
    private String name;
    private String paymentDate; //число, месяц, год
    private double paymentAmount;

    public Payment(String name, String paymentDate, double paymentAmount) {
        this.name = name;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public String getName() {
        return name;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(paymentAmount, payment.paymentAmount) == 0 && Objects.equals(name, payment.name) && Objects.equals(paymentDate, payment.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, paymentDate, paymentAmount);
    }
}
