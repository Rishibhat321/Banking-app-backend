package com.bankingappbackend.bankingapp.mapper;

import com.bankingappbackend.bankingapp.dto.AccountDto;
import com.bankingappbackend.bankingapp.entity.Account;

public class AccountMapper {

    // method to convert AccountDto to jpa entity
    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );

        return account;
    }

    // method to convert Account Jpa to AccountDto
    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );

        return accountDto;
    }


}
