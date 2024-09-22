package br.com.fiap.postech.adjt.checkout.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Field {
    @Id
    private String number;
    private String expirationMonth;
    private String expirationYear;
    private String cvv;
    private String name;
}
