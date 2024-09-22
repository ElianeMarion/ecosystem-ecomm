package br.com.fiap.postech.adjt.checkout.dto;

import br.com.fiap.postech.adjt.checkout.entity.Payment;
import lombok.Data;

import java.util.UUID;
@Data
public class CheckoutPaymentDto {
    private UUID orderId;
    private double amount;
    private String currency;

    private PaymentDto payment_method;
}
