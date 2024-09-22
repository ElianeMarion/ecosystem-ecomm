package br.com.fiap.postech.adjt.checkout.consumer.impl;

import br.com.fiap.postech.adjt.checkout.consumer.CartClient;
import br.com.fiap.postech.adjt.checkout.entity.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CartClientImpl implements CartClient {

    @Override
    public List<Cart> getCart(UUID consumerId) {
        return new ArrayList<>();
    }
}
