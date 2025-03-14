package com.bankingappbackend.bankingapp.repository;

import com.bankingappbackend.bankingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
