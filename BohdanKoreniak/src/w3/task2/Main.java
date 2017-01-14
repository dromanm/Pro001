package w3.task2;

import java.io.BufferedInputStream;
import java.lang.reflect.Field;

/**
 * Created by Bohdan on 14.01.2017.
 */
public class Main
{
    private void printSuperclasses(Class aClass)
    {
        Class superclass = aClass.getSuperclass();
        while (superclass != null)
        {
            System.out.println(superclass.getName());
            superclass = superclass.getSuperclass();
        }
    }

    public void printClassInfo(Object object)
    {
        Class classObject = object.getClass();

        Field[] declaredFields = classObject.getDeclaredFields();

        System.out.println("Object`s class information");

        System.out.println("\nFields count: " + declaredFields.length);
        for (Field declaredField : declaredFields)
        {
            System.out.println("\nField name: " + declaredField.getName());
            if (!declaredField.getType().isArray())
            {
                System.out.println("Field type: " + declaredField.getType());
            }
            else
            {
                System.out.println(declaredField.getType().getSimpleName());
            }
        }

        System.out.println("\nClass hierarchy");
        printSuperclasses(classObject);

        Class[] interfaces = classObject.getInterfaces();

        if (interfaces.length != 0)
        {
            System.out.println("\nClass interfaces");
            for (Class anInterface : interfaces)
            {
                System.out.println(anInterface.getName());
            }
        }
    }

    public static void main(String[] args)
    {
        Main main = new Main();

        main.printClassInfo(new BufferedInputStream(System.in));
    }
}
