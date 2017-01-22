package jdbcgraph.domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by IEvgen Boldyr on 22.01.17.
 */
public class Contact {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty surname;
    private IntegerProperty age;
    private StringProperty email;
    private IntegerProperty phone;

    public Contact(Integer id, String name,
        String surname, Integer age,
                   String email, Integer phone) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.age = new SimpleIntegerProperty(age);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleIntegerProperty(phone);
    }

    public Integer getId() {
        return id.get();
    }
    public String getName() {
        return name.get();
    }
    public String getSurname() {
        return surname.get();
    }
    public Integer getAge() {
        return age.get();
    }
    public String getEmail() {
        return email.get();
    }
    public Integer getPhone() {
        return phone.get();
    }
}
