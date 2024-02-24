package org.kuzne.labs.lab6;

import java.util.ArrayList;
import java.util.HashSet;

public class ListDemo {
    public static ArrayList<Human> sameSurnameFilter(ArrayList<Human> originList, Human template) {
        ArrayList<Human> sameSurnameList = new ArrayList<>();
        for (Human human: originList) {
            if (human.getSurname().equals(template.getSurname()) || (human.getSurname()+"a").equals(template.getSurname())
                                                                || human.getSurname().equals((template.getSurname()+"a"))) {
                sameSurnameList.add(human);
            }
        }
        return sameSurnameList;
     }

    public static ArrayList<Human> excludeFromList(ArrayList<Human> originList, Human template) {
        ArrayList<Human> excludedTemplateList = new ArrayList<>();
        for (Human human: originList) {
            if (!human.equals(template)) {
                excludedTemplateList.add(human);
            }
        }
        return excludedTemplateList;
    }

    public static HashSet<Human> maxAge(ArrayList<Human> setOfPeople) {
        HashSet<Human> maxAgeSet = new HashSet<>();
        int maxAge = 0;
        for (Human human : setOfPeople) {
            if (human.getAge() > maxAge) {
                maxAgeSet.clear();
                maxAgeSet.add(human);
                maxAge = human.getAge();
            } else if (human.getAge() == maxAge) {
                maxAgeSet.add(human);
                maxAge = human.getAge();
            }
        }
        return maxAgeSet;
    }
}
