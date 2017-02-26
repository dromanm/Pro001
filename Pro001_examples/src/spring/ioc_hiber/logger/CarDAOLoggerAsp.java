package spring.ioc_hiber.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by IEvgen Boldyr on 26.02.17.
 */

@Aspect
@Component
public class CarDAOLoggerAsp {

    private final Logger log = LogManager.getLogger(CarDAOLoggerAsp.class);

    @Pointcut("execution(* spring.ioc_hiber.dao.CarDAOImpl2.read(..))")
    private void pointcutRead() {}

    @Before("pointcutRead()")
    private void beforeRead() {
        log.info("AspectJ (@Before) - Запуск метода CarDAO.read(..)");
    }

    @After("pointcutRead()")
    private void afterRead() {
        log.info("AspectJ (@After) - Завершение метода CarDAO.read(..)");
    }

    @AfterReturning(pointcut = "pointcutRead()", returning = "car")
    private void afterReturningRead(Object car) {
        log.info("AspectJ (@AfterReturning) - Успешное извлечение объекта");
        log.info("AspectJ (@AfterReturning) - Car (" + car + ")");
    }

    @AfterThrowing(pointcut = "pointcutRead()", throwing = "exc")
    private void afterThrowingRead(Throwable exc) {
        log.info("AspectJ (@AfterThrowing) - Произошла ошибка " + exc) ;
    }

    @Around("execution(* spring.ioc_hiber.dao.CarDAOImpl2.create(..))")
    private void around(ProceedingJoinPoint point) throws Throwable {
        //Before
        point.proceed();
        //After
    }
}
