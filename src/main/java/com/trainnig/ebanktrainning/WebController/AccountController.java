package com.trainnig.ebanktrainning.WebController;

import com.trainnig.ebanktrainning.Entities.BankAccount;
import com.trainnig.ebanktrainning.BankAccountRepository.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountController {

    private BankAccountRepository bankAccountRepository;

    public AccountController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
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
    public BankAccount insert(@RequestBody BankAccount bankAccount){
        if(bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
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
