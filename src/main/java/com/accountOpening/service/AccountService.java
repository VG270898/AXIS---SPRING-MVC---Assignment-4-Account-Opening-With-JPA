package com.accountOpening.service;

import com.accountOpening.model.Account;
import com.accountOpening.model.Client;
import com.accountOpening.repository.AccountRepo;
import com.accountOpening.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class AccountService {
    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private AccountRepo accountRepo;

    public String openAccount(Client client){
        Long clientId = clientRepo.save(client).getClientId();

        Account account = new Account(new Date(System.currentTimeMillis()),"Savings",clientId);

        Long accountNo = accountRepo.save(account).getAccountNo();

        return "Successfully Account Created with Account No : "+accountNo;
    }



}
