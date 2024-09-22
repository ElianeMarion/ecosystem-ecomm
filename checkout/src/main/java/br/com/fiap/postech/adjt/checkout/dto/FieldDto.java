package br.com.fiap.postech.adjt.checkout.dto;

import lombok.Data;

@Data
public class FieldDto {
    private String number;
    private String expiration_month;
    private String expiration_year;
    private String cvv;
    private String name;
}
