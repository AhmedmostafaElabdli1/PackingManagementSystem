package com.backend.projectjpa.Controller;

import com.backend.projectjpa.Entity.Market;
import com.backend.projectjpa.Service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/market")
public class MarketController {

        @Autowired
        private MarketService marketService;

        @GetMapping("/findAll")
        public List<Market> findAll(){
            List<Market> markets = marketService.findAll();
            return markets;
        }

        @GetMapping("/findById")
        public Market findById(@RequestParam Long market_id) {
            Market market = marketService.findById(market_id);
            return market;
        }

        @PostMapping("/create")
        public Market createMarket(@RequestBody Market market) {
            Market createdMarket = marketService.insert(market);
            return createdMarket;
        }

        @PutMapping("/update")
        public Market updateMarket(@RequestBody Market market) {
            // Set the ID to ensure it is the correct market being updated
            Market updatedMarket = marketService.update(market);
            return updatedMarket;
        }

        @DeleteMapping("/deleteById")
        public void deleteMarket(@RequestParam("market_id") Long id) {
            Market marketToDelete = marketService.findById(id);
            marketService.delete(marketToDelete);

        }

        @DeleteMapping("/deleteAll")
        public void deleteAllMarkets() {
            marketService.deleteAll();

        }

}
