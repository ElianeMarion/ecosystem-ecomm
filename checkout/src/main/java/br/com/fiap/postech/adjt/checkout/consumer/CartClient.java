package br.com.fiap.postech.adjt.checkout.consumer;


import br.com.fiap.postech.adjt.checkout.consumer.impl.CartClientImpl;
import br.com.fiap.postech.adjt.checkout.entity.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name="cart", url="http://localhost/cart", fallback = CartClientImpl.class)
public interface CartClient {

    @GetMapping
    List<Cart> getCart(@RequestBody UUID consumerId);

}
