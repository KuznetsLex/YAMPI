package org.kuzne.labs.lab7;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.*;
import java.util.ArrayList;

public class FlatSerializerWithStreamingAPI {
    public static String serialize(Flat flat) throws IOException {
        JsonFactory factory = new JsonFactory();
        Writer writer = new StringWriter();
        JsonGenerator gen = factory.createGenerator(writer);

        gen.writeStartObject();
        gen.writeNumberField("number", flat.getNumber());
        gen.writeNumberField("square", flat.getSquare());
        gen.writeFieldName("owners");
        gen.writeStartArray();
        for (Person owner : flat.getOwners()) {
            gen.writeRawValue(PersonSerializerWithStreamingAPI.serialize(owner));
        }
        gen.writeEndArray();
        gen.writeEndObject();
        gen.close();
        return writer.toString();
    }

    public static Flat deserialize(File file) throws IOException, SampleParserException {

        int number = 0;
        int square = 0;
        ArrayList<Person> owners = null;
        String name = "";
        String surname = "";
        String patronimic = "";
        String birthdate = "";

        Reader reader = new FileReader(file);
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(reader);

        if (parser.nextToken() != JsonToken.START_OBJECT) {
            throw new SampleParserException("Token { not found");
        }
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = parser.getCurrentName();
            if ("number".equals(fieldname)) {
                parser.nextToken();
                number = parser.getIntValue();
            } else if ("square".equals(fieldname)) {
                parser.nextToken();
                square = parser.getIntValue();
            } else if ("owners".equals(fieldname)) {
                owners = new ArrayList<>();
                if (parser.nextToken() != JsonToken.START_ARRAY) {
                    throw new SampleParserException("Token [ not found");
                }
                while (parser.nextToken() != JsonToken.END_ARRAY) {
                    if (parser.currentToken() != JsonToken.START_OBJECT) {
                        throw new SampleParserException("Token { not found");
                    }
                    while (parser.nextToken() != JsonToken.END_OBJECT) {
                        fieldname = parser.getCurrentName();
                        if ("fullName".equals(fieldname)) {
                            parser.nextToken();
                            String[] fullname = parser.getText().split(" ");
                            surname = fullname[0];
                            name = fullname[1];
                            patronimic = fullname[2];
                        } else if ("birthDate".equals(fieldname)) {
                            parser.nextToken();
                            birthdate = parser.getText();
                        } else {
                            throw new SampleParserException("Wrong format of json");
                        }
                    }
                    owners.add(new Person(name, surname, patronimic, birthdate));
                }
            }
        }
        return new Flat(number, square, owners);
    }


    static class SampleParserException extends Throwable {
        public SampleParserException(String s) {
        }
    }
}
