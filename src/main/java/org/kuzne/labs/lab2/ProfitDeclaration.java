package org.kuzne.labs.lab2;

public class ProfitDeclaration {
    private final int year;
    private final String citizen;
    private final ProfitCertificate[] certificates;
    private double[][] declaration;

    public ProfitDeclaration(int year, String citizen, ProfitCertificate ... certificates) {
        this.year = year;
        this.citizen = citizen;
        this.certificates = certificates;
        this.declaration = new double[12][3];

        double monthProfit;
        for (int i = 0; i < 12; i++) {
            monthProfit = 0;
            for(ProfitCertificate certificate: certificates) {
                monthProfit+= certificate.getProfitsArray()[i];
            }
            declaration[i][0] = monthProfit;
            if (i > 0) { declaration[i][1] = declaration[i-1][1]+monthProfit; } else { declaration[i][1] = monthProfit;}
            if (declaration[i][1] > 24000 && declaration[i][1] < 240000) { declaration[i][2] = (declaration[i][1]-24000)*0.13; }
            if (declaration[i][1] >= 240000) { declaration[i][2] = (declaration[i][1]-240000)*0.2; }
        }
    }

    public int getYear() {
        return year;
    }

    public String getCitizen() {
        return citizen;
    }

    public ProfitCertificate[] getCertificates() {
        return certificates;
    }

    public double[] getMonthProfits() {
        double[] monthProfits = new double[12];
        for (int i = 0; i < 12; i++) {
            monthProfits[i] = declaration[i][0];
        }
        return monthProfits;
    }

    public double[] getSumMonthProfits() {
        double[] sumMonthProfits = new double[12];
        for (int i = 0; i < 12; i++) {
            sumMonthProfits[i] = declaration[i][1];
        }
        return sumMonthProfits;
    }

    public double[] getTaxes() {
        double[] taxes = new double[12];
        for (int i = 0; i < 12; i++) {
            taxes[i] = declaration[i][2];
        }
        return taxes;
    }

    public double totalTaxes() {
        double total = 0;
        for (int i=0; i<12;i++)
            total+=declaration[i][2];
        return total;
    }
}
