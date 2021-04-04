package net.snack;

import org.junit.jupiter.api.Test;

import java.util.logging.*;

public class JdkLoggingTest {

//    private static final Logger logger = Logger.getLogger(JdkLoggingTest.class.getName());
    private static final Logger logger = Logger.getGlobal();

    @Test
    public void testJdkLogging() {
//        ConsoleHandler handler = new ConsoleHandler();
//        handler.setLevel(Level.ALL);
//        logger.addHandler(handler);
//        logger.setLevel(Level.FINEST);
//        System.out.println(logger.getParent().getHandlers().length);
        logger.getParent().getHandlers()[0].setLevel(Level.ALL);
        logger.setLevel(Level.ALL);
        logger.finest("jdk logging finest");
        logger.finer("jdk logging finer");
        logger.fine("jdk logging fine");
        logger.config("jdk logging config");
        logger.info("jdk logging info");
        logger.warning("jdk logging warn");
        logger.severe("jdk logging severe");
    }
}
