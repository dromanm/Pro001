package spring.ioc_hiber.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by IEvgen Boldyr on 25.02.17.
 */

public class CarDAOLogger {

    private static final Logger log =
            LogManager.getLogger(CarDAOLogger.class);

    public void beforeCreate() {
        log.info("Запуск метода create(...);");
    }

    public void afterCreate() {
        log.info("Завершение метода create(...);");
    }

    public void afterReturningCreate() {
        log.info("Успешно создана новая запис в БД");
    }

    public void afterThrowingCreate() {
        log.error("Произошла ошибка во время выполения метода create(...);");
    }

}
