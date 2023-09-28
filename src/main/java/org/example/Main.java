package org.example;
public class Main {
    public static void main(String[] args){
//        Работа со строками
        String s1 = "ало ";
        System.out.println(StringProcessor.copy(s1,3));
        System.out.println(StringProcessor.insertionsCount("abaa", "aa"));
        String s2 = "1 баран, 2 барана, 3 барана, 4 барана";
        System.out.println(StringProcessor.numbersToText(s2));
        StringBuilder s3 = new StringBuilder("123456789");
        System.out.println(StringProcessor.deleteEverySecond(s3));
    }
}


