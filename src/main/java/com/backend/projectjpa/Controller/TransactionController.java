package com.backend.projectjpa.Controller;

import com.backend.projectjpa.Entity.Transaction;
import com.backend.projectjpa.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {


    @Autowired
    private TransactionService transactionService;


    @GetMapping("/findAll")
    public List<Transaction> findAll(){

        return  transactionService.findAll();
    }
    @PostMapping("/sellToTrader")
    public String sellToTrader(@RequestParam String nid , @RequestParam Long trader_id,@RequestParam  String product_name, @RequestParam int quantity) {

       return   transactionService.sellProductToTrader(nid, trader_id, product_name, quantity);
    }

    @PostMapping("/sellToMarket")
    public String sellToMarket(@RequestParam String nid , @RequestParam Long market_id,@RequestParam  String product_name, @RequestParam int quantity) {

       return transactionService.sellProductToMarket(nid, market_id, product_name, quantity);
    }



}
