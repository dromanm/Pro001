package lesson05;

import sun.reflect.Reflection;

import java.lang.reflect.Method;

public class ReflectT extends Reflection {

    public static void main(String[] args) {
        String string = new String();
        Method[] methods = string.getClass().getDeclaredMethods();
        for(Method method: methods){
            System.out.println(method.toString());
        }
        System.out.println(methods.length);
    }

}
