package org.kuzne.labs.lab8;

import org.junit.jupiter.api.Test;
import org.kuzne.labs.lab2.ProfitCertificate;
import org.kuzne.labs.lab2.ProfitDeclaration;
import org.kuzne.labs.lab3.ProductPackage;
import org.kuzne.labs.lab3.WeightProduct;
import org.kuzne.labs.lab3.WeightProductsPacked;
import org.kuzne.labs.lab5.DiagMatrix;
import org.kuzne.labs.lab6.CollectionsDemo;
import org.kuzne.labs.lab6.Human;
import org.kuzne.labs.lab6.Student;
import org.kuzne.labs.lab7.IOStream;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionDemoTest {

    @Test
    void humanTypesCount_1() {
        List<Object> list = new ArrayList<>();
        Human human1 = new Human("Kuznetsov", "Alexey", "Borisovich",30);
        Object nonHuman1 = new Object();
        ProductPackage nonHuman2 = new ProductPackage("Web", 0.02);
        Student human2 = new Student("Derisheva", "Ekaterina", "Maksimovna",19, "FCTK");
        WeightProduct nonHuman3 = new WeightProduct("Oranges", "Oranges in web");
        WeightProduct nonHuman4 = new WeightProduct("Bananas", "Yellow and long in web");
        Collections.addAll(list,
                human1,
                human2,
                nonHuman1,
                nonHuman2,
                nonHuman3,
                nonHuman4
                );
        assertEquals(2, ReflectionDemo.humanTypesCount(list));
    }

    @Test
    void humanTypesCount_2() {
        List<Object> list = new ArrayList<>();
        Object nonHuman1 = new Object();
        ProductPackage nonHuman2 = new ProductPackage("Web", 0.02);
        WeightProduct nonHuman3 = new WeightProduct("Oranges", "Oranges in web");
        WeightProduct nonHuman4 = new WeightProduct("Bananas", "Yellow and long in web");
        Collections.addAll(list,
                nonHuman1,
                nonHuman2,
                nonHuman3,
                nonHuman4
        );
        assertEquals(0, ReflectionDemo.humanTypesCount(list));
    }

    @Test
    void humanTypesCount_3() {
        List<Object> list = new ArrayList<>();
        Human human1 = new Human("Kuznetsov", "Alexey", "Borisovich",30);
        Student human2 = new Student("Derisheva", "Ekaterina", "Maksimovna",19, "FCTK");
        Collections.addAll(list,
                human1,
                human2
        );
        assertEquals(2, ReflectionDemo.humanTypesCount(list));
    }

    @Test
    void getPublicMethods_1() {
        Set<String> expectedList = new HashSet<>();
        Collections.addAll(expectedList,
                "getCertificates",
                "getYear",
                "getMonthProfits",
                "getSumMonthProfits",
                "getCitizen",
                "getTaxes",
                "totalTaxes",
                "equals",
                "toString");
        double[] profits1 = {100000,200000,300000,400000,500000,600000,700000,800000,900000,1000000,1100000,1200000};
        ProfitCertificate certificate1 = new ProfitCertificate(2024, "Alexey", "ООО Жугдердемидийн Гуррагча", profits1);
        double[] profits2 = {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,11000,12000};
        ProfitCertificate certificate2 = new ProfitCertificate(2024, "Alexey", "ООО Гжегож Бженчишчикевич", profits2);
        assertEquals(expectedList, ReflectionDemo.getPublicMethods(new ProfitDeclaration(2024, "Alexey", certificate1, certificate2)));
    }

    @Test
    void getPublicMethods_2() {
        Set<String> expectedList = new HashSet<>();
        Collections.addAll(expectedList,
                "findFiles",
                "writeArrayChar",
                "RandomAccessFileReader",
                "equals",
                "fileExtensionFinder",
                "toString",
                "readArrayBin",
                "readArrayChar",
                "fileAdvancedFinder",
                "writeArrayBin"
                );
        assertEquals(expectedList, ReflectionDemo.getPublicMethods(new IOStream()));
    }

    @Test
    void getPublicMethods_3() {
        Set<String> expectedList = new HashSet<>();
        Collections.addAll(expectedList,
                "strFirstChar",
                "setsWithoutIntersection",
                "peopleIdentifiersFilter",
                "equals",
                "identifiersOfPeople18Plus",
                "mapIdToAge",
                "mapAgeToPeople",
                "toString"
        );
        assertEquals(expectedList, ReflectionDemo.getPublicMethods(new CollectionsDemo()));
    }

    @Test
    void getSuperClasses_1() {
        Set<String> expectedList = new HashSet<>();
        Collections.addAll(
                expectedList,
                "WeightProduct",
                "Product",
                "Object"
        );
        ProductPackage web = new ProductPackage("Web", 0.02);
        WeightProduct oranges = new WeightProduct("Oranges", "Oranges in web");
        assertEquals(expectedList, ReflectionDemo.getSuperClasses(new WeightProductsPacked(oranges, 3.0, web)));
    }

    @Test
    void getSuperClasses_2() {
        Set<String> expectedList = new HashSet<>();
        Collections.addAll(
                expectedList,
                "Matrix",
                "Object"
        );
        ProductPackage web = new ProductPackage("Web", 0.02);
        WeightProduct oranges = new WeightProduct("Oranges", "Oranges in web");
        double[] diagElems = new double[]{1,2,3};
        assertEquals(expectedList, ReflectionDemo.getSuperClasses(new DiagMatrix(diagElems)));
    }

    @Test
    void getSuperClasses_3() {
        Set<String> expectedList = new HashSet<>();
        Collections.addAll(
                expectedList,
                "Human",
                "Object"
        );
        assertEquals(expectedList, ReflectionDemo.getSuperClasses(new Student("Derisheva", "Ekaterina", "Maksimovna",19, "FCTK")));
    }
}