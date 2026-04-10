/*package com.danilocampos.storefront;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.queue.product-change-availability}")
    private String queueName;

    @Bean
    public Queue productChangeQueue() {
        // O segundo parâmetro 'true' indica que a fila é durável
        return new Queue(queueName, true);
    }
}
*/
