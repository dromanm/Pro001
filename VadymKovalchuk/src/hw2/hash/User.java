package hw2.hash;

import com.sun.istack.internal.NotNull;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Created by eriol4ik on 26/12/2016.
 */
public class User {
    @NotNull private String login;
    private char[] password;
    private LocalDate signUpDate;
    private Double rating;
    private Boolean male; // true: male, false: female

    public User(String login, char[] password, double rating, boolean male) {
        if (login == null) throw new IllegalArgumentException("login cannot be null");
        this.login = login;
        if (password == null) throw new IllegalArgumentException("password cannot be null");
        this.password = password;
        this.signUpDate = LocalDate.now();
        this.rating = rating;
        this.male = male;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;
        if (!login.equals(user.login)) return false;
        if (!Arrays.equals(password, user.password)) return false;
        if (!signUpDate.equals(user.signUpDate)) return false;
        if (rating.compareTo(user.rating) != 0) return false;

        return this.male == user.male;
    }

    @Override
    public int hashCode() {
        int hash = login.hashCode();
        hash = hash * 31 + Arrays.hashCode(password);
        hash = hash * 31 + signUpDate.hashCode();
        hash = hash * 31 + rating.hashCode();

        return hash * 31 + male.hashCode();
    }
}
