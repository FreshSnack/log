package net.snack;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {

    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void testLogback() {
        logger.error("logback error test");
    }

}
