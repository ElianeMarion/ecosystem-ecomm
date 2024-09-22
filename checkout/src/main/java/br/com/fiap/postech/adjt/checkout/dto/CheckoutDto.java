package br.com.fiap.postech.adjt.checkout.dto;

import br.com.fiap.postech.adjt.checkout.entity.Checkout;
import br.com.fiap.postech.adjt.checkout.entity.Field;
import br.com.fiap.postech.adjt.checkout.entity.Payment;
import br.com.fiap.postech.adjt.checkout.entity.enums.PaymentStatus;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.UUID;

@Data
public class CheckoutDto {

    private UUID consumerId;
    private double amount;
    private String currency;

    private PaymentDto payment_method;
    private String paymentType;
    private PaymentStatus status;

    public CheckoutDto convertToDto(Checkout checkout) {
        ModelMapper mapper = new ModelMapper();
        FieldDto fieldDto = mapper.map(checkout.getPaymentMethod().getFields(), FieldDto.class);
        PaymentDto paymentDto = mapper.map(checkout.getPaymentMethod(), PaymentDto.class);

        CheckoutDto dto = new CheckoutDto();
        dto.setConsumerId(checkout.getConsumerId());
        dto.setCurrency(checkout.getCurrency());
        dto.setAmount(checkout.getAmount());
        dto.setPayment_method(paymentDto);
        return dto;
    }

    public Checkout convertFromDto(CheckoutDto checkoutDto){

        ModelMapper mapper = new ModelMapper();
        Field field = mapper.map(checkoutDto.getPayment_method().getFields(), Field.class);
        Payment payment = mapper.map(checkoutDto.getPayment_method(), Payment.class);
        payment.setFields(field);

        Checkout checkout = new Checkout();
        checkout.setValue(checkoutDto.getAmount());
        checkout.setCurrency(checkout.getCurrency());
        checkout.setAmount(checkoutDto.getAmount());
        checkout.setPaymentType(checkoutDto.getPaymentType());
        checkout.setPaymentMethod(payment);
        checkout.setConsumerId(checkoutDto.getConsumerId());
        checkout.setPaymentStatus(checkoutDto.getStatus());
        return checkout;
    }

}
