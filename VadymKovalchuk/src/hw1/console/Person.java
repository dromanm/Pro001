package hw1.console;

import java.io.Serializable;

/**
 * Created by eriol4ik on 17/12/2016.
 */
public class Person implements Serializable {
    private String name;
    private String surname;
    private Integer age;
    private String date;

    public Person(String name, String firstName, int age, String date) {
        this.name = name;
        this.surname = firstName;
        this.age = age;
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", " +
                "surname: " + surname + ", " +
                "age: " + age + ", " +
                "Date of birth: " + date + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return name.equals(person.getName()) &&
               surname.equals(person.getSurname()) &&
               age == person.getAge() &&
               date.equals(person.getDate());
    }

    @Override
    public int hashCode() {
        return name.hashCode() *
                surname.hashCode() *
                age.hashCode() *
                date.hashCode() * 31;
    }
}
