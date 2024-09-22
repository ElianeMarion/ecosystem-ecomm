package br.com.fiap.postech.adjt.checkout.entity;

import br.com.fiap.postech.adjt.checkout.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "tbl_order")
@Data

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderId;
    private UUID consumerId;
    private String paymentType;
    @Column(name = "orderValue")
    private double value;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToMany
    private List<Cart> carts;



}
