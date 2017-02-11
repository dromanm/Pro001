package hiberannotations.hibernate_onetomany.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IEvgen Boldyr on 11.02.17.
 */

@Entity
@Table(name = "CARS")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_id", allocationSize = 25)
    private Long id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "COLOR")
    private String color;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private Set<Driver> drivers;

    public Car() {}

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }
}

