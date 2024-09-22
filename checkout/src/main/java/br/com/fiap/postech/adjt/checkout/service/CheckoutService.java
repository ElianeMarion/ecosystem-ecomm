package br.com.fiap.postech.adjt.checkout.service;

import br.com.fiap.postech.adjt.checkout.consumer.ApiPayment;
import br.com.fiap.postech.adjt.checkout.dto.*;
import br.com.fiap.postech.adjt.checkout.entity.Checkout;
import br.com.fiap.postech.adjt.checkout.entity.Field;
import br.com.fiap.postech.adjt.checkout.entity.Order;
import br.com.fiap.postech.adjt.checkout.entity.Payment;
import br.com.fiap.postech.adjt.checkout.entity.enums.PaymentStatus;
import br.com.fiap.postech.adjt.checkout.entity.payment.ApiGroup;
import br.com.fiap.postech.adjt.checkout.producer.PaymentEventSend;
import br.com.fiap.postech.adjt.checkout.repository.CheckoutRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CheckoutService {

    private final CheckoutRepository repository;
    private final OrderService service;
    private final ApiPayment apiPayment;
    private final PaymentService paymentService;
    private final ApiService apiService;
    private ApiKeyGroup apiKeyGroup;
    private final PaymentEventSend paymentEventSend;


    @Autowired
    public CheckoutService(CheckoutRepository repository, OrderService service, ApiPayment apiPayment, PaymentService paymentService, ApiService apiService, PaymentEventSend paymentEventSend) {
        this.repository = repository;
        this.service = service;
        this.apiPayment = apiPayment;
        this.paymentService = paymentService;
        this.apiService = apiService;
        this.paymentEventSend = paymentEventSend;
    }

    public CheckoutResponseDto addChekout(CheckoutDto checkout){

        Field field = new Field();
        field.setCvv(checkout.getPayment_method().getFields().getCvv());
        field.setName(checkout.getPayment_method().getFields().getName());
        field.setNumber(checkout.getPayment_method().getFields().getNumber());
        field.setExpirationMonth(checkout.getPayment_method().getFields().getExpiration_month());
        field.setExpirationYear(checkout.getPayment_method().getFields().getExpiration_year());

        Payment payment = new Payment();
        payment.setType(checkout.getPayment_method().getType());
        payment.setFields(field);
        payment = paymentService.createPayment(payment);

        Order order = new Order();
        order.setConsumerId(checkout.getConsumerId());
        order.setValue(checkout.getAmount());
        order.setPaymentStatus(PaymentStatus.PENDING);
        order.setPaymentType(checkout.getPayment_method().getType());
        order = service.createOrder(order);
        var newCheckout = checkout.convertFromDto(checkout);
        newCheckout.setPaymentStatus(PaymentStatus.PENDING);
        newCheckout.setPaymentMethod(payment);
        repository.save(newCheckout);

        ModelMapper mapper = new ModelMapper();
        FieldDto fieldDto = mapper.map(checkout.getPayment_method().getFields(), FieldDto.class);
        PaymentDto paymentDto = mapper.map(checkout.getPayment_method(), PaymentDto.class);


        CheckoutPaymentDto checkoutPayment = new CheckoutPaymentDto();
        checkoutPayment.setAmount(checkout.getAmount());
        checkoutPayment.setPayment_method(paymentDto);
        checkoutPayment.setCurrency(checkout.getCurrency());
        checkoutPayment.setOrderId(order.getOrderId());
        log.info("Payment: " + checkoutPayment.toString());
        CheckoutResponseDto responseDto = new CheckoutResponseDto();
        ApiKeyGroup apiKey = apiService.createApiGroup(new ApiGroup("Grupo12", List.of("Eliane", "Edson", "Gabriel", "Juan", "Pedro")));


        log.info("Apikey: " + apiKey);
        // UUID apiKey = UUID.fromString("${API_KEY}");
        responseDto = apiPayment.createPayment(checkoutPayment, apiKey.getApiKey());
        paymentEventSend.sendPayment(checkoutPayment,apiKey.getApiKey());
        return responseDto;
    }

    public CheckoutConsumerDto getOrdersByConsumer(UUID consumerId){
        List<Order> orderList = service.getOrdersByConsumer(consumerId);
        CheckoutConsumerDto checkoutConsumerDto = new CheckoutConsumerDto();
        checkoutConsumerDto.setOrders(orderList);
        return checkoutConsumerDto;
    }
}
