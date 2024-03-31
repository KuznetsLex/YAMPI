package org.kuzne.labs.lab7;

import java.io.*;
import java.time.LocalDateTime;

public class HouseSerializer {
    public static void serializeHouse(House house, String filename) throws IOException {
        try (ObjectOutput out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filename))))
        {
            out.writeObject(house);
        }
    }

    public static House deserializeHouse(String filename) throws IOException, ClassNotFoundException, ClassCastException {
        try(ObjectInput in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename))))
        {
            return (House) in.readObject();
        }
    }
}
