package br.com.fiap.postech.adjt.checkout.entity.payment;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ApiGroup {
    private String groupName;
    private List<String> studentsNames;
    private String apiKey;

    public ApiGroup(String groupName, List<String> studentsNames) {
        this.groupName = groupName;
        this.studentsNames = studentsNames;
    }
}
