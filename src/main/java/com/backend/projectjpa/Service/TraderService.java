package com.backend.projectjpa.Service;

import com.backend.projectjpa.Entity.Trader;
import com.backend.projectjpa.Repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TraderService {
    @Autowired
    private TraderRepository traderRepository;



    public List<Trader>findAll(){

        return traderRepository.findAll();
    }


    public Trader findById(Long id ){
        return traderRepository.findById(id).orElseThrow();
    }
    public List<Trader> findByName(String name ){
        return traderRepository.findByName(name);
    }



    public Trader insert(Trader trader){
        return traderRepository.save(trader);
    }
    public Trader update(Trader trader){
        Date date =new Date();
        trader.setRegistrationDate(date);
        return  traderRepository.save(trader);
    }

    public void delete(Trader trader){
        traderRepository.delete(trader);

    }

    public void deleteAll(){
        traderRepository.deleteAll();
    }


}
