package lesson05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IEvgen Boldyr on 14.01.17.
 */
public class Test {
    public static void main(String[] args) {
        User user = new User("test", "test");
        Root root = new Root();
        eqObjectsParent(user, root);
    }

    public static void eqObjectsParent(Object first, Object second) {
        List<Class> firstParents = new ArrayList<>();
        List<Class> secondParents = new ArrayList<>();

        Class firstSuper = first.getClass().getSuperclass();
        while (firstSuper != null) {
            firstParents.add(firstSuper);
            firstSuper = firstSuper.getSuperclass();
        }

        Class secondSuper = second.getClass().getSuperclass();
        while (secondSuper != null) {
            secondParents.add(secondSuper);
            secondSuper = secondSuper.getSuperclass();
        }

        for (Class cl1 : firstParents) {
            for (Class cl2 : secondParents) {
                if (cl1.getClass() == cl2.getClass()) {
                    System.out.println(cl1.getName());
                    break;
                }
            }
        }

    }
}
