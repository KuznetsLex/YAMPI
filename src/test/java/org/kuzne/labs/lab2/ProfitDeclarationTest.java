package org.kuzne.labs.lab2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.kuzne.labs.lab3.ProductPackage;
import org.kuzne.labs.lab3.WeightProduct;
import org.kuzne.labs.lab3.WeightProductsPacked;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProfitDeclarationTest {
    private static ProfitDeclaration declaration1, declaration2;
    @BeforeAll
    static void setUp() {
        double[] profits1 = {100000,200000,300000,400000,500000,600000,700000,800000,900000,1000000,1100000,1200000};
        ProfitCertificate certificate1 = new ProfitCertificate(2024, "Alexey", "ООО Жугдердемидийн Гуррагча", profits1);
        double[] profits2 = {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,11000,12000};
        ProfitCertificate certificate2 = new ProfitCertificate(2024, "Alexey", "ООО Гжегож Бженчишчикевич", profits2);
        declaration1 = new ProfitDeclaration(2024, "Alexey", certificate1, certificate2);

        double[] profits3 = {1200,2350,24000,25000,0,0,0,0,0,0,240000,250000};
        ProfitCertificate certificate3 = new ProfitCertificate(2024, "Alexey", "ООО Армен Джигарханян", profits3);
        declaration2 = new ProfitDeclaration(2024, "Alexey", certificate3);
    }

    @Test
    void getMonthProfits1() {
        assertEquals("[101000.0, 202000.0, 303000.0, 404000.0, 505000.0, 606000.0, 707000.0, 808000.0, 909000.0, 1010000.0, 1111000.0, 1212000.0]", Arrays.toString(declaration1.getMonthProfits()));
    }

    @Test
    void getSumMonthProfits1() {
        assertEquals("[101000.0, 303000.0, 606000.0, 1010000.0, 1515000.0, 2121000.0, 2828000.0, 3636000.0, 4545000.0, 5555000.0, 6666000.0, 7878000.0]", Arrays.toString(declaration1.getSumMonthProfits()));
    }

    @Test
    void getTaxes1() {
        assertEquals("[10010.0, 12600.0, 73200.0, 154000.0, 255000.0, 376200.0, 517600.0, 679200.0, 861000.0, 1063000.0, 1285200.0, 1527600.0]", Arrays.toString(declaration1.getTaxes()));
    }

    @Test
    void getTotalTaxes1() {
        assertEquals(6814610.0, declaration1.totalTaxes());
    }

    @Test
    void getMonthProfits2() {
        assertEquals("[1200.0, 2350.0, 24000.0, 25000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 240000.0, 250000.0]", Arrays.toString(declaration2.getMonthProfits()));
    }

    @Test
    void getSumMonthProfits2() {
        assertEquals("[1200.0, 3550.0, 27550.0, 52550.0, 52550.0, 52550.0, 52550.0, 52550.0, 52550.0, 52550.0, 292550.0, 542550.0]", Arrays.toString(declaration2.getSumMonthProfits()));
    }

    @Test
    void getTaxes2() {
        assertEquals("[0.0, 0.0, 461.5, 3711.5, 3711.5, 3711.5, 3711.5, 3711.5, 3711.5, 3711.5, 10510.0, 60510.0]", Arrays.toString(declaration2.getTaxes()));
    }

    @Test
    void getTotalTaxes2() {
        assertEquals(97462.0, declaration2.totalTaxes());
    }
}