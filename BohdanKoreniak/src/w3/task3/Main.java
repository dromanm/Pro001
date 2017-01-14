package w3.task3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bohdan on 14.01.2017.
 */
public class Main
{
    private List<Class> getSuperclasses(Class aClass)
    {
        List<Class> listClasses = new ArrayList<>();

        Class superclass = aClass.getSuperclass();
        while (superclass != null)
        {
            listClasses.add(superclass);
            superclass = superclass.getSuperclass();
        }

        return listClasses;
    }

    private void fillInterfacesList(Class aClass, List<Class> listInterfaces)
    {
        Class[] interfaces = aClass.getInterfaces();

        if (interfaces.length != 0)
        {
            Collections.addAll(listInterfaces, interfaces);
            for (Class anInterface : interfaces)
            {
                fillInterfacesList(anInterface, listInterfaces);
            }
        }
    }

    public void comapareObjects(Object object, Object object1)
    {
        List<Class> listInterfacesObject = new ArrayList<>();
        List<Class> listInterfacesObject1 = new ArrayList<>();

        fillInterfacesList(object.getClass(), listInterfacesObject);
        fillInterfacesList(object1.getClass(), listInterfacesObject1);

        List<Class> listSuperclassesObject = getSuperclasses(object.getClass());
        List<Class> listSuperclassesObject1 = getSuperclasses(object1.getClass());

        listSuperclassesObject.forEach(aClass ->
        {
            fillInterfacesList(aClass, listInterfacesObject);
        });

        listSuperclassesObject1.forEach(aClass ->
        {
            fillInterfacesList(aClass, listInterfacesObject1);
        });

        listInterfacesObject.retainAll(listInterfacesObject1);
        listSuperclassesObject.retainAll(listSuperclassesObject1);

        if (!listSuperclassesObject.isEmpty())
        {
            System.out.println("\nSame superclasses\n");
            listSuperclassesObject.forEach(aClass ->
            {
                System.out.println(aClass.getName());
            });
        }

        if (!listInterfacesObject.isEmpty())
        {
            System.out.println("\nSame interfaces\n");
            listInterfacesObject.forEach(anInterface ->
            {
                System.out.println(anInterface.getName());
            });
        }
    }

    public static void main(String[] args)
    {
        Main main = new Main();

        try
        {
            System.out.println("Comparing BufferedInputStream and FileInputStream");
            main.comapareObjects(new BufferedInputStream(System.in), new FileInputStream("D:\\Bohdan\\IdeaProjects\\Pro001\\BohdanKoreniak\\tasks.txt"));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        System.out.println("\n\nComparing ArrayList and LinkedList");
        main.comapareObjects(new ArrayList<>(), new LinkedList<>());
    }
}
