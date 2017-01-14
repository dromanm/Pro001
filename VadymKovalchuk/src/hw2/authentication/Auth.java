package hw2.authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by eriol4ik on 12/01/2017.
 */
public class Auth {
    Map<String, String> accounts;

    public Auth() {
        accounts = new HashMap<>();
    }

    boolean authenticate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String login = br.readLine();
        String pass = br.readLine();

        return authenticate(login, pass);
    }

    boolean authenticate(String login, String pass) {
        if (login == null || pass == null) return false;

        String realPass = accounts.get(login);
        if (realPass == null) return false;

        return realPass.equals(pass);
    }

    boolean add(String login, String pass) {
        if (login == null || pass == null) return false;
        accounts.put(login, pass);
        return true;
    }

    boolean remove(String login) {
        if (login == null) return false;
        return accounts.remove(login) != null;
    }
}
