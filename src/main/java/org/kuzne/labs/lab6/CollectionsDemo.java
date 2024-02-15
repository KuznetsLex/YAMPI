package org.kuzne.labs.lab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionsDemo {
    public static int strFirstChar(ArrayList<String> list, char template) {
        int count = 0;
        for (String string : list) {
            if (string.charAt(0) == template) { count++; }
        }
        return count;
    }

    public static ArrayList<HashSet<Integer>> setsWithoutIntersection(ArrayList<HashSet<Integer>> listOfSets,
                                                                      HashSet<Integer> templateSet) {
        ArrayList<HashSet<Integer>> setWithoutIntersection = new ArrayList<>();
        for (HashSet<Integer> set : listOfSets) {
            if (!set.retainAll(templateSet)) {
                setWithoutIntersection.add(set);
            }
        }
        return setWithoutIntersection;
    }

    public static HashSet<Human> peopleIdentifiersFilter(HashMap<Integer, Human> numbersToPeopleMap, HashSet<Integer> identifiersSet) {
        HashSet<Human> peopleWithTemplateIdentifiers = new HashSet<>();
        for (Integer key : numbersToPeopleMap.keySet()) {
            if (identifiersSet.contains(key)) {
                peopleWithTemplateIdentifiers.add(numbersToPeopleMap.get(key));
            }
        }
        return peopleWithTemplateIdentifiers;
    }

    public static ArrayList<Integer> identifiersOfPeople18Plus(HashMap<Integer, Human> numbersToPeopleMap) {
        ArrayList<Integer> identifiersOfPeople18Plus = new ArrayList<>();
        for (Integer key : numbersToPeopleMap.keySet()) {
            if (numbersToPeopleMap.get(key).getAge() > 18) {
                identifiersOfPeople18Plus.add(key);
            }
        }
        return identifiersOfPeople18Plus;
    }

    public static HashMap<Integer, Integer> mapIdToAge(HashMap<Integer, Human> numbersToPeopleMap) {
        HashMap<Integer, Integer> mapIdToAge = new HashMap<>();
        for (Integer key : numbersToPeopleMap.keySet()) {
            mapIdToAge.put(key, numbersToPeopleMap.get(key).getAge());
        }
        return mapIdToAge;
    }

    public static HashMap<Integer, ArrayList<Human>> mapAgeToPeople(HashSet<Human> setOfPeople) {
        HashMap<Integer, ArrayList<Human>> mapAgeToPeople = new HashMap<>();
        for (Human human : setOfPeople) {
            if (mapAgeToPeople.containsKey(human.getAge())) {
                mapAgeToPeople.get(human.getAge()).add(human);
            } else {
                ArrayList<Human> listOfThisAge = new ArrayList<>();
                listOfThisAge.add(human);
                mapAgeToPeople.put(human.getAge(), listOfThisAge);
            }
        }
        return mapAgeToPeople;
    }
}
