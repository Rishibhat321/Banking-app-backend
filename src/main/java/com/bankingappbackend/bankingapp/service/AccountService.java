package com.bankingappbackend.bankingapp.service;

import com.bankingappbackend.bankingapp.dto.AccountDto;
// import com.bankingappbackend.bankingapp.entity.Account;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

}
