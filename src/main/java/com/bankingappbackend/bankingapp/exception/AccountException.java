package com.bankingappbackend.bankingapp.exception;

public class AccountException extends RuntimeException{

    public AccountException(String message) {   // this message holds the error message
        // super class constructor
        super(message);
    }

}
