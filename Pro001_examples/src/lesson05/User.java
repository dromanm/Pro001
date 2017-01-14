package lesson05;

import java.io.Serializable;

/**
 * Created by IEvgen Boldyr on 14.01.17.
 */
public class User extends BasicUser implements BaseUser, Serializable, Comparable {

    public String pubStr = "pub";
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean setNewLoginAndPassword(
            String login, String password) {
        this.login    = login;
        this.password = password;
        return true;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }

    public int compareTo(Object o) {
        return 0;
    }
}
