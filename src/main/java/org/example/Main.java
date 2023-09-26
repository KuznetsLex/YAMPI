package org.example;
public class Main {
    public static void main(String[] args){
//        Работа со строками
//        String s = "ало ";
//        System.out.println(StringProcessor.copy(s,3));
//        System.out.println(StringProcessor.insertionsCount("abaa", "aa"));
        String s = "1 баран, 2 барана, 3 барана, 4 барана";
        System.out.println(StringProcessor.numbersToText(s));
        StringBuilder s1 = new StringBuilder("123456789");
    }
}


