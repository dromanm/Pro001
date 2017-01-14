package lesson05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by IEvgen Boldyr on 14.01.17.
 */
public class StringRefEx {

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("login", "password");
        AbstarctUser abstarctUser = new AbstarctUser();
        //reflectionInfo(user);
        objEquals(user, abstarctUser);
        //stringInfo();
        fields(user);
    }

    public static void stringInfo() {
        String string = new String();

        //Field[] fields   = string.getClass().getDeclaredFields();

        Method[] methods = string.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("\n**********" + method.getName() + "**********");
            if (method.getParameterCount() > 0) {
                System.out.println("Parameters : " + method.getParameterCount());
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    System.out.println("Parameter name: " + parameter.getName());
                    System.out.println("Parameter type: " + parameter.getType());
                }
            }
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("**********" + method.getName() + "**********");
        }
    }

    public static void reflectionInfo(Object object) {
        if (object == null) return;

        System.out.println("********** " + object.getClass().getName() + "**********");
        //Описанные в классе поля
        Field[] fields = object.getClass().getDeclaredFields();
        System.out.println("Declared fields : " + fields.length);
        if (fields.length > 0) {
            for (Field field : fields) {
                System.out.println("Field name : " + field.getName() + "Field type : " + field.getType());
            }
        }
        //Получение родительского класса
        Class parent = object.getClass().getSuperclass();
        while (parent != null) {
            System.out.println("Parent class: " + parent.getName());
            parent = parent.getSuperclass();
        }
        //Получение списка реализуемых интерфейсов
        Class[] interfaces = object.getClass().getInterfaces();
        if (interfaces.length > 0) {
            for (Class inter : interfaces) {
                System.out.println("Interface : " + inter.getName());
            }
        }

        System.out.println("********** " + object.getClass().getName() + "**********");
    }

    public static void objEquals(Object first, Object second) {
        Class[] firstInter = first.getClass().getInterfaces();
        Class[] secondInter = second.getClass().getInterfaces();

        if (firstInter.length > 0 & secondInter.length > 0) {
            for (Class inter1 : firstInter) {
                for (Class inter2 : secondInter) {
                    if (inter1.getName().equals(inter2.getName())) {
                        System.out.println("Interface : " + inter2.getName());
                    }
                }
            }
        }
    }

    //Изменение значения private поля с помощью рефлексии
    public static void fields(Object obj) throws IllegalAccessException {
        class SomeClass {
            private String someStr = "private";

            public String getSomeStr() {
                return someStr;
            }
        }

        SomeClass someClass = new SomeClass();

        System.out.println(someClass.getSomeStr());
        Field[] fields = someClass.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(someClass, new String("reflect"));
            field.setAccessible(false);
        }
        System.out.println(someClass.getSomeStr());
    }
}
