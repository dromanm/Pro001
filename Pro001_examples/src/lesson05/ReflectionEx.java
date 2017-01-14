package lesson05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by IEvgen Boldyr on 14.01.17.
 */

public class ReflectionEx {

    public static void main(String[] args) {
        User user = new User("login", "password");

        //Метод getFields() - вернет все описанные поля
        //в классе c модификатором public
        //Field[] fields = user.getClass().getFields();
        //Метод getDeclaredFields() - вернет все описанные поля
        //в классе
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName()); //Имя поля
            System.out.println(field.getType()); //Тип поля
        }

        //Получаем все методы описакные в классе.
        Method[] publicMethods = user.getClass().getMethods();
        Method[] methods = user.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName()); //Имя метода
            System.out.println(method.getParameterCount()); //Количесво параметров
            if (method.getParameterCount() > 0) {
                Class[] classes = method.getParameterTypes(); //Параметры метода
                for (Class cl : classes) {
                    System.out.println(cl.getName());
                }
            }
            System.out.println(method.getReturnType()); //Тип возвращаемого значения
        }

        Class[] classes = user.getClass().getInterfaces();
        for (Class cl : classes) {
            System.out.println(cl.getName());
        }
        System.out.println(user.getClass().getSuperclass());;
    }
}
