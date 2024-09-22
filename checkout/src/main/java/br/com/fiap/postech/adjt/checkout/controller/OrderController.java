package br.com.fiap.postech.adjt.checkout.controller;

import br.com.fiap.postech.adjt.checkout.dto.OrderDto;
import br.com.fiap.postech.adjt.checkout.entity.Order;
import br.com.fiap.postech.adjt.checkout.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;
    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/by-order-id/{orderId}")
    public OrderDto getByOderId(@PathVariable UUID orderId){
        Order order = service.getById(orderId);
       // OrderDto orderDto = modelMapper.map(order, OrderDto.class);
        OrderDto orderDto = new OrderDto();
        orderDto = orderDto.convertToDto(order);
        return orderDto;
    }
}
