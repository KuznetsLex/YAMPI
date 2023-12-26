package org.kuzne.labs.lab2;
public class Main {
    public static void main(String[] args) throws Exception {
//        Работа со строками
        String s1 = "ало ";
        System.out.println(StringProcessor.copy(s1,3));
        try {
            System.out.println(StringProcessor.copy(s1,-3));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Exeption was catched. Continue...\n");
        }
        System.out.println(StringProcessor.insertionsCount("abaa", "aa"));
        try {
            System.out.println(StringProcessor.insertionsCount("abaa", ""));
            System.out.println(StringProcessor.insertionsCount("abaa", null));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Exeption was catched. Continue...\n");
        }

        String s2 = "1 баран, 2 барана, 3 барана, 4 барана";
        System.out.println(StringProcessor.numbersToText(s2));
        StringBuilder s3 = new StringBuilder("123456789");
        System.out.println(StringProcessor.deleteEverySecond(s3));


//        Массивы объектов

        Payment payment1 = new Payment("Kuznetsov Alexey", 8,12,2004, 133742);
        Payment payment2 = new Payment("Khmelev Daniil", 2,3,2000, 708);
        Payment payment3 = new Payment("Derisheva Katya", 8,4,2004, 7372);
        Payment[] paymentArray = {payment1, payment2, payment3};
        FinanceReport report = new FinanceReport(paymentArray, "Alexey Kuznetsov", 3,11,2023);
        System.out.println(report);
        FinanceReport report2 = new FinanceReport(report);
        Payment payment4 = new Payment("Alexey", 8,12,2004, 8888);
        report2.setPayment(0, payment4);
        System.out.println(report2);
        System.out.println(report);
        System.out.println(FinanceReportProcessor.surnameSearch(report2, 'K', "Alexey Surname", 7,10,2023));
        System.out.println(FinanceReportProcessor.getLittlePayments(report2, 8888, "Alexey Minimum", 7,10,2023));
    }
}


