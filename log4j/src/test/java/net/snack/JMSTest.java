package net.snack;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.jms.*;

/**
 * docker search activemq
 * docker pull webcenter/activemq
 * docker run -d --name activemq -p 61616:61616 -p 8161:8161 webcenter/activemq
 * http://localhost:8161/admin admin/admin
 * @link http://activemq.apache.org/how-do-i-use-log4j-jms-appender-with-activemq.html
 */
public class JMSTest {

    private final static Logger logger = Logger.getLogger(JMSTest.class);

    @Test
    public void testJMSAppender() {
        PropertyConfigurator.configure("log4j-jms.properties");
        logger.info("jms logger info test");
    }
}
