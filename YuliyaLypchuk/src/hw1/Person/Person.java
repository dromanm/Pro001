package hw1.Person;


import java.io.Serializable;

/**
 * Created by JL on 17.12.2016.
 */
public class Person implements Serializable {
    private String name;
    private String surname;
    private int age;
    private String birthDate;

    public Person(String name, String surname, int age, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" Name: " + name + "\n"
                + "Surname: " + surname + "\n"
                + "Age: " + age + "\n"
                + "Birthday: " + birthDate + " ");
        return builder.toString();
    }
}

