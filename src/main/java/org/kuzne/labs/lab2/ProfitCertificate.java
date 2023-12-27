package org.kuzne.labs.lab2;

public class ProfitCertificate {
    private final int year;
    private final String citizen;
    private final String organisation;
    private final double[] profitsArray;

    public ProfitCertificate(int year, String citizen, String organisation, double[] profitsArray) {
        this.year = year;
        this.citizen = citizen;
        this.organisation = organisation;
        this.profitsArray = profitsArray;
    }

    public int getYear() {
        return year;
    }

    public String getCitizen() {
        return citizen;
    }

    public String getOrganisation() {
        return organisation;
    }

    public double[] getProfitsArray() {
        return profitsArray;
    }
}
