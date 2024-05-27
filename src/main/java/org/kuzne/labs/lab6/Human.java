package org.kuzne.labs.lab6;

import java.util.Objects;

public class Human {
    private String surname;
    private String name;
    private String fathername;
    private int age;

    public Human(String surname, String name, String fathername, int age) {
        this.surname = surname;
        this.name = name;
        this.fathername = fathername;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getFathername() {
        return fathername;
    }

    public String getFullName() { return surname + " " + name + " " + fathername; }

    public int getAge() {
        return age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(surname, human.surname) && Objects.equals(name, human.name) && Objects.equals(fathername, human.fathername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, fathername, age);
    }
}
