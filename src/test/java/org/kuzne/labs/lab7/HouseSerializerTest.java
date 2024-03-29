package org.kuzne.labs.lab7;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class HouseSerializerTest {
    @Test
    void serializeHouse_1() throws IOException, ClassNotFoundException {
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

        HouseSerializer houseSerializer = new HouseSerializer();
        houseSerializer.serializeHouse(house, "src/main/java/org/kuzne/labs/lab7/House.txt");
        assertEquals(house, houseSerializer.deserializeHouse("src/main/java/org/kuzne/labs/lab7/House.txt"));
    }

    @Test
    void serializeHouse_2() throws IOException, ClassNotFoundException {
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



        HouseSerializerWithJackson houseJacksonSerializer = new HouseSerializerWithJackson();
        houseJacksonSerializer.houseSerialize(house, "src/main/java/org/kuzne/labs/lab7/House.txt");

        System.out.println( houseJacksonSerializer.houseDesirialize("src/main/java/org/kuzne/labs/lab7/House.txt").toString());
        assertEquals(house.toString(), houseJacksonSerializer.houseDesirialize("src/main/java/org/kuzne/labs/lab7/House.txt").toString());
//        assertEquals(1, -1);
    }
}