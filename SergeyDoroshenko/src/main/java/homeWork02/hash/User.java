package homeWork02.hash;

/**
 * Created by Prigovor on 07.01.2017.
 */
public class User {

    private String login;
    private String password;
    private String registrationDate;
    private Double rating;
    private String sex;

    public User(String login, String password, String registrationDate, Double rating, String sex) {
        this.login = login;
        this.password = password;
        this.registrationDate = registrationDate;
        this.rating = rating;
        this.sex = sex;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getLogin() != null ? !getLogin().equals(user.getLogin()) : user.getLogin() != null) return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getRegistrationDate() != null ? !getRegistrationDate().equals(user.getRegistrationDate()) : user.getRegistrationDate() != null)
            return false;
        if (getRating() != null ? !getRating().equals(user.getRating()) : user.getRating() != null) return false;
        return getSex() != null ? getSex().equals(user.getSex()) : user.getSex() == null;
    }

    @Override
    public int hashCode() {
        int result = getLogin() != null ? getLogin().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getRegistrationDate() != null ? getRegistrationDate().hashCode() : 0);
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        return result;
    }
}