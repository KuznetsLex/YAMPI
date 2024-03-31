package org.kuzne.labs.lab7;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.*;
import java.util.ArrayList;

public class HouseSerializerWithStreamingAPI {
    public static String serialize(House house) throws IOException {
        JsonFactory factory = new JsonFactory();
        Writer writer = new StringWriter();
        JsonGenerator gen = factory.createGenerator(writer);

        gen.writeStartObject();
        gen.writeNumberField("cadastralNumber", house.getCadastralNumber());
        gen.writeStringField("adress", house.getAdress());
        gen.writeFieldName("houseElder");
        gen.writeString(PersonSerializerWithStreamingAPI.serialize(house.getHouseElder()));
        gen.writeFieldName("flatList");
        gen.writeStartArray();
        for (Flat flat : house.getFlatList()) {
            gen.writeString(FlatSerializerWithStreamingAPI.serialize(flat));
        }
        gen.writeEndArray();
        gen.writeEndObject();
        gen.close();
        return writer.toString();
    }

    public static House deserialize(File file) throws IOException, SampleParserException {

        int cadastralNumber = 0;
        String adress = "";
        Person houseElder = null;
        String name = "";
        String surname = "";
        String patronimic = "";
        String birthdate = "";
        Flat flat = null;
        int number = 0;
        int square = 0;
        ArrayList<Person> owners = null;
        ArrayList<Flat> flatList = null;

        Reader reader = new FileReader(file);
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(reader);

        if (parser.nextToken() != JsonToken.START_OBJECT) {
            throw new SampleParserException("Token { not found");
        }

        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = parser.getCurrentName();
            if ("cadastralNumber".equals(fieldname)) {
                parser.nextToken();
                cadastralNumber = parser.getIntValue();
            } else if ("adress".equals(fieldname)) {
                parser.nextToken();
                adress = parser.getText();
            } else if ("houseElder".equals((fieldname))) {
                if (parser.nextToken() != JsonToken.START_OBJECT) {
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
                houseElder = new Person(name, surname, patronimic, birthdate);
            } else if ("flatList".equals((fieldname))) {
                flatList = new ArrayList<>();
                if (parser.nextToken() != JsonToken.START_ARRAY) {
                    throw new SampleParserException("Token [ not found");
                }
                while (parser.nextToken() != JsonToken.END_ARRAY) {
                    fieldname = parser.getCurrentName();
                    if (parser.nextToken() != JsonToken.START_OBJECT) {
                        throw new SampleParserException("Token { not found");
                    }
                    while (parser.nextToken() != JsonToken.END_OBJECT) {
                        fieldname = parser.getCurrentName();
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
                                fieldname = parser.getCurrentName();
                                if (parser.nextToken() != JsonToken.START_OBJECT) {
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
                    flatList.add(new Flat(number, square, owners));
                }
            } else {
                throw new SampleParserException("Wrong format of json");
            }
        }
        return new House(cadastralNumber, adress, houseElder, flatList);
    }

    static class SampleParserException extends Throwable {
        public SampleParserException(String s) {
        }
    }
}
