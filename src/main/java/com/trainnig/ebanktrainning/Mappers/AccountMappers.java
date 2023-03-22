package com.trainnig.ebanktrainning.Mappers;

import org.springframework.beans.BeanUtils;

import com.trainnig.ebanktrainning.Entities.BankAccount;
import com.trainnig.ebanktrainning.dto.BankAccountResponseDTO;

public class AccountMappers {
    public BankAccountResponseDTO fromBankAccount (BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
        
    }
}
