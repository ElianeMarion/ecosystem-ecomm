package br.com.fiap.postech.adjt.cart.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    private UUID consumerId;
    private String itemId;
    private String quantity;

    public Cart(UUID consumerId, String itemId, String quantity) {
        this.consumerId = consumerId;
        this.itemId = itemId;
        this.quantity = quantity;
    }
}
