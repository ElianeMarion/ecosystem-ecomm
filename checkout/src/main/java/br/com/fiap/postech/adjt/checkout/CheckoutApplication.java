package br.com.fiap.postech.adjt.checkout;

import br.com.fiap.postech.adjt.checkout.dto.ApiKeyGroup;
import br.com.fiap.postech.adjt.checkout.entity.payment.ApiGroup;
import br.com.fiap.postech.adjt.checkout.service.ApiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class CheckoutApplication {


    public static void main(String[] args) {


        SpringApplication.run(CheckoutApplication.class, args);

    }

}
