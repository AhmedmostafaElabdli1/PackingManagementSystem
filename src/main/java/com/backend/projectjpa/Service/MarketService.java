package com.backend.projectjpa.Service;

import com.backend.projectjpa.Entity.Market;
import com.backend.projectjpa.Repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarketService {

    @Autowired
    private MarketRepository marketRepository ;


    public List<Market> findAll(){

        return marketRepository.findAll();
    }


    public Market findById(Long id ){
        return marketRepository.findById(id).orElseThrow();
    }


    public Market insert(Market market){
        return marketRepository.save(market);
    }
    public Market update(Market market){
//        Date date =new Date();
//        User.(date);
        return  marketRepository.save(market);
    }

    public void delete(Market market){
        marketRepository.delete(market);

    }

    public void deleteAll(){
        marketRepository.deleteAll();
    }




}
