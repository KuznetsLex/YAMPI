package org.kuzne.labs.lab6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ListDemoTest {

    @Test
    void sameSurnameFilter_1() {
        Human human1 = new Human("Kuznetsov", "Alexey", "Borisovich",29);
        Human human2 = new Human("Kuznetsova", "Ekaterina", "Maksimovna",30);
        Human human3 = new Human("Kuznetsov", "Vaiboslav", "Alekseevich",1);
        Human human4 = new Human("Derisheva", "Ekaterina", "Maksimovna",19);
        ArrayList<Human> listOfPeople = new ArrayList<>();
        listOfPeople.add(human2);
        listOfPeople.add(human3);
        listOfPeople.add(human4);
        ArrayList<Human> expectedList = new ArrayList<>();
        expectedList.add(human2);
        expectedList.add(human3);
        assertEquals(expectedList, ListDemo.sameSurnameFilter(listOfPeople,human1));
    }

    @Test
    void sameSurnameFilter_2() {
        Human human1 = new Human("Kuznetsov", "Alexey", "Borisovich",29);
        Human human2 = new Human("Kuznetsova", "Ekaterina", "Maksimovna",30);
        Human human3 = new Human("Kuznetsov", "Vaiboslav", "Alekseevich",1);
        Human human4 = new Human("Derisheva", "Ekaterina", "Maksimovna",19);
        ArrayList<Human> listOfPeople = new ArrayList<>();
        listOfPeople.add(human1);
        listOfPeople.add(human3);
        listOfPeople.add(human4);
        ArrayList<Human> expectedList = new ArrayList<>();
        expectedList.add(human1);
        expectedList.add(human3);
        assertEquals(expectedList, ListDemo.sameSurnameFilter(listOfPeople,human2));
    }

    @Test
    void sameSurnameFilter_3() {
        Human human2 = new Human("Kuznetsova", "Ekaterina", "Maksimovna",30);
        ArrayList<Human> listOfPeople = new ArrayList<>();
        ArrayList<Human> expectedList = new ArrayList<>();
        assertEquals(expectedList, ListDemo.sameSurnameFilter(listOfPeople,human2));
    }

    @Test
    void excludeFromList_1() {
        Human human1 = new Human("Kuznetsov", "Alexey", "Borisovich",29);
        Human human2 = new Human("Kuznetsova", "Ekaterina", "Maksimovna",30);
        Human human3 = new Human("Kuznetsov", "Vaiboslav", "Alekseevich",1);
        Human human4 = new Human("Derisheva", "Ekaterina", "Maksimovna",19);
        ArrayList<Human> listOfPeople = new ArrayList<>();
        listOfPeople.add(human1);
        listOfPeople.add(human2);
        listOfPeople.add(human3);
        listOfPeople.add(human4);
        ArrayList<Human> expectedList = new ArrayList<>();
        expectedList.add(human1);
        expectedList.add(human2);
        expectedList.add(human3);
        assertEquals(expectedList, ListDemo.excludeFromList(listOfPeople,human4));
    }

    @Test
    void excludeFromList_2() {
        Human human1 = new Human("Kuznetsov", "Alexey", "Borisovich",29);
        Human human2 = new Human("Kuznetsova", "Ekaterina", "Maksimovna",30);
        Human human3 = new Human("Kuznetsov", "Vaiboslav", "Alekseevich",1);
        Human human4 = new Human("Derisheva", "Ekaterina", "Maksimovna",19);
        ArrayList<Human> listOfPeople = new ArrayList<>();
        listOfPeople.add(human1);
        listOfPeople.add(human2);
        listOfPeople.add(human3);
        ArrayList<Human> expectedList = new ArrayList<>();
        expectedList.add(human1);
        expectedList.add(human2);
        expectedList.add(human3);
        assertEquals(expectedList, ListDemo.excludeFromList(listOfPeople,human4));
    }

    @Test
    void excludeFromList_3() {
        Human human4 = new Human("Derisheva", "Ekaterina", "Maksimovna",19);
        ArrayList<Human> listOfPeople = new ArrayList<>();
        ArrayList<Human> expectedList = new ArrayList<>();
        assertEquals(expectedList, ListDemo.excludeFromList(listOfPeople,human4));
    }

    @Test
    void maxAge_1() {
        Human human1 = new Human("Kuznetsov", "Alexey", "Borisovich",30);
        Human human2 = new Human("Kuznetsova", "Ekaterina", "Maksimovna",30);
        Human human3 = new Human("Kuznetsov", "Vaiboslav", "Alekseevich",1);
        Student human4 = new Student("Derisheva", "Ekaterina", "Maksimovna",19, "FCTK");
        ArrayList<Human> listOfPeople = new ArrayList<>();
        listOfPeople.add(human1);
        listOfPeople.add(human2);
        listOfPeople.add(human3);
        listOfPeople.add(human4);
        HashSet<Human> expectedSet = new HashSet<>();
        expectedSet.add(human1);
        expectedSet.add(human2);
        assertEquals(expectedSet, ListDemo.maxAge(listOfPeople));
    }

    @Test
    void maxAge_2() {
        Human human1 = new Human("Kuznetsov", "Alexey", "Borisovich",30);
        Human human2 = new Human("Kuznetsova", "Ekaterina", "Maksimovna",30);
        Human human3 = new Human("Kuznetsov", "Vaiboslav", "Alekseevich",1);
        Student human4 = new Student("Derisheva", "Ekaterina", "Maksimovna",19, "FCTK");
        ArrayList<Human> listOfPeople = new ArrayList<>();
        listOfPeople.add(human1);
        listOfPeople.add(human2);
        listOfPeople.add(human3);
        listOfPeople.add(human4);
        HashSet<Human> expectedSet = new HashSet<>();
        expectedSet.add(human1);
        expectedSet.add(human2);
        assertEquals(expectedSet, ListDemo.maxAge(listOfPeople));
    }

    @Test
    void maxAge_3() {
        ArrayList<Human> listOfPeople = new ArrayList<>();
        HashSet<Human> expectedSet = new HashSet<>();
        assertEquals(expectedSet, ListDemo.maxAge(listOfPeople));
    }
}