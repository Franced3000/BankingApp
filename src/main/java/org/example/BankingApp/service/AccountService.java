package org.example.BankingApp.service;

import org.example.BankingApp.entity.Account;
import org.example.BankingApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountByIban(String iban) {
        return accountRepository.findByIban(iban);
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account createAccount(String accountHolderName, double balance, String iban) {
        Account account = new Account();
        account.setAccountHolderName(accountHolderName);
        account.setBalance(balance);
        account.setIban(iban);
        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, Account accountDetails) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setAccountHolderName(accountDetails.getAccountHolderName());
        account.setBalance(accountDetails.getBalance());
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}

