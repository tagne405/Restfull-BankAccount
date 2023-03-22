package com.trainnig.ebanktrainning.Service;

import com.trainnig.ebanktrainning.Entities.BankAccount;
import com.trainnig.ebanktrainning.dto.BankAccountRequestDto;
import com.trainnig.ebanktrainning.dto.BankAccountResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount= BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDto.getBalance())
                .Type(bankAccountDto.getType())
                .Currency(bankAccountDto.getCurrency())
                .build();
        return null;
    }
}
