package org.kuzne.labs.lab8;

import org.kuzne.labs.lab2.ProfitCertificate;
import org.kuzne.labs.lab2.ProfitDeclaration;
import org.kuzne.labs.lab3.ProductPackage;
import org.kuzne.labs.lab3.WeightProduct;
import org.kuzne.labs.lab3.WeightProductsPacked;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Collections.addAll(
                list,
                new Executable1(),
                new Executable2(),
                new NonExecutable1()
        );
        System.out.println(ReflectionDemo.countImplementations(list));
    }
}
