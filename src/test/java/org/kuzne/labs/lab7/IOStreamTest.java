package org.kuzne.labs.lab7;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class IOStreamTest {

    @Test
    void writeArrayBin_1() throws IOException {
        byte[] inputArray = { 1, 2, 3 };
        ByteArrayOutputStream out = new ByteArrayOutputStream(inputArray.length);
        IOStream.writeArrayBin(inputArray, out);
        assertArrayEquals(inputArray, out.toByteArray());
    }

    @Test
    void writeArrayBin_2() throws IOException {
        byte[] inputArray = { 1, 2, 3, 4 };
        ByteArrayOutputStream out = new ByteArrayOutputStream(inputArray.length);
        IOStream.writeArrayBin(inputArray, out);
        assertArrayEquals(inputArray, out.toByteArray());
    }

    @Test
    void writeArrayBin_3() throws IOException {
        byte[] inputArray = { };
        ByteArrayOutputStream out = new ByteArrayOutputStream(inputArray.length);
        IOStream.writeArrayBin(inputArray, out);
        assertArrayEquals(inputArray, out.toByteArray());
    }

    @Test
    void readArrayBin_1() throws IOException {
        byte[] inputArray = { 1, 2, 3 };
        byte[] expectedArray = { 1, 2 };
        ByteArrayInputStream in = new ByteArrayInputStream(inputArray);
        assertArrayEquals(expectedArray, IOStream.readArrayBin(2, in));
    }

    @Test
    void readArrayBin_2() throws IOException {
        byte[] inputArray = { 1, 2, 3 };
        byte[] expectedArray = { };
        ByteArrayInputStream in = new ByteArrayInputStream(inputArray);
        assertArrayEquals(expectedArray, IOStream.readArrayBin(0, in));
    }

    @Test
    void readArrayBin_3() throws IOException {
        byte[] inputArray = { 1, 2, 3 };
        byte[] expectedArray = { 1, 2, 3 };
        ByteArrayInputStream in = new ByteArrayInputStream(inputArray);
        assertArrayEquals(expectedArray, IOStream.readArrayBin(3, in));
    }
}