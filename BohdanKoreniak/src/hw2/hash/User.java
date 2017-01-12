package hw2.hash;

import java.time.LocalDate;

/**
 * Created by Bohdan on 09.01.2017.
 */
public class User
{
    private String login;
    private String password;

    private LocalDate registrationDate;

    private Double rating;

    private Boolean gender;

    public User(String login, String password, LocalDate registrationDate, Double rating, Boolean gender)
    {
        this.login = login;
        this.password = password;
        this.registrationDate = registrationDate;
        this.rating = rating;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }

        if (getClass() != obj.getClass())
        {
            return false;
        }

        User user = (User) obj;

        if (!login.equals(user.login))
        {
            return false;
        }

        if (!password.equals(user.password))
        {
            return false;
        }

        if (!registrationDate.equals(user.registrationDate))
        {
            return false;
        }

        if (!rating.equals(user.rating))
        {
            return false;
        }

        if (!gender.equals(user.gender))
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return login.hashCode() * password.hashCode() * registrationDate.hashCode() * rating.hashCode() * gender.hashCode() * 31;
    }
}
