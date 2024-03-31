package org.kuzne.labs.lab7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONComparator {
    public static boolean compare(String json1, String json2) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(json1).equals(mapper.readTree(json2));
    }
}
