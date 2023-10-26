package org.kuzne.labs.lab3;

public class WithoutNumbersStringFilter implements Filter {

    public boolean apply(String string) {
        return !(string.contains("0") ||
                string.contains("1") ||
                string.contains("2") ||
                string.contains("3") ||
                string.contains("4") ||
                string.contains("5") ||
                string.contains("6") ||
                string.contains("7") ||
                string.contains("8") ||
                string.contains("9"));
    }
}
