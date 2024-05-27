package org.kuzne.labs.lab9.entities;

import java.util.Objects;

public class Student extends Human {

    private String university;
    private String faculty;
    private String focus;

    public Student(
            String firstName,
            String lastName,
            String patronymic,
            Gender gender,
            int age,
            String university,
            String faculty,
            String focus
    ) {
        super(firstName, lastName, patronymic, gender, age);
        this.university = university;
        this.faculty = faculty;
        this.focus = focus;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Student student = (Student) object;
        return Objects.equals(university, student.university) && Objects.equals(faculty, student.faculty) && Objects.equals(focus, student.focus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university, faculty, focus);
    }

    @Override
    public String toString() {
        return "Student{" +
                "university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", focus='" + focus + '\'' +
                "} " + super.toString();
    }
}
