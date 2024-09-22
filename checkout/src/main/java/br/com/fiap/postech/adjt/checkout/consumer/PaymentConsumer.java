package br.com.fiap.postech.adjt.checkout.consumer;

import br.com.fiap.postech.adjt.checkout.config.PaymentConfig;
import br.com.fiap.postech.adjt.checkout.dto.CheckoutPaymentDto;
import br.com.fiap.postech.adjt.checkout.dto.CheckoutResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PaymentConsumer {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Autowired
    public PaymentConsumer(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = PaymentConfig.PAYMENT_QUEUE)
    public CheckoutResponseDto handlePayment(CheckoutPaymentDto payment, String apiKey){
        String url = "https://payment-api-latest.onrender.com/create-payment";

        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", "777396e205b7881490af58e82df453333673428889284694abab7dd9");
        headers.set("Content-Type", "application/json");

        HttpEntity<CheckoutPaymentDto> request = new HttpEntity<>(payment, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        try{
            String responseBody = response.getBody();
            CheckoutResponseDto checkoutResponseDto = objectMapper.readValue(responseBody,CheckoutResponseDto.class);

            log.info("Resposta da API: " + response.getBody());
            return checkoutResponseDto;


        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
