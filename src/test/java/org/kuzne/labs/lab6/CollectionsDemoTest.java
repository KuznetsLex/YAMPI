package org.kuzne.labs.lab6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsDemoTest {
    @Test
    void strFirstChar_1() {
        ArrayList<String> list= new ArrayList<>();
        String string1 = "Call the police!";
        String string2 = "cute dogge";
        String string3 = "Swaaag";
        list.add(string1);
        list.add(string2);
        list.add(string3);
        assertEquals(1, CollectionsDemo.strFirstChar(list, 'c'));
    }

    @Test
    void strFirstChar_2() {
        ArrayList<String> list= new ArrayList<>();
        String string1 = "Call the police!";
        String string2 = "cute dogge";
        String string3 = "Swaaag";
        String string4 = "Slay bestiee";
        list.add(string1);
        list.add(string2);
        list.add(string3);
        list.add(string4);
        assertEquals(2, CollectionsDemo.strFirstChar(list, 'S'));
    }
}