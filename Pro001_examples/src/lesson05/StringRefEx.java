package lesson05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by IEvgen Boldyr on 14.01.17.
 */
public class StringRefEx {

    public static void main(String[] args) {
        User user = new User("login", "password");
        reflectionInfo(user);

        //stringInfo();
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
        Class obj = Object.class;
        Class parent = object.getClass().getSuperclass();
        do {
            System.out.println("Parrent class: " + parent.getName());
            parent = parent.getSuperclass();
        } while (parent.getClass() != obj.getClass());
        //Получение списка реализуемых интерфейсов
        Class[] interfaces = object.getClass().getInterfaces();
        if (interfaces.length > 0) {
            for (Class inter : interfaces) {
                System.out.println("Interface : " + inter.getName());
            }
        }

        System.out.println("********** " + object.getClass().getName() + "**********");
    }
}
