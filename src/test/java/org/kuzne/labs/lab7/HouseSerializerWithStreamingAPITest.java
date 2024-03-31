package org.kuzne.labs.lab7;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class HouseSerializerWithStreamingAPITest {
    @Test
    void serialize_1() throws IOException {
        Person person1 = new Person("name1", "surname1", "patronimic1", "01.01.2024");
        System.out.println(PersonSerializerWithStreamingAPI.serialize(person1));
    }

    @Test
    void serialize_2() throws IOException {
        Person person1 = new Person("name1", "surname1", "patronimic1", "01.01.2024");
        Person person2 = new Person("name2", "surname2", "patronimic2", "02.01.2024");
        ArrayList<Person> flat1Owners = new ArrayList<>();
        Collections.addAll(flat1Owners, person1, person2);
        Flat flat1 = new Flat(1, 100, flat1Owners);
        System.out.println(FlatSerializerWithStreamingAPI.serialize(flat1));
    }

    @Test
    void serialize_3() throws IOException {
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
        System.out.println(HouseSerializerWithStreamingAPI.serialize(house));
    }

    @Test
    void deserialize_1() throws IOException, PersonSerializerWithStreamingAPI.SampleParserException {
        Person person1 = new Person("name1", "surname1", "patronimic1", "01.01.2024");
        File file = new File("src/main/java/org/kuzne/labs/lab7/PersonStreamAPI.txt");
        try (PrintWriter out = new PrintWriter("src/main/java/org/kuzne/labs/lab7/PersonStreamAPI.txt")) {
            out.println(PersonSerializerWithStreamingAPI.serialize(person1));
        }
        assertEquals(person1, PersonSerializerWithStreamingAPI.deserialize(file));
    }

//    @Test
//    void deserialize_2() throws FlatSerializerWithStreamingAPI.SampleParserException, IOException {
//        Person person1 = new Person("name1", "surname1", "patronimic1", "01.01.2024");
//        Person person2 = new Person("name2", "surname2", "patronimic2", "02.01.2024");
//        ArrayList<Person> flat1Owners = new ArrayList<>();
//        Collections.addAll(flat1Owners, person1, person2);
//        Flat flat1 = new Flat(1, 100, flat1Owners);
//        File file = new File("src/main/java/org/kuzne/labs/lab7/FlatStreamAPI.txt");
//        try (PrintWriter out = new PrintWriter("src/main/java/org/kuzne/labs/lab7/FlatStreamAPI.txt")) {
//            out.println(FlatSerializerWithStreamingAPI.serialize(flat1));
//        }
//        assertEquals(flat1, FlatSerializerWithStreamingAPI.deserialize(file));
//    }

//    @Test
//    void deserialize_3() throws IOException, HouseSerializerWithStreamingAPI.SampleParserException {
//        Person person1 = new Person("name1", "surname1", "patronimic1", "01.01.2024");
//        Person person2 = new Person("name2", "surname2", "patronimic2", "02.01.2024");
//        Person person3 = new Person("name3", "surname3", "patronimic3", "03.01.2024");
//        ArrayList<Person> flat1Owners = new ArrayList<>();
//        Collections.addAll(flat1Owners, person1, person2);
//        ArrayList<Person> flat2Owners = new ArrayList<>();
//        Collections.addAll(flat2Owners, person3);
//        Flat flat1 = new Flat(1, 100, flat1Owners);
//        Flat flat2 = new Flat(2, 200, flat2Owners);
//        ArrayList<Flat> flats = new ArrayList<>();
//        Collections.addAll(flats, flat1, flat2);
//        House house = new House(644121, "Mira 55A", person1, flats);
//
//        File file = new File("src/main/java/org/kuzne/labs/lab7/HouseStreamAPI.txt");
//        try (PrintWriter out = new PrintWriter("src/main/java/org/kuzne/labs/lab7/HouseStreamAPI.txt")) {
//            out.println(HouseSerializerWithStreamingAPI.serialize(house));
//        }
////        assertEquals(house, HouseSerializerWithStreamingAPI.deserialize(file));
//    }
}