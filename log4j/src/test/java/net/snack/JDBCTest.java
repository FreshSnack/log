package net.snack;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.Test;

public class JDBCTest {

    private final static Logger logger = Logger.getLogger(JDBCTest.class);

    @Test
    public void testJdbcAppender() {
        PropertyConfigurator.configure("log4j-jdbc.properties");
        logger.info("jdbc logger info test");
    }
}
