package br.com.fiap.postech.adjt.checkout.service;

import br.com.fiap.postech.adjt.checkout.consumer.CartClient;
import br.com.fiap.postech.adjt.checkout.entity.Cart;
import br.com.fiap.postech.adjt.checkout.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    private final CartRepository repository;
    private final CartClient cartClient;

    public CartService(CartRepository repository, CartClient cartClient) {
        this.repository = repository;
        this.cartClient = cartClient;
    }

    public List<Cart> getCarts(UUID consumerId){
        return cartClient.getCart(consumerId);
    }

    public List<Cart> getCartsFake(UUID consumerId){
        return repository.findAll();
    }



}
