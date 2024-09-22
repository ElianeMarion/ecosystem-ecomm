package br.com.fiap.postech.adjt.checkout.dto;

import br.com.fiap.postech.adjt.checkout.entity.enums.PaymentStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class CheckoutResponseDto {
    private UUID orderId;
    private PaymentStatus status;
}
