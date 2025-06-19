package com.bankingappbackend.bankingapp.service;

import com.bankingappbackend.bankingapp.dto.AccountDto;
import com.bankingappbackend.bankingapp.dto.TransferFundDto;
import com.bankingappbackend.bankingapp.entity.Account;
import com.bankingappbackend.bankingapp.exception.AccountException;
import com.bankingappbackend.bankingapp.mapper.AccountMapper;
import com.bankingappbackend.bankingapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

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

    // Exception handling
    // use account exception
    @Override
    public AccountDto getAccountById(Long id) {
   /*
        Account account =  accountRepository
                .findById(id).
                orElseThrow(() -> new RuntimeException("Account does not exits"));
    */

        Account account =  accountRepository.findById(id)
                        .orElseThrow(() -> new AccountException("Account does not exits"));

        // convert account to accountDto
        return AccountMapper.mapToAccountDto(account);

    }



    @Override
    public AccountDto deposit(Long id, double amount) {
        // first check whether the account exists or not...
        Account account =  accountRepository
                .findById(id).
                orElseThrow(() -> new AccountException("Account does not exits"));

        double total_amount = account.getBalance() + amount;
        account.setBalance(total_amount);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }


    @Override
    public AccountDto withdraw(Long id, double amount) {
        // check whether the account exists!
        Account account =  accountRepository
                .findById(id).
                orElseThrow(() -> new AccountException("Account does not exits"));

        // check balance
        if(account.getBalance() < amount) {
            throw new RuntimeException("Insufficient amount");
        }

        double total_amount = account.getBalance() - amount;
        account.setBalance(total_amount);
        Account savedAccount = accountRepository.save(account);

        // change to accountDto
        return AccountMapper.mapToAccountDto(savedAccount);

    }



    @Override
    public List<AccountDto> getAllAccounts() {

       List<Account> accounts =  accountRepository.findAll();
       return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
               .collect(Collectors.toList());

    }

    // used custom exception
    @Override
    public void deleteAccount(Long id) {

        // check if account exists!
        Account account =  accountRepository
                .findById(id)
                        .orElseThrow(() -> new AccountException("Account does not exits"));

        accountRepository.deleteById(id);

    }

    @Override
    public void transferFunds(TransferFundDto transferFundDto) {

        // transfer the fund from one account to another account

        // Retrieve the account from which we send the amount
       Account fromAccount = accountRepository
                .findById(transferFundDto.fromAccountId())
                .orElseThrow(() -> new AccountException("Account does not exists"));

       // Retrieve the account to which we send the amount
        Account toAccount = accountRepository.findById(transferFundDto.toAccountId())
                .orElseThrow(() -> new AccountException("Account does not exists"));

        // Debit the amount from account object
        fromAccount.setBalance(fromAccount.getBalance() - transferFundDto.amount());

        // Credit the amount to Account object
        toAccount.setBalance(toAccount.getBalance() + transferFundDto.amount());

        accountRepository.save(fromAccount);

        accountRepository.save(toAccount);

    }


}
