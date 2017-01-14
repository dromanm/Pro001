package lesson04;

/**
 * Created by snx on 12/25/16.
 */
public class Contact {
    private String firstname;
    private String lastname;
    private Integer age;
    private Integer phone;

    public Contact(String firstname, String lastname, Integer age, Integer phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public Integer getAge() {
        return this.age;
    }

    public Integer getPhone() {
        return this.phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (firstname != null ? !firstname.equals(contact.firstname) : contact.firstname != null) return false;
        if (lastname != null ? !lastname.equals(contact.lastname) : contact.lastname != null) return false;
        if (age != null ? !age.equals(contact.age) : contact.age != null) return false;
        return phone != null ? phone.equals(contact.phone) : contact.phone == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
