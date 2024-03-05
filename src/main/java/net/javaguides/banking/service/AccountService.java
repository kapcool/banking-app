package net.javaguides.banking.service;


import java.util.List;

import net.javaguides.banking.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    List<AccountDto> getAccounts();
    AccountDto deposit(Long id, Double amount);
    AccountDto withdraw(Long id, Double amount);
    void deleteAccount(Long id);
}
