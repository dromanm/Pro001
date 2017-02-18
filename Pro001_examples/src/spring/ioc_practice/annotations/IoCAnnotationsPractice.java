package spring.ioc_practice.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ioc_practice.annotations.entity.DriverAn;

/**
 * Created by IEvgen Boldyr on 18.02.17.
 */
public class IoCAnnotationsPractice {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(PacticeAnnotationsConfig.class);
        context.refresh();

        DriverAn driver = context.getBean(DriverAn.class);
        driver.name();
        driver.car();
    }
}
