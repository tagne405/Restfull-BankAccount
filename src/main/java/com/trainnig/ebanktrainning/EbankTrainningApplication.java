package com.trainnig.ebanktrainning;

import com.trainnig.ebanktrainning.Entities.BankAccount;
import com.trainnig.ebanktrainning.BankAccountRepository.BankAccountRepository;
import com.trainnig.ebanktrainning.Entities.Enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class EbankTrainningApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankTrainningApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){
        return args->{
            for (int i = 0; i < 10; i++) {
                BankAccount bankAccount=BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .balance(1000*Math.random()*100)
                        .createdAt(new Date())
                        .Currency("Fcfa")
                        .Type((Math.random()>0.5)? AccountType.CURRENTACCOUNT:AccountType.SAVINGACCOUNT)
                        .build();
                bankAccountRepository.save(bankAccount);
            }

        };
    }

}
