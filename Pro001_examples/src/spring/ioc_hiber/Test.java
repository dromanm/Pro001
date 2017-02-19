package spring.ioc_hiber;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc_hiber.entity.Car;
import spring.ioc_hiber.service.CarService;

/**
 * Created by IEvgen Boldyr on 19.02.17.
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "spring/ioc_hiber/spring-config.xml"
                );

        CarService service = context.getBean(CarService.class);
        service.create(new Car("AUDI", "BLACK"));


    }
}
