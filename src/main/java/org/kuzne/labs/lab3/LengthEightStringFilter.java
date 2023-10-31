package org.kuzne.labs.lab3;

public class LengthEightStringFilter implements Filter {
    @Override
    public boolean apply(String string) {
        return string.length() == 8;
    }
}
