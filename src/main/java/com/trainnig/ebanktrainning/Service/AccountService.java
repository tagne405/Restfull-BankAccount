package com.trainnig.ebanktrainning.Service;

import com.trainnig.ebanktrainning.dto.BankAccountRequestDto;
import com.trainnig.ebanktrainning.dto.BankAccountResponseDTO;

//creation d'un compte
public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDto bankAccountDto);
}
