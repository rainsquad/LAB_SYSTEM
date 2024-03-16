package com.LAB.LabSystem.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "payments")
public class Payment {

    @Id
    private String id;
    private String token;
    private int amount;

    public Payment(String id, String token, int amount) {
        this.id = id;
        this.token = token;
        this.amount = amount;
    }

    public Payment() {

    }

}

