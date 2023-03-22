package com.trainnig.ebanktrainning.Entities;

import com.trainnig.ebanktrainning.Entities.Enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String Currency;
    @Enumerated(value = EnumType.STRING)
    private AccountType Type;
}
