package spring.ioc_practice.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IEvgen Boldyr on 18.02.17.
 */
public class IoCPracticeTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ioc_practice/spring-config.xml");

        Driver driver = (Driver) context.getBean("vasyan");
        System.out.println(driver);
        System.out.println(driver.getCar());
    }
}
