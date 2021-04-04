package net.snack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.junit.jupiter.api.Test;

public class Log4j2Test {

    private static final Logger logger = LogManager.getLogger(Log4j2Test.class);

    @Test
    public void testLog4j2() {
        logger.debug("log4j2 debug test");
        logger.info("log4j2 info test");
        logger.warn("log4j2 warn test");
        logger.error("log4j2 error test");
    }

    @Test
    public void testCodeConfigure() {
    }
}
