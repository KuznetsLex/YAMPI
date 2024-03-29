package org.kuzne.labs.lab6;

import java.util.*;

public class CollectionsDemo {
    public static int strFirstChar(List<String> list, char template) {
        int count = 0;
        for (String string : list) {
            if (string.charAt(0) == template) { count++; }
        }
        return count;
    }

    public static List<Set<Integer>> setsWithoutIntersection(List<Set<Integer>> listOfSets,
                                                                      Set<Integer> templateSet) {
        List<Set<Integer>> setWithoutIntersection = new ArrayList<>();
        for (Set<Integer> set : listOfSets) {
            if (Collections.disjoint(set, templateSet)) {
                setWithoutIntersection.add(set);
            }
        }
        return setWithoutIntersection;
    }

    public static Set<Human> peopleIdentifiersFilter(Map<Integer, Human> numbersToPeopleMap, Set<Integer> identifiersSet) {
        Set<Human> peopleWithTemplateIdentifiers = new HashSet<>();
        for (Integer key : numbersToPeopleMap.keySet()) {
            if (identifiersSet.contains(key)) {
                peopleWithTemplateIdentifiers.add(numbersToPeopleMap.get(key));
            }
        }
        return peopleWithTemplateIdentifiers;
    }

    public static List<Integer> identifiersOfPeople18Plus(Map<Integer, Human> numbersToPeopleMap) {
        List<Integer> identifiersOfPeople18Plus = new ArrayList<>();
        for (Integer key : numbersToPeopleMap.keySet()) {
            if (numbersToPeopleMap.get(key).getAge() >= 18) {
                identifiersOfPeople18Plus.add(key);
            }
        }
        return identifiersOfPeople18Plus;
    }

    public static Map<Integer, Integer> mapIdToAge(Map<Integer, Human> numbersToPeopleMap) {
        Map<Integer, Integer> mapIdToAge = new HashMap<>();
        for (Integer key : numbersToPeopleMap.keySet()) {
            mapIdToAge.put(key, numbersToPeopleMap.get(key).getAge());
        }
        return mapIdToAge;
    }

    public static Map<Integer, List<Human>> mapAgeToPeople(Set<Human> setOfPeople) {
        Map<Integer, List<Human>> mapAgeToPeople = new HashMap<>();
        for (Human human : setOfPeople) {
            if (mapAgeToPeople.containsKey(human.getAge())) {
                mapAgeToPeople.get(human.getAge()).add(human);
            } else {
                List<Human> listOfThisAge = new ArrayList<>();
                listOfThisAge.add(human);
                mapAgeToPeople.put(human.getAge(), listOfThisAge);
            }
        }
        return mapAgeToPeople;
    }
}
