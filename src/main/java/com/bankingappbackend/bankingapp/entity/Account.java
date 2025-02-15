package com.bankingappbackend.bankingapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;
    private double balance;

    // define constructors
    public Account() {

    }

    public Account(String accountHolderName, double balance, Long id) {
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
        return "Account{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", id=" + id +
                ", balance=" + balance +
                '}';
    }

}
