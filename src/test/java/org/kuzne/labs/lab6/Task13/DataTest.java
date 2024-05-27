package org.kuzne.labs.lab6.Task13;

import org.junit.jupiter.api.Test;
import org.kuzne.labs.lab6.task13.Data;
import org.kuzne.labs.lab6.task13.Group;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @Test
    void iterator1() {
        Group group1 = new Group(1, 1, 2, 3);
        Group group2 = new Group(2, 4, 5, 6);
        Data data = new Data("Test Data", group1, group2);

        Iterator<Integer> iterator = data.iterator();

        assertTrue(iterator.hasNext());

    }
    @Test
    void iterator2() {
        Group group1 = new Group(1, 1, 2, 3);
        Group group2 = new Group(2, 4, 5, 6);
        Data data = new Data("Test Data", group1, group2);

        Iterator<Integer> iterator = data.iterator();

        assertEquals(1, iterator.next());

    }
    @Test
    void iterator3() {
        Group group1 = new Group(1, 1, 2);
        Data data = new Data("Test Data", group1);

        Iterator<Integer> iterator = data.iterator();

        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());

    }
}