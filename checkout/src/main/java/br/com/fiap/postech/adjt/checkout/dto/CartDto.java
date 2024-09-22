package br.com.fiap.postech.adjt.checkout.dto;

import br.com.fiap.postech.adjt.checkout.entity.Cart;
import br.com.fiap.postech.adjt.checkout.entity.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CartDto {
    private Long itemId;
    private Long qnt;

    public CartDto(Long itemId, Long qnt) {
        this.itemId = itemId;
        this.qnt = qnt;
    }

    public CartDto convertCartToDto(Cart cart) {
        CartDto dto = new CartDto();
        dto.setItemId(cart.getItemId());
        dto.setQnt(cart.getQnt());
        return dto;
    }

    public List<CartDto> converListToDto(List<Cart> carts) {
        List<CartDto> cartDtos = carts.stream()
                .map(this::convertCartToDto)
                .collect(Collectors.toList());
        return cartDtos;
    }
}
