package lesson01;

/**
 * Created by IEvgen Boldyr on 17.12.16.
 */

public class User {

    private String  login;
    private String  password;
    private Integer year;

    public User(String login, String password, Integer year) {
        this.login = login;
        this.password = password;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() == obj.getClass()) {
            User usr = (User) obj;

            if (!usr.login.equals(login)) return false;
            if (!usr.password.equals(password)) return false;
            if (usr.year.equals(year)) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return login.hashCode()
                * password.hashCode() * year.hashCode();
    }
}
