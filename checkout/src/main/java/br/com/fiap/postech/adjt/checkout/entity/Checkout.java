package br.com.fiap.postech.adjt.checkout.entity;

import br.com.fiap.postech.adjt.checkout.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Entity
@Data
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID checkoutId;
    private double amount;
    private String currency;
    @OneToOne
    private Payment paymentMethod;

    //Order
    private UUID consumerId;
    private String paymentType;
    private double value;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

}
