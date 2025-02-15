package com.bankingappbackend.bankingapp.service;

import com.bankingappbackend.bankingapp.dto.AccountDto;

import java.util.List;
// import com.bankingappbackend.bankingapp.entity.Account;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);

}
