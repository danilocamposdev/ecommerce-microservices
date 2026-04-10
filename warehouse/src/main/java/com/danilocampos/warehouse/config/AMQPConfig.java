package com.danilocampos.warehouse.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

@Configuration
public class AMQPConfig {

  @Bean
  JacksonJsonMessageConverter jsonMessageConverter() {
    return new JacksonJsonMessageConverter();
  }

  @Bean
  RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory,
      final JacksonJsonMessageConverter converter) {
    var rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(converter);
    return rabbitTemplate;
  }

  @Bean
  Queue queue(@Value("${spring.rabbitmq.queue.product-change-availability}") final String name) {
    return new Queue(name, true);
  };

  @Bean
  DirectExchange exchange(@Value("${spring.rabbitmq.exchange.product-change-availability}") final String name) {
    return new DirectExchange(name);
  }

  @Bean
  Binding binding(final Queue queue,
      final DirectExchange exchange,
      @Value("${spring.rabbitmq.routing-key.product-change-availability}") final String name) {
    return BindingBuilder.bind(queue).to(exchange).with(name);
  }

}
