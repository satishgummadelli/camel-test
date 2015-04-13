package org.satishg.camel.example;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.camel.CamelContext;
import org.satishg.camel.example.config.ActiveMqConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

@SpringBootApplication
@Import(ActiveMqConfiguration.class)
@EnableJms
public class CamelApplication implements CommandLineRunner {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	ActiveMQConnectionFactory  activeMQConnectionFactory;
	
    @Autowired
    CamelContext contexts;
    
    public static void main(String[] args) {
        SpringApplication.run(CamelApplication.class);
        
    }

    /**
     * this is the test. using jmstemplate sending a message to the router
     */
    public void run(String... strings) throws Exception {
    	
    	Destination destination = ActiveMQDestination.createDestination("queue://invoices", ActiveMQDestination.QUEUE_TYPE);
    	
		MessageCreator messageCreator = new MessageCreator() {
	          public ObjectMessage  createMessage(Session session) throws JMSException {
	        	  ObjectMessage message = session.createObjectMessage();
	        	  message.setObject("My first Message");       	              
	               return message;
	          }
		};
		jmsTemplate.send(destination, messageCreator);
		//intentionally doing the below steps
		Thread.sleep(5000);
		System.exit(100);
    }
    
    }