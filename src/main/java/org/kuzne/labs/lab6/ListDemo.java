package org.kuzne.labs.lab6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListDemo {
    public static List<Human> sameSurnameFilter(List<Human> originList, Human template) {
        List<Human> sameSurnameList = new ArrayList<>();
        for (Human human : originList) {
            if (human.getSurname().equals(template.getSurname())
                    || (human.getSurname() + "a").equals(template.getSurname())
                    || human.getSurname().equals((template.getSurname() + "a"))) {
                sameSurnameList.add(human);
            }
        }
        return sameSurnameList;
    }

    public static List<Human> excludeFromList(List<Human> originList, Human template) {
        List<Human> excludedTemplateList = new ArrayList<>();
        for (Human human : originList) {
            if (!human.equals(template)) {
                excludedTemplateList.add(human);
            }
        }
        return excludedTemplateList;
    }

    public static <T extends Human> Set<T> maxAge(List<T> setOfPeople) {
        Set<T> maxAgeSet = new HashSet<>();
        int maxAge = 0;
        for (T human : setOfPeople) {
            if (human.getAge() > maxAge) {
                maxAge = human.getAge();
            }
        }
        for (T human : setOfPeople) {
            if (human.getAge() == maxAge) {
                maxAgeSet.add(human);
            }
        }
        return maxAgeSet;
    }
}
