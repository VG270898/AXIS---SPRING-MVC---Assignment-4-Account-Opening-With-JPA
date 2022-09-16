package com.accountOpening.controller;

import com.accountOpening.model.Account;
import com.accountOpening.model.Client;
import com.accountOpening.repository.AccountRepo;
import com.accountOpening.repository.ClientRepo;
import com.accountOpening.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private ClientRepo clientRepo;



    @RequestMapping("/Home")
    public String LoadRegisterPage(){
        return "Home";
    }


    @GetMapping("/viewClients")
    public ModelAndView ShowClients(){
        List<Client> clients = clientRepo.findAll();
        System.out.println(clients);
        HashMap<String,List<Client>> model = new HashMap<>();
        model.put("list",clients);
        return new ModelAndView("ClientDetails",model);
    }

    @GetMapping("/viewAccounts")
    public ModelAndView ShowAccounts(){
        List<Account> accounts = accountRepo.findAll();
        System.out.println(accounts);
        HashMap<String,List<Account>> model = new HashMap<>();
        model.put("list",accounts);
        return new ModelAndView("AccountDetails",model);
    }

    @GetMapping("searchClient")
    public String clientSearch(){
        return "SearchClient";
    }

    @GetMapping("searchAccount")
    public String accountSearch(){
        return "SearchAccount";
    }

    public ModelAndView showClient(Long id){
        Optional<Client> clients = clientRepo.findById(id);
        HashMap<String, Optional<Client>> model = new HashMap<>();
        model.put("list",clients);
        return new ModelAndView("ClientDetails",model);
    }

    @GetMapping("/{clientId}")
    public void showClientById(@RequestParam("clientId") Long clientId, ModelMap modelMap){
        modelMap.put("clientId",clientId);
        System.out.println((Long) modelMap.get("clientId"));
        showClient((Long) modelMap.get("clientId"));

    }

    @PostMapping("/accountId")
    public String showAccountById(@RequestParam("accountNo") Long accountNo,ModelMap modelMap){
        modelMap.put("accountNo",accountNo);
        Optional<Account> accounts = accountRepo.findById((Long) modelMap.get("accountNo"));
        System.out.println(accounts);
        HashMap<String, Optional<Account>> model = new HashMap<>();
        model.put("list",accounts);
        new ModelAndView("AccountDetails",model);
        return modelMap.get("accountNo").toString();
    }


//    @GetMapping("/account/{id}")
//    public ResponseEntity<Account> showAccountById(@PathVariable Long id){
//        return ResponseEntity.ok(accountRepo.findById(id).orElse(null));
//    }
//
//
//
//
//    @PutMapping("/client/update")
//    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
//        return ResponseEntity.ok(clientRepo.save(client));
//    }
}
