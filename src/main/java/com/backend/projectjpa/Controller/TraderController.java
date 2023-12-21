package com.backend.projectjpa.Controller;

import com.backend.projectjpa.Entity.Trader;
import com.backend.projectjpa.Service.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/trader")
public class TraderController {
    @Autowired
    private TraderService traderService;
    @GetMapping("/findAll")
    public List<Trader>findAll(){
         return   traderService.findAll();
    }

    @GetMapping("/findByName")
    public List<Trader>findByName(@RequestParam String name){
        return   traderService.findByName(name);
    }


    @PostMapping("/create")
    public Trader insert(@RequestBody Trader trader){

        Date date =new Date();
        trader.setRegistrationDate(date);
        return traderService.insert(trader);
    }
    @PutMapping("/update")
    public Trader update(@RequestBody Trader trader){

        return traderService.update(trader);

    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        traderService.deleteAll();
    }
}
