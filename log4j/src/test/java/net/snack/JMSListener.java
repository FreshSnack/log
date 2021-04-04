package net.snack;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.log4j.spi.LoggingEvent;

import javax.jms.*;

public class JMSListener implements MessageListener {

    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        factory.setTrustAllPackages(true);
        Connection conn = factory.createConnection();
        Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        conn.start();
        MessageConsumer consumer = sess.createConsumer(sess.createTopic("logTopic"));
        consumer.setMessageListener(new JMSListener());
    }

    @Override
    public void onMessage(Message message) {
        try {
            LoggingEvent event = (LoggingEvent) ((ActiveMQObjectMessage) message).getObject();
            System.out.println("Received log [" + event.getLevel() + "]: " + event.getMessage());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
