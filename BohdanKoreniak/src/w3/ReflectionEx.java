package w3;

import java.lang.reflect.Field;

/**
 * Created by Bohdan on 14.01.2017.
 */
public class ReflectionEx
{
    public static void main(String[] args)
    {
        User user = new User("Thorin", "Death_to_the_Orcs");

        System.out.println(user);

        try
        {
            Field fieldLogin = user.getClass().getDeclaredField("login");
            fieldLogin.setAccessible(true);

            Field fieldPassword = user.getClass().getDeclaredField("password");
            fieldPassword.setAccessible(true);

            fieldLogin.set(user, "Azog");
            fieldPassword.set(user, "Kill_that_dwarf_scum");

            System.out.println(user);
        }
        catch (NoSuchFieldException | IllegalAccessException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("User interfaces");

        Class<?>[] interfaces = user.getClass().getInterfaces();

        for (Class<?> anInterface : interfaces)
        {
            System.out.println(anInterface.getName());
        }
    }
}
