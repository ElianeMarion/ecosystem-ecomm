package br.com.fiap.postech.adjt.checkout.service;

import br.com.fiap.postech.adjt.checkout.entity.Field;
import br.com.fiap.postech.adjt.checkout.entity.Payment;
import br.com.fiap.postech.adjt.checkout.repository.FieldRepository;
import br.com.fiap.postech.adjt.checkout.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository repository;
    private final FieldRepository fieldRepository;

    public PaymentService(PaymentRepository repository, FieldRepository fieldRepository) {
        this.repository = repository;
        this.fieldRepository = fieldRepository;
    }

    public Payment createPayment(Payment payment){
        Field field = fieldRepository.save(payment.getFields());
        payment.setFields(field);
        return repository.save(payment);

    }
}
