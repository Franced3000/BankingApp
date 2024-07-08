package org.example.BankingApp.repository;

import org.example.BankingApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
        Account findByIban(String iban);
}
