package org.kuzne.labs.lab6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @Test
    void addPhone1() {
        PhoneBook phoneBook = new PhoneBook();
        Human human1 = new Human("Кузнецов", "Алексей", "Борисович", 19);
        phoneBook.addPhone(human1, "+88005553535");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("+88005553535");

        assertEquals(expectedList, phoneBook.getPhoneList(human1));
    }

    @Test
    void removePhone1() {
        PhoneBook phoneBook = new PhoneBook();
        Human human1 = new Human("Кузнецов", "Алексей", "Борисович", 19);
        phoneBook.addPhone(human1, "+88005553535");
        phoneBook.removePhone(human1, "+88005553535");

        List<String> expectedList = new ArrayList<>();

        assertEquals(expectedList, phoneBook.getPhoneList(human1));
    }

    @Test
    void findPersonByPhone1() {
        PhoneBook phoneBook = new PhoneBook();
        Human human1 = new Human("Кузнецов", "Алексей", "Борисович", 19);
        Human human2 = new Human("Деришева", "Екатерина", "Максимовна", 20);
        phoneBook.addPhone(human1, "+88005553535");
        phoneBook.addPhone(human2, "+92332968296");

        assertEquals(human1, phoneBook.findPersonByPhone("+88005553535"));
    }

    @Test
    void findPersonByPhone2() {
        PhoneBook phoneBook = new PhoneBook();
        Human human1 = new Human("Кузнецов", "Алексей", "Борисович", 19);
        Human human2 = new Human("Деришева", "Екатерина", "Максимовна", 20);
        phoneBook.addPhone(human1, "+88005553535");
        phoneBook.addPhone(human2, "+92332968296");
        phoneBook.addPhone(human1, "+93532969029");

        assertEquals(human1, phoneBook.findPersonByPhone("+93532969029"));
    }

    @Test
    void findPeopleByName() {
        PhoneBook phoneBook = new PhoneBook();
        Human human1 = new Human("Кузнецов", "Алексей", "Борисович", 19);
        Human human2 = new Human("Деришева", "Екатерина", "Максимовна", 20);
        phoneBook.addPhone(human1, "88005553535");
        phoneBook.addPhone(human2, "92332968296");
        phoneBook.addPhone(human1, "93532969029");

        List<String> testList = new ArrayList<>();
        testList.add("88005553535");
        testList.add("93532969029");

        Map<Human, List<String>> expectedMap = new HashMap<>();
        expectedMap.put(human1, testList);

        assertEquals(expectedMap, phoneBook.findPeopleByName("Кузнецов"));
    }
}