package com.denizkpln.outboxdesignpattern.controller;


import com.denizkpln.outboxdesignpattern.model.Account;
import com.denizkpln.outboxdesignpattern.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;



    @PostMapping("/addAccount")
    public ResponseEntity<Account> addAccount() throws JsonProcessingException {
        Account account=new Account(null,"Ali","Kaplan");
        account=accountService.addAccount(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
}