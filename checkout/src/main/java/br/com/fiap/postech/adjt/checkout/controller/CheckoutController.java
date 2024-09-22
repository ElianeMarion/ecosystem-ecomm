package br.com.fiap.postech.adjt.checkout.controller;

import br.com.fiap.postech.adjt.checkout.dto.CheckoutConsumerDto;
import br.com.fiap.postech.adjt.checkout.dto.CheckoutDto;
import br.com.fiap.postech.adjt.checkout.dto.CheckoutResponseDto;
import br.com.fiap.postech.adjt.checkout.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService service;

    public CheckoutController(CheckoutService service) {
        this.service = service;
    }

    @PostMapping
    public CheckoutResponseDto addChekout(@RequestBody CheckoutDto checkout){
        return service.addChekout(checkout);

    }
    @GetMapping("/{consumerId}")
    public CheckoutConsumerDto getOrdersByConsumer(@RequestParam UUID consumerId){
        return service.getOrdersByConsumer(consumerId);
    }
}
