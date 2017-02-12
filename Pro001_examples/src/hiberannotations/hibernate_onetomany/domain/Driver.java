package hiberannotations.hibernate_onetomany.domain;

import javax.persistence.*;

/**
 * Created by IEvgen Boldyr on 11.02.17.
 */

@Entity
@Table(name = "DRIVERS")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_seq")
    @SequenceGenerator(name = "driver_seq", sequenceName = "driver_id", allocationSize = 10)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Car car;

    public Driver() {}

    public Driver(String name, String surname, Car car) {
        this.name = name;
        this.surname = surname;
        this.car = car;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}


