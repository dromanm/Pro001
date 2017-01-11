package w2.lesson4.task2;

/**
 * Created by Bohdan on 25.12.2016.
 */
public class Contact
{
    private String name;
    private String surname;

    private Integer age;
    private Integer phone;

    public Contact(String name, String surname, Integer age, Integer phone)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        if (surname != null ? !surname.equals(contact.surname) : contact.surname != null) return false;
        if (age != null ? !age.equals(contact.age) : contact.age != null) return false;
        return phone != null ? phone.equals(contact.phone) : contact.phone == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
