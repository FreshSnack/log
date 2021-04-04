package net.snack;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

public class CommonsLoggingTest {

    private static final Log log = LogFactory.getLog(CommonsLoggingTest.class);

    @Test
    public void testLogger() {
        log.error("hello world");
    }
}
