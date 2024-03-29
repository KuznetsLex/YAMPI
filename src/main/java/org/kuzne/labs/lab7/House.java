package org.kuzne.labs.lab7;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class House implements Serializable {
    @JsonProperty("cadastralNumber")
    private int cadastralNumber;
    @JsonProperty("adress")
    private String adress;
    @JsonProperty("houseElder")
    private Person houseElder;
    @JsonProperty("flatList")
    private ArrayList<Flat> flatList;

    public House() {
    }

    public House(int cadastralNumber, String adress, Person houseElder, ArrayList<Flat> flatList) {
        this.cadastralNumber = cadastralNumber;
        this.adress = adress;
        this.houseElder = houseElder;
        this.flatList = flatList;
    }

    public int getCadastralNumber() {
        return cadastralNumber;
    }

    public String getAdress() {
        return adress;
    }

    public Person getHouseElder() {
        return houseElder;
    }

    public ArrayList<Flat> getFlatList() {
        return flatList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return cadastralNumber == house.cadastralNumber && Objects.equals(adress, house.adress) && Objects.equals(houseElder, house.houseElder) && Objects.equals(flatList, house.flatList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadastralNumber, adress, houseElder, flatList);
    }

    @Override
    public String toString() {
        return "House{" +
                "cadastralNumber=" + cadastralNumber +
                ", adress='" + adress + '\'' +
                ", houseElder=" + houseElder +
                ", flatList=" + flatList +
                '}';
    }
}
