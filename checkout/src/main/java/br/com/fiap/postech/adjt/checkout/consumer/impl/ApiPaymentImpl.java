package br.com.fiap.postech.adjt.checkout.consumer.impl;

import br.com.fiap.postech.adjt.checkout.consumer.ApiPayment;
import br.com.fiap.postech.adjt.checkout.dto.ApiKeyGroup;
import br.com.fiap.postech.adjt.checkout.dto.CheckoutPaymentDto;
import br.com.fiap.postech.adjt.checkout.dto.CheckoutResponseDto;
import br.com.fiap.postech.adjt.checkout.entity.payment.ApiGroup;

public class ApiPaymentImpl implements ApiPayment {
    @Override
    public ApiKeyGroup createApiGroup(ApiGroup apiGroup) {
        return new ApiKeyGroup();
    }

    @Override
    public CheckoutResponseDto createPayment(CheckoutPaymentDto payment, String apiKey) {
        return new CheckoutResponseDto();
    }
}
