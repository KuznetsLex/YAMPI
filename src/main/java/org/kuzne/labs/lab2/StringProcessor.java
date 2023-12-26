package org.kuzne.labs.lab2;

import java.util.ArrayList;
import java.util.Arrays;

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

    public static String reverseString(String s) {
        ArrayList<Integer> spaceArr = new ArrayList<>();
        int count = 0;
        int i;

        String sReversed = new StringBuilder(s).reverse().toString();
        ArrayList<String> parts = new ArrayList<>();
        StringBuilder subString = new StringBuilder();
        for (i = 0; i < s.length(); i++) {
            if (sReversed.charAt(i) != ' ') { subString.append(sReversed.charAt(i)); }
            if ((sReversed.charAt(i) == ' ' || i+1==s.length()) && !subString.isEmpty()) {
                parts.add(subString.toString());
                subString = new StringBuilder();;
            }
        }

        if (s.charAt(0) != ' ') spaceArr.add(0);
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            } if (s.charAt(i) != ' ' || i==s.length()-1) {
                if (count > 0) { spaceArr.add(count); }
                count = 0;
            }
        }
        if (s.charAt(i-1) != ' ') spaceArr.add(0);

        StringBuilder ans = new StringBuilder();
        for (i=0; i < spaceArr.size();i++) {
            for (int j=0; j<spaceArr.get(i);j++) {
                ans.append(' ');
            }
            if (i < parts.size()) ans.append(parts.get(i));
        }
        return ans.toString();
    }

    public static String hexToDecimal(String s) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<words.length; i++) {
            if (words[i].charAt(0) == '0' && words[i].charAt(1) == 'x') {
                String hex = words[i].substring(2);
                words[i] = String.valueOf(Integer.parseInt(hex, 16));
            }
        }
        for (String word: words) {
            ans.append(word);
            ans.append(" ");
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
}
