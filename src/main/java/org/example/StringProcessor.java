package org.example;

public class StringProcessor {

    public static String copy(String s, int N) {
        String s_copied = "";
        for (int i = 0; i < N; i++) {
            s_copied += s;
        }
        return s_copied;
    }

    public static int insertionsCount(String s1, String s2) {
        boolean isInside;
        int insertionsCount = 0;
        for (int i = 0; i < s1.length() - s2.length() + 1; i++) {
            isInside = true;
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i+j) != s2.charAt(j)) {
                    isInside = false;
                }
            }
            if (isInside) {
                insertionsCount++;
            }
        }
        return insertionsCount;
    }

    public static String numbersToText(String s) {
        s = s.replace("1","один");
        s = s.replace("2", "два");
        s = s.replace("3", "три");
        return s;
    }

    public static StringBuilder deleteEverySecond(StringBuilder s) {
        for (int i = 1; i < s.length(); i++) {
            s.deleteCharAt(i);
        }
        return s;
    }
}
