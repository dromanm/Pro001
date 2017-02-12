package hiberannotations.enumeration.entity;

import hiberannotations.enumeration.enums.Gender;
import hiberannotations.enumeration.enums.Position;

import javax.persistence.*;

/**
 * Created by IEvgen Boldyr on 12.02.17.
 */

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Position position;

    public Employee() {
    }

    public Employee(String name, Integer age,
                    Gender gender, Position position) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return name + " " + position;
    }
}
