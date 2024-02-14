package org.kuzne.labs.lab5;

import java.util.ArrayList;

public class CollectionsDemo {
    public static int strFirstChar(ArrayList<String> list, char template) {
        int count = 0;
        for (String string : list) {
            if (string.charAt(0) == template) { count++; }
        }
        return count;
    }

}
