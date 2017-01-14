package hw2.hash;

/**
 * Created by eriol4ik on 27/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        User user = new User("111", new char[]{'I'}, 0, true);
        User user2 = new User("111", new char[]{'i'}, 0, true);
        System.out.println(user.equals(user2));
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());
    }
}
