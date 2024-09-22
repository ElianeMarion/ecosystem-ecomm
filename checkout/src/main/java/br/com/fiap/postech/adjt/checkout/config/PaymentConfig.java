package br.com.fiap.postech.adjt.checkout.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


@Configuration
public class PaymentConfig {
    public static final String PAYMENT_QUEUE = "paymentQueue";

    @Bean
    public Queue paymentQueue(){
        return new Queue(PAYMENT_QUEUE, true);
    }

}
