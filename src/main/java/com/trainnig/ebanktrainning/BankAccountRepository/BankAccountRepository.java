package com.trainnig.ebanktrainning.BankAccountRepository;

import com.trainnig.ebanktrainning.Entities.BankAccount;
import com.trainnig.ebanktrainning.Entities.Enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    
    @RestResource(path="/bytype")
     List<BankAccount> findByType(@Param("t") AccountType type);
    @RestResource(path = "/byCurrency")
     List<BankAccount> findByCurrency(@Param("c") String currency);
}
