package hw2.authentication;

//import java.util.TreeMap;

import java.util.Scanner;

/**
 * Created by JL on 04.01.2017.
 * Задача 3. Аутентификация
 Написать класс аутентификации пользователя по логину и паролю, с методами:
 — boolean authenticate() — ввод логина и пароля + проверка
 — boolean authenticate(String login, String pass)
 — add(String login, String pass)
 — remove(String login)

 Написать модульный тест.

 Класс задания hw2.authentication.Auth
 Класс теста hw2.authentication.AuthTest
 */
public class Auth {
    private String login;
    private String pass;

    TreeMap<String, String> users = new TreeMap<String, String>();


    public boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your login: ");
        String login = scanner.nextLine();
        System.out.println("Enter your password: ");
        String pass = scanner.nextLine();

        return authenticate(login, pass);
    }

    public boolean authenticate(String login, String pass) {
        if (users.get(login) == null) {
            System.out.println("Login hasn't found!");
            return false;
        } else if (users.get(login) != pass) {
            System.out.println("Password is not correct!");
            return false;
        } else {
            System.out.println("Authentication is successful!");
            return true;
        }
    }

    public void add(String login, String pass) {
        users.add(login, pass);
    }

    public void remove(String login) {
        users.remove(login);
    }
}

