package com.hai.minh.epservice.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hai.minh.epservice.commons.constants.RabbitConstants;
import com.hai.minh.epservice.config.props.RabbitConfigProperties;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@EnableRabbit
@Configuration
public class RabbitConfiguration {

    @Autowired
    private RabbitConfigProperties rabbitProperties;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(rabbitProperties.getHost() + ":" + rabbitProperties.getPort());
        connectionFactory.setUsername(rabbitProperties.getUsername());
        connectionFactory.setPassword(rabbitProperties.getPassword());
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplateNew(ObjectMapper mapper) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setMessageConverter(new Jackson2JsonMessageConverter(mapper));
        return template;
    }

    @Bean
    public Queue queueUpdateEpProduct() {
        return new Queue(RabbitConstants.QUEUE_UPDATE_ID_EP_PRODUCT, true);
    }

    @Bean
    public Exchange directExchange() {
        return new DirectExchange(RabbitConstants.DIRECT_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Binding queueBinding() {
        return new Binding(RabbitConstants.QUEUE_UPDATE_ID_EP_PRODUCT, Binding.DestinationType.QUEUE,
                RabbitConstants.DIRECT_EXCHANGE_NAME, "", null);
    }
}