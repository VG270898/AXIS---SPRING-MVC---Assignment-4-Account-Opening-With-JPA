package com.accountOpening.controller;

import com.accountOpening.model.Account;
import com.accountOpening.model.Client;
import com.accountOpening.repository.AccountRepo;
import com.accountOpening.repository.ClientRepo;
import com.accountOpening.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

    @RequestMapping("")
    public String login(){
        return "Login";
    }


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

    @GetMapping("/register")
    public String clientRegister(ModelMap modelMap){
        return "registerClients";
    }


    @PostMapping("/searchClient")
    public ModelAndView showClientById(@RequestParam Long clientId, ModelMap modelMap){
        Optional<Client> clients = Optional.ofNullable(clientRepo.findById(clientId).orElse(null));
        if(clients.isPresent()){
        modelMap.addAttribute("list",clients.get());
        }
        return new ModelAndView("SearchClient",modelMap);
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


    @PostMapping("/register")
    public ModelAndView registerClient(@ModelAttribute Client client, @RequestParam() String password, BindingResult bindingResult, ModelMap modelMap){
        String message = accountService.openAccount(client,password);
        System.out.println(message);
        modelMap.addAttribute("message",message);
        return new ModelAndView("registerClients",modelMap);
    }

    @PostMapping("")
    public ModelAndView loginClient(@ModelAttribute Client client,@RequestParam() String password, BindingResult bindingResult, ModelMap modelMap){
        String status = accountService.verify(client.getClientId(),password);

        if(status.equals("verified")){
            return new ModelAndView("Home",modelMap);
        } else if (status.equals("wrongPass")) {
            modelMap.addAttribute("message","Wrong Password!");
            return new ModelAndView("Login",modelMap);
        }else if (status.equals("noRecord")){
            modelMap.addAttribute("message","Invalid User!");
            return new ModelAndView("Login",modelMap);
        }else {
            modelMap.addAttribute("message",status);
            return new ModelAndView("Login",modelMap);
        }
    }


}
