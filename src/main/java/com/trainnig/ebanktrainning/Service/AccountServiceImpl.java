package com.trainnig.ebanktrainning.Service;

import com.trainnig.ebanktrainning.BankAccountRepository.BankAccountRepository;
import com.trainnig.ebanktrainning.Entities.BankAccount;
import com.trainnig.ebanktrainning.dto.BankAccountRequestDto;
import com.trainnig.ebanktrainning.dto.BankAccountResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount= BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDto.getBalance())
                .type(bankAccountDto.getType())
                .currency(bankAccountDto.getCurrency())        
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO=BankAccountResponseDTO.builder()
                .id(saveBankAccount.getId())
                .createdAt(saveBankAccount.getCreatedAt())
                .balance(saveBankAccount.getBalance())
                .Type(saveBankAccount.getType())
                .Currency(saveBankAccount.getCurrency())
                .build();
        return bankAccountResponseDTO;
    }
}
