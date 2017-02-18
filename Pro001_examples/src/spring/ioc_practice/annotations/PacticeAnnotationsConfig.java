package spring.ioc_practice.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.ioc_practice.annotations.entity.CarAn;
import spring.ioc_practice.annotations.entity.CarImpl;
import spring.ioc_practice.annotations.entity.DriverAn;
import spring.ioc_practice.annotations.entity.DriverImpl;

/**
 * Created by IEvgen Boldyr on 18.02.17.
 */

@Configuration
public class PacticeAnnotationsConfig {

    @Bean
    public CarAn beanCar() {
        return new CarImpl("Honda");
    }

    @Bean
    public DriverAn beanDriver() {
        return new DriverImpl("Ivan", "Ivanov");
    }
}
