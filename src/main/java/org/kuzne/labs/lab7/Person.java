package org.kuzne.labs.lab7;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("patronimic")
    private String patronimic;
    @JsonProperty("birthDate")
    private String birthDate;

    public Person() {
    }

    public Person(String name, String surname, String patronimic, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.patronimic = patronimic;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronimic() {
        return patronimic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(patronimic, person.patronimic) && Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronimic, birthDate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronimic='" + patronimic + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
