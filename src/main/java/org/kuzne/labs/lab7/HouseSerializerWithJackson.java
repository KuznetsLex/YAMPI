package org.kuzne.labs.lab7;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class HouseSerializerWithJackson {
    public void houseSerialize(House house, String filename) throws IOException {
        Writer writer = new FileWriter(filename, StandardCharsets.UTF_8);
        ObjectMapper mapper= new ObjectMapper();
        mapper.writeValue(writer, house);
        writer.close();
    }

    public House houseDesirialize(String filename) throws IOException {
        Reader reader = new FileReader(filename, StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        House house = (mapper.readValue(reader, House.class));
        reader.close();
        return house;
    }
}
