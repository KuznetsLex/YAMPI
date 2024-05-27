package org.kuzne.labs.lab6.Task13;

import org.junit.jupiter.api.Test;
import org.kuzne.labs.lab6.task13.Data;
import org.kuzne.labs.lab6.task13.DataDemo;
import org.kuzne.labs.lab6.task13.Group;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataDemoTest {

    @Test
    void getAll1() {
        Group group1 = new Group(1, 1, 2, 3);
        Group group2 = new Group(2, 4, 5, 6);
        Data data = new Data("Test Data", group1, group2);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actual = DataDemo.getAll(data);

        assertEquals(expected, actual);
    }
    @Test
    void getAll2(){
        Data data = new Data("Empty Data");

        List<Integer> expected = Arrays.asList();
        List<Integer> actual = DataDemo.getAll(data);

        assertEquals(expected, actual);
    }
    @Test
    void getAll3(){
        Group group = new Group(1, 1, 2, 3);
        Data data = new Data("Single Group Data", group);

        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = DataDemo.getAll(data);

        assertEquals(expected, actual);
    }
}