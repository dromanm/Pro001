package lesson01.task01;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IEvgen Boldyr on 17.12.16.
 */

public class Person implements Serializable {
    private String name;
    private String surname;
    private Integer age;
    private String dateOfBirth;

    public Person(String name, String surname, Integer age, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Integer getAge() {
        return age;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
