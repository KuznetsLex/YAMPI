package org.kuzne.labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException, FlatSerializerWithStreamingAPI.SampleParserException, HouseSerializerWithStreamingAPI.SampleParserException {
        Person person1 = new Person("name1", "surname1", "patronimic1", "01.01.2024");
        Person person2 = new Person("name2", "surname2", "patronimic2", "02.01.2024");
        Person person3 = new Person("name3", "surname3", "patronimic3", "03.01.2024");
        ArrayList<Person> flat1Owners = new ArrayList<>();
        Collections.addAll(flat1Owners, person1, person2);
        ArrayList<Person> flat2Owners = new ArrayList<>();
        Collections.addAll(flat2Owners, person3);
        Flat flat1 = new Flat(1, 100, flat1Owners);
        Flat flat2 = new Flat(2, 200, flat2Owners);
        ArrayList<Flat> flats = new ArrayList<>();
        Collections.addAll(flats, flat1, flat2);
        House house = new House(644121, "Mira 55A", person1, flats);

        File file = new File("src/main/java/org/kuzne/labs/lab7/HouseStreamAPI.txt");
        try (PrintWriter out = new PrintWriter("src/main/java/org/kuzne/labs/lab7/HouseStreamAPI.txt")) {
            out.println(HouseSerializerWithStreamingAPI.serialize(house));
        }
        System.out.println(HouseSerializerWithStreamingAPI.deserialize(file));
    }
}
