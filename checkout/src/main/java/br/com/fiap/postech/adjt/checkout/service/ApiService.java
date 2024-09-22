package br.com.fiap.postech.adjt.checkout.service;

import br.com.fiap.postech.adjt.checkout.consumer.ApiPayment;
import br.com.fiap.postech.adjt.checkout.dto.ApiKeyGroup;
import br.com.fiap.postech.adjt.checkout.entity.payment.ApiGroup;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    private final ApiPayment apiPayment;

    public ApiService(ApiPayment apiPayment) {
        this.apiPayment = apiPayment;
    }


    public ApiKeyGroup createApiGroup(ApiGroup apiGroup) {
        ApiKeyGroup apiKey = apiPayment.createApiGroup(apiGroup);
        apiKey.setApiKey(apiKey.getApiKey());
        return new ApiKeyGroup();
    }
}
