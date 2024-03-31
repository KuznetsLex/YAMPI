package org.kuzne.labs.lab7;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class JSONComparatorTest {

    @Test
    void compare_1() throws IOException {
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

        ArrayList<Person> flat1Owners2 = new ArrayList<>();
        Collections.addAll(flat1Owners2, person2, person1);
        ArrayList<Person> flat2Owners2 = new ArrayList<>();
        Collections.addAll(flat2Owners2, person3);
        Flat flat12 = new Flat(1, 100, flat1Owners2);
        Flat flat22 = new Flat(2, 200, flat2Owners2);
        ArrayList<Flat> flats2 = new ArrayList<>();
        Collections.addAll(flats2, flat22, flat12);
        House house2 = new House(644121, "Mira 55A", person1, flats2);

        HouseSerializerWithJackson.houseSerialize(house, "src/main/java/org/kuzne/labs/lab7/HouseJackson1.txt");
        String contentJackson1 = Files.readString(Paths.get("src/main/java/org/kuzne/labs/lab7/HouseJackson1.txt"), StandardCharsets.UTF_8);
        HouseSerializerWithJackson.houseSerialize(house2, "src/main/java/org/kuzne/labs/lab7/HouseJackson2.txt");
        String contentJackson2 = Files.readString(Paths.get("src/main/java/org/kuzne/labs/lab7/HouseJackson2.txt"), StandardCharsets.UTF_8);
        assertNotEquals(contentJackson1, contentJackson2);
    }

    @Test
    void compare_2() throws IOException {
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

        HouseSerializerWithJackson.houseSerialize(house, "src/main/java/org/kuzne/labs/lab7/HouseJackson1.txt");
        String contentJackson1 = Files.readString(Paths.get("src/main/java/org/kuzne/labs/lab7/HouseJackson1.txt"), StandardCharsets.UTF_8);
        HouseSerializerWithJackson.houseSerialize(house, "src/main/java/org/kuzne/labs/lab7/HouseJackson2.txt");
        String contentJackson2 = Files.readString(Paths.get("src/main/java/org/kuzne/labs/lab7/HouseJackson2.txt"), StandardCharsets.UTF_8);
        assertEquals(contentJackson1, contentJackson2);
    }
}