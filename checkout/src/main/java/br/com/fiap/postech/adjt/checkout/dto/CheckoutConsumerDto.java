package br.com.fiap.postech.adjt.checkout.dto;

import br.com.fiap.postech.adjt.checkout.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class CheckoutConsumerDto {
    private List<Order> orders;
}
