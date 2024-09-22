package br.com.fiap.postech.adjt.checkout.service;

import br.com.fiap.postech.adjt.checkout.dto.CheckoutConsumerDto;
import br.com.fiap.postech.adjt.checkout.entity.Order;
import br.com.fiap.postech.adjt.checkout.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final CartService cartService;

    public OrderService(OrderRepository repository, CartService cartService) {
        this.repository = repository;
        this.cartService = cartService;
    }

    public Order createOrder(Order order){
        order.setCarts(cartService.getCartsFake(order.getConsumerId()));
        //order.setCarts(cartService.getCarts(order.getConsumerId()));
        return repository.save(order);

    }

    public Order getById(UUID id){
        var order = new Order();
        order = repository.findById(id).orElseThrow();
        return order;
    }

    public List<Order> getOrdersByConsumer(UUID consumerId){
        List<Order> orderList = new ArrayList<>();
        return repository.findByConsumerId(consumerId);

    }
}
