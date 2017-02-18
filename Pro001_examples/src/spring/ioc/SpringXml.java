package spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.springxml.Cat;

/**
 * Created by IEvgen Boldyr on 18.02.17.
 */
public class SpringXml {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/ioc/spring-config.xml");
        Cat cat = (Cat) context.getBean("murka");
        System.out.println("Cat name : " + cat.getName());
        System.out.println("Voice : " + cat.getVoice());
    }
}
