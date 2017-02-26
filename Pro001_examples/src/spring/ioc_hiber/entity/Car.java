package spring.ioc_hiber.entity;

import javax.persistence.*;

/**
 * Created by IEvgen Boldyr on 19.02.17.
 */

@Entity
@Table(name = "CARS")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "COLOR")
    private String color;

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

    @Override
    public String toString() {
        return "Модель : " + model + " Цвет : " + color;
    }
}
