package br.com.fiap.postech.adjt.checkout.producer;

import br.com.fiap.postech.adjt.checkout.config.PaymentConfig;
import br.com.fiap.postech.adjt.checkout.config.PaymentProperties;
import br.com.fiap.postech.adjt.checkout.dto.CheckoutPaymentDto;
import br.com.fiap.postech.adjt.checkout.dto.CheckoutResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentEventSend{

    private final RabbitTemplate rabbitTemplate;

    public PaymentEventSend(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendPayment(CheckoutPaymentDto payment, String apiKey) {
        rabbitTemplate.convertAndSend(PaymentConfig.PAYMENT_QUEUE, payment);
        System.out.println("Pagamento enviado para a fila: " + payment);
    }
}
