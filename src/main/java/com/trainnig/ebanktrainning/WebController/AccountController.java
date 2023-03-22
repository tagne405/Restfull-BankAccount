package com.trainnig.ebanktrainning.WebController;

import com.trainnig.ebanktrainning.Entities.BankAccount;
import com.trainnig.ebanktrainning.Mappers.AccountMappers;
import com.trainnig.ebanktrainning.Service.AccountService;
import com.trainnig.ebanktrainning.dto.BankAccountRequestDto;
import com.trainnig.ebanktrainning.dto.BankAccountResponseDTO;
import com.trainnig.ebanktrainning.BankAccountRepository.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    // private AccountMappers accountMappers;

    public AccountController(BankAccountRepository bankAccountRepository, 
                            AccountService accountService
                            ) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        // this.accountMappers=accountMappers;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> allAccount(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount account(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO insert(@RequestBody BankAccountRequestDto bankAccountRequestDto){
        return accountService.addAccount(bankAccountRequestDto);
    }
    
    @PutMapping("/bankAccounts/{id}")
    public BankAccount modif(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not Found"));
        if(bankAccount.getBalance()!=null) account.setBalance(account.getBalance());
        if(bankAccount.getCreatedAt()!=null) account.setCreatedAt(new Date());
        if(bankAccount.getCurrency()!=null) account.setCurrency(account.getCurrency());
        if(bankAccount.getType()!=null) account.setType(account.getType());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public String delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);
        return "Account delete Successfully";
    }
}
