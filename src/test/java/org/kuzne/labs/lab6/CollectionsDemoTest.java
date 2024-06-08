package org.kuzne.labs.lab6;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsDemoTest {
    private static ArrayList<String> listForStrFirstChat;
    private static Human human1;
    private static Human human2;
    private static Human human3;
    private static Human human4;

    private static HashMap<Integer, Human> idToPeopleMap;

    @BeforeAll
    static void strFirstChar_setUp() {
        listForStrFirstChat = new ArrayList<>();
        String string1 = "Call the police!";
        String string2 = "cute dogge";
        String string3 = "Swaaag";
        String string4 = "Slay bestiee";
        listForStrFirstChat.add(string1);
        listForStrFirstChat.add(string2);
        listForStrFirstChat.add(string3);
        listForStrFirstChat.add(string4);

        human1 = new Human("Kuznetsov", "Alexey", "Borisovich",30);
        human2 = new Human("Kuznetsova", "Ekaterina", "Maksimovna",30);
        human3 = new Human("Kuznetsov", "Vaiboslav", "Alekseevich",1);
        human4 = new Human("Derisheva", "Ekaterina", "Maksimovna",18);

        idToPeopleMap = new HashMap<>();
        idToPeopleMap.put(0, human1);
        idToPeopleMap.put(1, human2);
        idToPeopleMap.put(2, human3);
        idToPeopleMap.put(3, human4);
    }
    @Test
    void strFirstChar_1() {
        assertEquals(1, CollectionsDemo.strFirstChar(listForStrFirstChat, 'c'));
    }

    @Test
    void strFirstChar_2() {
        assertEquals(2, CollectionsDemo.strFirstChar(listForStrFirstChat, 'S'));
    }

    @Test
    void setsWithoutIntersection_1() {
        Set<Integer> templateSet = new HashSet<>();
        templateSet.add(1);
        templateSet.add(2);
        templateSet.add(3);
        Set<Integer> numberSet1 = new HashSet<>();
        numberSet1.add(3);
        numberSet1.add(4);
        numberSet1.add(5);
        Set<Integer> numberSet2 = new HashSet<>();
        numberSet2.add(4);
        numberSet2.add(5);
        numberSet2.add(6);
        Set<Integer> numberSet3 = new HashSet<>();
        numberSet3.add(7);
        numberSet3.add(8);
        numberSet3.add(9);
        List<Set<Integer>> listOfSets = new ArrayList<>();
        listOfSets.add(numberSet1);
        listOfSets.add(numberSet2);
        listOfSets.add(numberSet3);
        List<Set<Integer>> expectedList = new ArrayList<>();
        expectedList.add(numberSet2);
        expectedList.add(numberSet3);
        assertEquals(expectedList, CollectionsDemo.setsWithoutIntersection(listOfSets, templateSet));
    }

    @Test
    void setsWithoutIntersection_2() {
        HashSet<Integer> templateSet = new HashSet<>();
        templateSet.add(1);
        templateSet.add(2);
        templateSet.add(3);
        HashSet<Integer> numberSet1 = new HashSet<>();
        numberSet1.add(3);
        numberSet1.add(4);
        numberSet1.add(5);
        HashSet<Integer> numberSet2 = new HashSet<>();
        numberSet2.add(2);
        numberSet2.add(3);
        numberSet2.add(4);
        HashSet<Integer> numberSet3 = new HashSet<>();
        numberSet3.add(7);
        numberSet3.add(8);
        numberSet3.add(9);
        ArrayList<Set<Integer>> listOfSets = new ArrayList<>();
        listOfSets.add(numberSet1);
        listOfSets.add(numberSet2);
        listOfSets.add(numberSet3);
        ArrayList<Set<Integer>> expectedList = new ArrayList<>();
        expectedList.add(numberSet3);
        assertEquals(expectedList, CollectionsDemo.setsWithoutIntersection(listOfSets, templateSet));
    }

    @Test
    void setsWithoutIntersection_3() {
        Set<Integer> templateSet = new HashSet<>();
        Set<Integer> numberSet1 = new HashSet<>();
        Set<Integer> numberSet2 = new HashSet<>();
        Set<Integer> numberSet3 = new HashSet<>();
        List<Set<Integer>> listOfSets = new ArrayList<>();
        listOfSets.add(numberSet1);
        listOfSets.add(numberSet2);
        listOfSets.add(numberSet3);
        List<Set<Integer>> expectedList = new ArrayList<>();
        expectedList.add(numberSet1);
        expectedList.add(numberSet2);
        expectedList.add(numberSet3);
        assertEquals(expectedList, CollectionsDemo.setsWithoutIntersection(listOfSets, templateSet));
    }

    @Test
    void peopleIdentifiersFilter_1() {
        Set<Integer> idSet = new HashSet<>();
        idSet.add(0);
        idSet.add(2);
        Set<Human> expectedSet = new HashSet<>();
        expectedSet.add(human1);
        expectedSet.add(human3);
        assertEquals(expectedSet, CollectionsDemo.peopleIdentifiersFilter(idToPeopleMap, idSet));
    }

    @Test
    void peopleIdentifiersFilter_2() {
        Set<Integer> idSet = new HashSet<>();
        idSet.add(0);
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        Set<Human> expectedSet = new HashSet<>();
        expectedSet.add(human1);
        expectedSet.add(human2);
        expectedSet.add(human3);
        expectedSet.add(human4);
        assertEquals(expectedSet, CollectionsDemo.peopleIdentifiersFilter(idToPeopleMap, idSet));
    }

    @Test
    void peopleIdentifiersFilter_3() {
        Set<Integer> idSet = new HashSet<>();
        Set<Human> expectedSet = new HashSet<>();
        assertEquals(expectedSet, CollectionsDemo.peopleIdentifiersFilter(idToPeopleMap, idSet));
    }

    @Test
    void identifiersOfPeople18Plus_1() {
        List<Integer> expectedList= new ArrayList<>();
        expectedList.add(0);
        expectedList.add(1);
        expectedList.add(3);
        assertEquals(expectedList, CollectionsDemo.identifiersOfPeople18Plus(idToPeopleMap));
    }

    @Test
    void identifiersOfPeople18Plus_2() {
        Map<Integer, Human> idToPeopleMap1 = new HashMap<>();
        idToPeopleMap1.put(0, human3);
        List<Integer> expectedList= new ArrayList<>();
        assertEquals(expectedList, CollectionsDemo.identifiersOfPeople18Plus(idToPeopleMap1));
    }

    @Test
    void identifiersOfPeople18Plus_3() {
        Map<Integer, Human> idToPeopleMap2 = new HashMap<>();
        List<Integer> expectedList= new ArrayList<>();
        assertEquals(expectedList, CollectionsDemo.identifiersOfPeople18Plus(idToPeopleMap2));
    }

    @Test
    void mapIdToAge_1() {
        Map<Integer, Integer> expectedMap = new HashMap<>();
        expectedMap.put(0,30);
        expectedMap.put(1,30);
        expectedMap.put(2,1);
        expectedMap.put(3,18);
        assertEquals(expectedMap, CollectionsDemo.mapIdToAge(idToPeopleMap));
    }

    @Test
    void mapIdToAge_2() {
        Map<Integer, Human> idToPeopleMap1 = new HashMap<>();
        idToPeopleMap1.put(0, human3);
        Map<Integer, Integer> expectedMap = new HashMap<>();
        expectedMap.put(0,1);
        assertEquals(expectedMap, CollectionsDemo.mapIdToAge(idToPeopleMap1));
    }

    @Test
    void mapIdToAge_3() {
        Map<Integer, Human> idToPeopleMap2 = new HashMap<>();
        Map<Integer, Integer> expectedMap = new HashMap<>();
        assertEquals(expectedMap, CollectionsDemo.mapIdToAge(idToPeopleMap2));
    }

    @Test
    void mapAgeToPeople_1() {
        human1 = new Human("Kuznetsov", "Alexey", "Borisovich",30);
        human2 = new Human("Kuznetsova", "Ekaterina", "Maksimovna",30);
        human3 = new Human("Kuznetsov", "Vaiboslav", "Alekseevich",1);
        human4 = new Human("Derisheva", "Ekaterina", "Maksimovna",18);

        Set<Human> peopleSet = new HashSet<>();
        peopleSet.add(human1);
        peopleSet.add(human2);
        peopleSet.add(human3);
        peopleSet.add(human4);

        List<Human> listOf30 = new ArrayList<>();
        listOf30.add(human1);
        listOf30.add(human2);
        List<Human> listOf1 = new ArrayList<>();
        listOf1.add(human3);
        List<Human> listOf18 = new ArrayList<>();
        listOf18.add(human4);
        Map<Integer, List<Human>> expectedMap = new HashMap<>();
        expectedMap.put(30, listOf30);
        expectedMap.put(1, listOf1);
        expectedMap.put(18, listOf18);
        assertEquals(expectedMap, CollectionsDemo.mapAgeToPeople(peopleSet));
    }

    @Test
    void mapAgeToPeople_2() {
        Set<Human> peopleSet = new HashSet<>();
        Map<Integer, ArrayList<Human>> expectedMap = new HashMap<>();
        assertEquals(expectedMap, CollectionsDemo.mapAgeToPeople(peopleSet));
    }


    @Test
    void getMapByAgeAndFirstChar1(){
        Human human1 = new Human("Kузнецов", "Алексей", "Борисович", 25);
        Human human2 = new Human("Fдеришева", "Екатерина", "Максимовна", 23);
        Human human3 = new Human("FirstName", "SecondName", "ThirdName", 23);
        Human human4 = new Human("K8", "2", "3", 25);
        Human human5 = new Human("Aлексеев", "Алексей", "Борисович", 25);
        Set<Human> humanSet = new HashSet<>();
        humanSet.add(human1);
        humanSet.add(human2);
        humanSet.add(human3);
        humanSet.add(human4);
        humanSet.add(human5);

        List<Human> human25yoStartsWithA = new ArrayList<>();
        human25yoStartsWithA.add(human5);
        List<Human> human25yoStartsWithK = new ArrayList<>();
        human25yoStartsWithK.add(human4); // пришлось поменять местами эту строчку
        human25yoStartsWithK.add(human1); // и эту

        Map<Character, List<Human>> map25 = new HashMap<>();
        map25.put('K', human25yoStartsWithK);
        map25.put('A', human25yoStartsWithA);

        List<Human> human23yoStartsWithF = new ArrayList<>();
        human23yoStartsWithF.add(human3);
        human23yoStartsWithF.add(human2);

        Map<Character, List<Human>> map23 = new HashMap<>();
        map23.put('F', human23yoStartsWithF);


        Map<Integer, Map<Character, List<Human>>> expectedMap = new HashMap<>();
        expectedMap.put(25, map25);
        expectedMap.put(23, map23);
        assertEquals(expectedMap,CollectionsDemo.getMapByAgeAndFirstChar(humanSet));
    }

}