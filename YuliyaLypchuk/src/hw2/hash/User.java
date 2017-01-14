package hw2.hash;

/**
 * Created by JL on 28.12.2016.
 * Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 Поля класса пользователь:
 1. Логин
 2. Пароль
 3. Дата регистрации
 4. Рейтинг (вещественное число)
 5. Пол
 */


public class User {
    private String login;
    private String password;
    private String dateRegistration;
    private Double rating;
    private String gender;

    public User(String login, String password,
                String dateRegistration, Double rating, String gender) {
        this.login = login;
        this.password = password;
        this.dateRegistration = dateRegistration;
        this.rating = rating;
        this.gender = gender;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDateRegistration() {
        return dateRegistration;
    }

    public Double getRating() {
        return rating;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (dateRegistration != null ? !dateRegistration.equals(user.dateRegistration) : user.dateRegistration != null)
            return false;
        if (rating != null ? !rating.equals(user.rating) : user.rating != null) return false;
        return gender != null ? gender.equals(user.gender) : user.gender == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (dateRegistration != null ? dateRegistration.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}
