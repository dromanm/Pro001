package spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ioc.springan.Dog;
import spring.ioc.springan.SpringConfig;

/**
 * Created by IEvgen Boldyr on 18.02.17.
 */

public class SpringAnnotations {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();

        Dog bobik = context.getBean("bobik", Dog.class);
        bobik.name();
        bobik.voice();

        Dog sharik = context.getBean("sharik", Dog.class);
        sharik.name();
        sharik.voice();
    }
}
