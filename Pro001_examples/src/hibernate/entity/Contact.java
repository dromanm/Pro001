package hibernate.entity;

/**
 * Created by IEvgen Boldyr on 29.01.17.
 */

/*Шаблон POJO (Plan Old Java Object)*/
public class Contact {

    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;

    /*Для POJO являвляется обязательным*/
    public Contact() {}

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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
