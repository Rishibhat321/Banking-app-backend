package com.bankingappbackend.bankingapp.dto;

import java.util.Objects;

public class AccountDto {

    private Long id;
    private String accountHolderName;
    private double balance;

    // constructors
    public AccountDto() {

    }

    public AccountDto(String accountHolderName, double balance, Long id) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.id = id;
    }

    // define getters/setters

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // define toString

    @Override
    public String toString() {
        return "AccountDto{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", id=" + id +
                ", balance=" + balance +
                '}';
    }

    // equals() and hashCode() (can be optional)
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return Double.compare(balance, that.balance) == 0 && Objects.equals(id, that.id) && Objects.equals(accountHolderName, that.accountHolderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountHolderName, balance);
    }
}
