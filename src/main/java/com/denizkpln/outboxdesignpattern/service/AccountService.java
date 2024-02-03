package com.denizkpln.outboxdesignpattern.service;

import com.denizkpln.outboxdesignpattern.model.Account;
import com.denizkpln.outboxdesignpattern.repository.AccountRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final OutBoxService outBoxService;


    public Account addAccount(Account account) throws JsonProcessingException {
        Account acc= accountRepository.save(account);
        outBoxService.addOutBox(account);
        return acc;
    }

}
