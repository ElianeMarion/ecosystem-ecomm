package br.com.fiap.postech.adjt.checkout.dto;

import br.com.fiap.postech.adjt.checkout.entity.Field;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class PaymentDto {
    private String type;
    private FieldDto fields;
}
