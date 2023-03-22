package com.trainnig.ebanktrainning.dto;

import com.trainnig.ebanktrainning.Entities.Enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountRequestDto {
    private Double balance;
    private String Currency;
    private AccountType Type;
}
