package com.accountOpening.controller;

import com.accountOpening.model.Account;
import com.accountOpening.model.Client;
import com.accountOpening.repository.AccountRepo;
import com.accountOpening.repository.ClientRepo;
import com.accountOpening.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/searchClient")
    public String clientSearch(ModelMap modelMap){
        return "SearchClient";
    }

    @GetMapping("/searchAccount")
    public String accountSearch(){
        return "SearchAccount";
    }


    @PostMapping("/searchClient")
    public String showClientById(@RequestParam Long clientId, ModelMap modelMap){
        Optional<Client> clients = Optional.ofNullable(clientRepo.findById(clientId).orElse(null));
        if(clients.isPresent()){
            modelMap.addAttribute("list",clients.get());
        }
        return "SearchClient";
    }

    @PostMapping("/searchAccount")
    public ModelAndView showAccountById(@RequestParam() Long accountNo, ModelMap modelMap){
        modelMap.put("accountNo",accountNo);
        Optional<Account> accounts = Optional.ofNullable(accountRepo.findById(accountNo).orElse(null));
        if(accounts.isPresent()){
        modelMap.addAttribute("list",accounts.get());
        }
        return new ModelAndView("SearchAccount",modelMap);
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
