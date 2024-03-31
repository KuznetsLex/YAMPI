package org.kuzne.labs.lab7;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.*;
import java.util.ArrayList;

public class PersonSerializerWithStreamingAPI {
    public static String serialize(Person person) throws IOException {
        JsonFactory factory = new JsonFactory();
        Writer writer = new StringWriter();
        JsonGenerator gen = factory.createGenerator(writer);

        gen.writeStartObject();
        gen.writeStringField("fullName", person.getSurname()+" "+person.getName()+" "+person.getPatronimic());
        gen.writeStringField("birthDate", person.getBirthDate());
        gen.writeEndObject();
        gen.close();
        return writer.toString();
    }

    public static Person deserialize(File file) throws IOException, SampleParserException {

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
        return (new Person(name, surname, patronimic, birthdate));
    }

    static class SampleParserException extends Throwable {
        public SampleParserException(String s) {
        }
    }
}
