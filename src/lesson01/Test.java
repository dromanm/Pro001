package lesson01;

/**
 * Created by IEvgen Boldyr on 17.12.16.
 */

public class Test /*extends Object*/ {

    public static void main(String[] args) {
        User user1 = new User("test1", "test1", 2016);
        User user2 = new User("test1", "test1", 2016);
        User user3 = new User("test2", "test2", 2015);

        System.out.println(user1.equals(user2)); //false
        System.out.println(user1.equals(user3)); //true
    }
}
