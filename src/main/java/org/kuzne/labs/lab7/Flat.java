package org.kuzne.labs.lab7;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Flat implements Serializable {
    @JsonProperty("number")
    private int number;
    @JsonProperty("square")
    private int square;
    @JsonProperty("owners")
    private ArrayList<Person> owners;

    public Flat() {
    }

    public Flat(int number, int square, ArrayList<Person> owners) {
        this.number = number;
        this.square = square;
        this.owners = owners;
    }

    public int getNumber() {
        return number;
    }

    public int getSquare() {
        return square;
    }

    public ArrayList<Person> getOwners() {
        return owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number && square == flat.square && Objects.equals(owners, flat.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, square, owners);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", square=" + square +
                ", owners=" + owners +
                '}';
    }
}
