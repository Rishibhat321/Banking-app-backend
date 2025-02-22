package com.bankingappbackend.bankingapp.dto;

public record TransferFundDto(Long fromAccountId,
                              Long toAccountId,
                              double amount) {
    
}
