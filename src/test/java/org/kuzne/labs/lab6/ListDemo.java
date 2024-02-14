package org.kuzne.labs.lab5;

import java.util.ArrayList;

public class ListDemo {
    ArrayList<Human> sameSurnameFilter(ArrayList<Human> originList, Human template) {
        ArrayList<Human> sameSurnameList = new ArrayList<>();
        for (Human human: originList) {
            if (human.getSurname().equals(template.getSurname())) {
                sameSurnameList.add(human);
            }
        }
        return sameSurnameList;
     }
}
