package net.javaguides.banking.controller;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        AccountDto savedAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(savedAccount,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id){
        AccountDto getAccount = accountService.getAccountById(id);
        return new ResponseEntity<>(getAccount, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto> >getAccounts(){
        List<AccountDto> getAllAccounts = accountService.getAccounts();
        return new ResponseEntity<>(getAllAccounts, HttpStatus.OK);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable("id") Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto depositAccount = accountService.deposit(id, amount);
        return new ResponseEntity<>(depositAccount,HttpStatus.OK);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable("id") Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto depositAccount = accountService.withdraw(id, amount);
        return new ResponseEntity<>(depositAccount,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Account Deleted", HttpStatus.OK);
    }



}
