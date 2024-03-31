package org.kuzne.labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException, FlatSerializerWithStreamingAPI.SampleParserException {
        Person person1 = new Person("name1", "surname1", "patronimic1", "01.01.2024");
        Person person2 = new Person("name2", "surname2", "patronimic2", "02.01.2024");
        ArrayList<Person> flat1Owners = new ArrayList<>();
        Collections.addAll(flat1Owners, person1, person2);
        Flat flat1 = new Flat(1, 100, flat1Owners);
        File file = new File("src/main/java/org/kuzne/labs/lab7/FlatStreamAPI.txt");
        try (PrintWriter out = new PrintWriter("src/main/java/org/kuzne/labs/lab7/FlatStreamAPI.txt")) {
            out.println(FlatSerializerWithStreamingAPI.serialize(flat1));
        }
        System.out.println(FlatSerializerWithStreamingAPI.deserialize(file));
    }
}
