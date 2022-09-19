package com.accountOpening.service;

import com.accountOpening.model.Account;
import com.accountOpening.model.Client;
import com.accountOpening.model.Login;
import com.accountOpening.repository.AccountRepo;
import com.accountOpening.repository.ClientRepo;
import com.accountOpening.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class AccountService {
    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private LoginRepo loginRepo;

    public String openAccount(Client client,String password){

        if(client.getClientName().equals(null)){
            return "Enter Client Name";
        } else if (client.getClientMobile().equals(null)) {
            return "Enter Mobile Number";
        } else if (client.getClientAge().equals(null)) {
            return "Enter Client Age";
        } else if (password.equals(null)) {
            return "Enter Password";
        }

        if(password.length()<6){
            return "Password must 6 character Long";
        }

        Long clientId = clientRepo.save(client).getClientId();

        Login login = new Login(clientId,password);
        loginRepo.save(login);

        Account account = new Account(new Date(System.currentTimeMillis()),"Savings",clientId);

        Long accountNo = accountRepo.save(account).getAccountNo();

        return "Successfully Account Created with Account No : "+accountNo;
    }

    public String verify(Long id,String password){
        if(id==null){
            return "Fill Id";
        } else if (password.equals(null)) {
            return "Fill Password";
        }

        Optional<Login> idPass = loginRepo.findById(id);
        if(idPass.isPresent()){
            if(idPass.get().getPassword().equals(password)){
                return "verified";
            }
            else {
                return "wrongPass";
            }
        }else {
            return "noRecord";
        }

    }



}
