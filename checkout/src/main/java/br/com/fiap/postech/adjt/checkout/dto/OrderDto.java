package br.com.fiap.postech.adjt.checkout.dto;

import br.com.fiap.postech.adjt.checkout.entity.Cart;
import br.com.fiap.postech.adjt.checkout.entity.Order;
import br.com.fiap.postech.adjt.checkout.entity.enums.PaymentStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
public class OrderDto {

    private UUID orderId;
    private String paymentType;
    private double value;
    private PaymentStatus paymentStatus;
    private List<CartDto> items;

    public OrderDto convertToDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setOrderId(order.getOrderId());
        dto.setPaymentType(order.getPaymentType());
        dto.setValue(order.getValue());
        dto.setPaymentStatus(order.getPaymentStatus());
        //var itemsCart  = cartDto.converListToDto(order.getCarts());
        List<CartDto> itemsCart = order.getCarts().stream()
                .map(this::convertToCartDto)
                .collect(Collectors.toList());
        dto.setItems(itemsCart);

        return dto;
    }

    private CartDto convertToCartDto(Cart cart) {
        // Conversão dos atributos de Cart para CartDto
        CartDto cartDto = new CartDto(cart.getItemId(), cart.getQnt());
        return cartDto;
    }

}
