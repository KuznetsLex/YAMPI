package org.kuzne.labs.lab6.Task13;

import org.junit.jupiter.api.Test;
import org.kuzne.labs.lab6.task13.Group;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    @Test
    void groupConstructor() {
        Group group1 = new Group(100, 1, 2, 3);
        Group group2 = new Group(123, 1, 2, 5, 7, 8, 4, 7, 8);
    }

    @Test
    void groupLength() {
        Group group = new Group(1124, 1, 5, 7, 8, 2, 9);
        assertEquals(6, group.length());
    }
}