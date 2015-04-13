package org.satishg.camel.example.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
public class ActiveMqConfiguration {
	
	
    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
       final ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
        activeMQConnectionFactory.setUserName("admin");
        activeMQConnectionFactory.setPassword("admin");
        return activeMQConnectionFactory;
    }
    
    
	

}
