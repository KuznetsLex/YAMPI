package org.kuzne.labs.lab7;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class IOStreamTest {

    @Test
    void writeArrayBin_1() throws IOException {
        int[] inputArray = { 1, 2, 3 };
        byte[] expect = { 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3 };
        ByteArrayOutputStream out = new ByteArrayOutputStream(inputArray.length);
        IOStream.writeArrayBin(inputArray, out);
        assertArrayEquals(expect, out.toByteArray());
    }

    @Test
    void writeArrayBin_2() throws IOException {
        int[] inputArray = { 1, 2, 3, 12 };
        byte[] expect = { 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 12};
        ByteArrayOutputStream out = new ByteArrayOutputStream(inputArray.length);
        IOStream.writeArrayBin(inputArray, out);
        assertArrayEquals(expect, out.toByteArray());
    }
    @Test
    void writeArrayBin_3() throws IOException {
        int[] inputArray = { };
        byte[] expect = { };
        ByteArrayOutputStream out = new ByteArrayOutputStream(inputArray.length);
        IOStream.writeArrayBin(inputArray, out);
        assertArrayEquals(expect, out.toByteArray());
    }

    @Test
    void readArrayBin_1() throws IOException {
        int[] expect = { 1, 2, 3 };
        byte[] inputArray = { 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3 };
        ByteArrayInputStream in = new ByteArrayInputStream(inputArray);
        assertArrayEquals(expect, IOStream.readArrayBin(3, in));
    }

    @Test
    void readArrayBin_2() throws IOException {
        int[] expect = { 1, 2, 12 };
        byte[] inputArray = { 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 12, 0, 0, 0, 3 };
        ByteArrayInputStream in = new ByteArrayInputStream(inputArray);
        assertArrayEquals(expect, IOStream.readArrayBin(3, in));
    }

    @Test
    void readArrayBin_3() throws IOException {
        int[] expect = {  };
        byte[] inputArray = { };
        ByteArrayInputStream in = new ByteArrayInputStream(inputArray);
        assertArrayEquals(expect, IOStream.readArrayBin(0, in));
    }

    @Test
    void writeArrayChar_1() throws IOException {
        int[] inputArray = { 1, 2, 3 };
        Writer writer = new StringWriter();
        IOStream.writeArrayChar(inputArray, writer);
        assertEquals("1 2 3", writer.toString());
    }

    @Test
    void writeArrayChar_2() throws IOException {
        int[] inputArray = { };
        Writer writer = new StringWriter();
        IOStream.writeArrayChar(inputArray, writer);
        assertEquals("", writer.toString());
    }

    @Test
    void writeArrayChar_3() throws IOException {
        int[] inputArray = { 1, 2, 3, 10, 11, 113 };
        Writer writer = new StringWriter();
        IOStream.writeArrayChar(inputArray, writer);
        assertEquals("1 2 3 10 11 113", writer.toString());
    }

    @Test
    void readArrayChar_1() throws IOException {
        int[] expect = { 1 };
        byte[] inputArray = { 1 };
        File file = new File("src/main/java/org/kuzne/labs/lab7/lab7.txt");
        if (file.delete()) {
            file.createNewFile();
        }
        try (RandomAccessFile fileAccess = new RandomAccessFile(file, "rw");) {
            for(int number : inputArray) {
                fileAccess.write(number);
            }
        }
        Reader in = new BufferedReader(new FileReader(file));
        assertArrayEquals(expect, IOStream.readArrayChar(1, in));
    }

    @Test
    void readArrayChar_2() throws IOException {
        int[] expect = { 1, 2, 5, 10 };
        byte[] inputArray = { 1, 2, 5, 10, 115 };
        File file = new File("src/main/java/org/kuzne/labs/lab7/lab7.txt");
        if (file.delete()) {
            file.createNewFile();
        }
        try (RandomAccessFile fileAccess = new RandomAccessFile(file, "rw");) {
            for(int number : inputArray) {
                fileAccess.write(number);
            }
        }
        Reader in = new BufferedReader(new FileReader(file));
        assertArrayEquals(expect, IOStream.readArrayChar(4, in));
    }

    @Test
    void readArrayChar_3() throws IOException {
        int[] expect = { };
        byte[] inputArray = { };
        File file = new File("src/main/java/org/kuzne/labs/lab7/lab7.txt");
        if (file.delete()) {
            file.createNewFile();
        }
        try (RandomAccessFile fileAccess = new RandomAccessFile(file, "rw");) {
            for(int number : inputArray) {
                fileAccess.write(number);
            }
        }
        Reader in = new BufferedReader(new FileReader(file));
        assertArrayEquals(expect, IOStream.readArrayChar(0, in));
    }

    @Test
    void RandomAccessFileReader_1() throws IOException {
        int[] expect = { 1 };
        int[] inputArray = { 1 };
        File file = new File("src/main/java/org/kuzne/labs/lab7/lab7.txt");
        if (file.delete()) {
            file.createNewFile();
        }
        try (RandomAccessFile fileAccess = new RandomAccessFile(file, "rw");) {
            for(int number : inputArray) {
                fileAccess.write(number);
            }
        }
        assertArrayEquals(expect, IOStream.RandomAccessFileReader(0));
    }

    @Test
    void RandomAccessFileReader_2() throws IOException {
        int[] expect = { 2, 3 };
        int[] inputArray = {1, 2, 3};
        File file = new File("src/main/java/org/kuzne/labs/lab7/lab7.txt");
        if (file.delete()) {
            file.createNewFile();
        }
        try (RandomAccessFile fileAccess = new RandomAccessFile(file, "rw");) {
            for(int number : inputArray) {
                fileAccess.write(number);
            }
        }
        assertArrayEquals(expect, IOStream.RandomAccessFileReader(1));
    }

    @Test
    void RandomAccessFileReader_3() throws IOException {
        int[] expect = { 3 };
        int[] inputArray = {1, 2, 3};
        File file = new File("src/main/java/org/kuzne/labs/lab7/lab7.txt");
        if (file.delete()) {
            file.createNewFile();
        }
        try (RandomAccessFile fileAccess = new RandomAccessFile(file, "rw");) {
            for(int number : inputArray) {
                fileAccess.write(number);
            }
        }
        assertArrayEquals(expect, IOStream.RandomAccessFileReader(2));
    }

    @Test
    void fileExtensionFinder_1() {
        assertArrayEquals(
                new String[]{"CollectionsDemo.java", "ListDemo.java", "Human.java", "Student.java"},
                IOStream.fileExtensionFinder(".java", "src/main/java/org/kuzne/labs/lab6"));
    }

    @Test
    void fileExtensionFinder_2() {
        assertArrayEquals(new String[]{ },
                IOStream.fileExtensionFinder(".cpp", "src"));
    }

    @Test
    void fileExtensionFinder_3() {
        assertArrayEquals(
                new String[]{"test.txt"},
                IOStream.fileExtensionFinder(".txt", "src/main/java/org/kuzne/labs/lab6"));
    }

    @Test
    void fileAdvancedFinder_1() throws IOException {
        Writer in = new FileWriter("src/main/java/org/kuzne/labs/lab7/regexFiles.txt");
        IOStream.fileAdvancedFinder(".java", "src", in);
    }
}