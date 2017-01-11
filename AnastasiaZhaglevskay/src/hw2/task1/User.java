package hw2.task1;

public class User {

    private String login;
    private String password;
    private String registrationData;
    private Double rating;
    private String sex;

    public User(String login, String password, String registrationData, Double rating, String sex) {
        this.login = login;
        this.password = password;
        this.registrationData = registrationData;
        this.rating = rating;
        this.sex = sex;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRegistrationData() {
        return registrationData;
    }

    public Double getRating() {
        return rating;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (registrationData != null ? !registrationData.equals(user.registrationData) : user.registrationData != null)
            return false;
        if (rating != null ? !rating.equals(user.rating) : user.rating != null) return false;
        return sex != null ? sex.equals(user.sex) : user.sex == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (registrationData != null ? registrationData.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
