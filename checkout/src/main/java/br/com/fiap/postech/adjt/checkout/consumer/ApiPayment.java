package br.com.fiap.postech.adjt.checkout.consumer;

import br.com.fiap.postech.adjt.checkout.consumer.impl.ApiPaymentImpl;
import br.com.fiap.postech.adjt.checkout.dto.ApiKeyGroup;
import br.com.fiap.postech.adjt.checkout.dto.CheckoutPaymentDto;
import br.com.fiap.postech.adjt.checkout.dto.CheckoutResponseDto;
import br.com.fiap.postech.adjt.checkout.entity.payment.ApiGroup;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="api", url="https://payment-api-latest.onrender.com", fallback = ApiPaymentImpl.class)
public interface ApiPayment {
    @PostMapping("/create-group")
    ApiKeyGroup createApiGroup(@RequestBody ApiGroup apiGroup);

    @PostMapping("/create-payment")
    CheckoutResponseDto createPayment(@RequestBody CheckoutPaymentDto payment,
                                      @RequestHeader("apiKey") String apiKey);

}
