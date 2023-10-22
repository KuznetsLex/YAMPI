package org.kuzne.labs.lab2;

public class StringProcessor {

    public static String copy(String s, int N) throws IllegalArgumentException{
        if (N < 0) {
            throw new IllegalArgumentException("ERROR: Can't multiply string by negative number!");
        }
        String s_copied = "";
        for (int i = 0; i < N; i++) {
            s_copied += s;
        }
        return s_copied;
    }

    public static int insertionsCount(String s1, String s2) throws IllegalArgumentException {
        if (s2 == "" || s2 == null) {
            throw new IllegalArgumentException("ERROR: Substring can't be null or empty!");
        }
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
