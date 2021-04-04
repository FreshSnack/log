package net.snack;

import org.apache.log4j.*;
import org.junit.jupiter.api.Test;

import java.io.File;

public class Log4jTest {

    private static final Logger logger = Logger.getLogger(Log4jTest.class);

    /**
     * 默认会读取resources目录下log4j.properties文件作为配置
     *
     * @see org.apache.log4j.LogManager
     */
    @Test
    public void testLog() {
        logger.debug("debug msg");
        logger.info("info msg");
        logger.warn("warn msg");
        logger.error("error msg");
    }

    /**
     * BasicConfigurator.configure方法会在根日志组件中追加ConsoleAppender
     * 多个Append效果会叠加，即输出多遍日志
     * BasicConfigurator.resetConfiguration会重置根日志组件，清空之前的Appender
     *
     * @see org.apache.log4j.Hierarchy[shutdown]
     */
    @Test
    public void testDefaultConfig() {
        BasicConfigurator.resetConfiguration();
        BasicConfigurator.configure();
        logger.info("logger default info test");
    }

    /**
     * 自定义配置文件，需配置在项目根目录下
     * 自动会覆盖默认的配置
     */
    @Test
    public void testCustomConfigFile() {
        PropertyConfigurator.configure("log4j-console.properties");
        logger.info("logger info custom config file test");
    }

    @Test
    public void testReadFileRelativePath() {
        System.out.println(System.getProperty("user.dir"));
        File file = new File("log4j-console.properties");
        System.out.println(file.getAbsolutePath());
    }

    /**
     * 代码方式配置
     */
    @Test
    public void testCodeConfig() {
        ConsoleAppender appender = new ConsoleAppender();
        appender.setName("CONSOLE");
        appender.setThreshold(Level.DEBUG);
        appender.setTarget(ConsoleAppender.SYSTEM_OUT);
        appender.setLayout(new TTCCLayout());
        appender.activateOptions();// 必须，激活配置
        logger.addAppender(appender);
        logger.setAdditivity(false);
        logger.info("logger info code config test");
    }


}
