package com.bankingappbackend.bankingapp.service;

import com.bankingappbackend.bankingapp.dto.AccountDto;
import com.bankingappbackend.bankingapp.entity.Account;
import com.bankingappbackend.bankingapp.mapper.AccountMapper;
import com.bankingappbackend.bankingapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    // DI
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        // convert AccountDto into Account jpa entity then save it in db
        // create a mapper class for converting dto to jpa entity and vice-versa

        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);

        // convert the Account object to AccountDto as it has the return type
        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto getAccountById(Long id) {
     Account account =  accountRepository
             .findById(id).
             orElseThrow(() -> new RuntimeException("Account does not exits"));

     // convert account to accountDto
        return AccountMapper.mapToAccountDto(account);

    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        // first check whether the account exists or not...
        Account account =  accountRepository
                .findById(id).
                orElseThrow(() -> new RuntimeException("Account does not exits"));

        double total_amount = account.getBalance() + amount;
        account.setBalance(total_amount);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }

}
