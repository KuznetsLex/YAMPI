package org.kuzne.labs.lab2;

import java.util.Objects;

public class Payment {
    private String name;
    private int paymentDay;
    private int paymentMonth;
    private int paymentYear;
    private int paymentAmount;


    public Payment(String name, int paymentDay, int paymentMonth, int paymentYear, int paymentAmount) throws IllegalArgumentException{
        if (paymentMonth > 12) { throw new IllegalArgumentException("There are only 12 months in a year"); }
        if (paymentDay > 31) { throw new IllegalArgumentException("There are 28-31 days in a month"); }
        this.name = name;
        this.paymentDay = paymentDay;
        this.paymentMonth = paymentMonth;
        this.paymentYear = paymentYear;
        this.paymentAmount = paymentAmount;
    }

    public String getName() {
        return name;
    }

    public int getPaymentDay() {
        return paymentDay;
    }

    public int getPaymentMonth() {
        return paymentMonth;
    }

    public int getPaymentYear() {
        return paymentYear;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPaymentDay(int paymentDay) throws IllegalArgumentException {
        if (paymentDay > 31) { throw new IllegalArgumentException("There are 28-31 days in a month"); }
        this.paymentDay = paymentDay;
    }

    public void setPaymentMonth(int paymentMonth) throws IllegalArgumentException{
        if (paymentMonth > 12) { throw new IllegalArgumentException("There are only 12 months in a year"); }
        this.paymentMonth = paymentMonth;
    }

    public void setPaymentYear(int paymentYear) {
        this.paymentYear = paymentYear;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return paymentDay == payment.paymentDay && paymentMonth == payment.paymentMonth && paymentYear == payment.paymentYear && paymentAmount == payment.paymentAmount && Objects.equals(name, payment.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, paymentDay, paymentMonth, paymentYear, paymentAmount);
    }
    @Override
    public String toString() {
        return "Payment{" +
                "name='" + name + '\'' +
                ", paymentDay=" + paymentDay +
                ", paymentMonth=" + paymentMonth +
                ", paymentYear=" + paymentYear +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
}
