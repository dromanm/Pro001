package spring.ioc.springan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IEvgen Boldyr on 18.02.17.
 */

@Configuration
public class SpringConfig {

    @Bean(name = "bobik")
    public Dog beanDog() {
        return new DogImpl("Bobik", "WOOOF!");
    }

    @Bean(name = "sharik")
    public Dog beanDogSharik() {
        return new DogImpl("Sharik", "WOOOF!");
    }
}
