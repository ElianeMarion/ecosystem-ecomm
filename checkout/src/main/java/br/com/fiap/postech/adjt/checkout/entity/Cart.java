package br.com.fiap.postech.adjt.checkout.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Cart {
    @Id
    private UUID cartId;
    //private UUID consumerId;
    private Long itemId;
    private Long qnt;


}
