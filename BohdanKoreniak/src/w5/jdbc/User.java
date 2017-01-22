package w5.jdbc;

/**
 * Created by Bohdan on 21.01.2017.
 */
public class User
{
    private Integer id;

    private String login;
    private String password;

    private String name;
    private String surname;

    public User(Integer id, String login, String password, String name, String surname)
    {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId()
    {
        return id;
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }
}
