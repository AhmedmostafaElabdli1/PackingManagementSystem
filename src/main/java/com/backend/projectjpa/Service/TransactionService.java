package com.backend.projectjpa.Service;

import com.backend.projectjpa.Entity.Product;
import com.backend.projectjpa.Entity.Transaction;
import com.backend.projectjpa.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TraderService traderService;
    @Autowired
    private MarketService marketService;
    @Autowired
    private ProductService productService;



    public List<Transaction>findAll(){
        return transactionRepository.findAll();
    }

    public String sellProductToTrader(String nid , Long trader_id, String product_name, int quantity) {
        // Create a new transaction
            // Create a new transaction
            Transaction transaction = new Transaction();
            if (userService.findByNid(nid) == null) {
                return "User Not Found";
            } else {
                transaction.setSalesman(userService.findByNid(nid));
            }

            if (traderService.findById(trader_id) == null) {
                return "Trader Not Found";
            } else {
                transaction.setTrader(traderService.findById(trader_id));
            }
            if (productService.findByName(product_name) == null) {
                return "Product Not Found";
            } else {
                transaction.setProduct(productService.findByName(product_name));
            }

            transaction.setMarket(null);
            if (quantity <= productService.findByName(product_name).getPacking_quantity()) {

                transaction.setQuantity(quantity);
                transaction.setTransactionDate(new Date());

                transaction.setTotal_price(productService.findByName(product_name).getPrice() * quantity);

                transaction.setTransactionDate(new Date());

                // Update relevant entities
                // Deduct product quantity, update transactions, etc.

                // Save the transaction to the database
                transactionRepository.save(transaction);
                Product product = productService.findByName(product_name);
                product.setPacking_quantity(product.getPacking_quantity() - quantity);
                productService.update(product);
                return "Transaction is Success Qantity :" + product.getPacking_quantity();
            } else {
                return " Quantity not Allow ";
            }

        }


        public String  sellProductToMarket(String nid , Long market_id, String product_name, int quantity) {
        // Create a new transaction
            Transaction transaction = new Transaction();
            if(userService.findByNid(nid) ==null ) {
                return "User Not Found";
            }
            else{
                transaction.setSalesman(userService.findByNid(nid));
            }

            if(marketService.findById(market_id) ==null ) {
                return "Market Not Found";
            }
            else{
                transaction.setMarket(marketService.findById(market_id));
            }
            if(productService.findByName(product_name) ==null ) {
                return "Product Not Found";
            }
            else{
                transaction.setProduct(productService.findByName(product_name));
            }

            transaction.setTrader(null);
            if(quantity <= productService.findByName(product_name).getPacking_quantity()) {

                transaction.setQuantity(quantity);
                transaction.setTransactionDate(new Date());

                transaction.setTotal_price(productService.findByName(product_name).getPrice() * quantity);

                transaction.setTransactionDate(new Date());

                // Update relevant entities
                // Deduct product quantity, update transactions, etc.

                // Save the transaction to the database
                transactionRepository.save(transaction);
                Product product =productService.findByName(product_name);
                product.setPacking_quantity(product.getPacking_quantity() - quantity);
                productService.update(product);
                return "Transaction is Success Qantity :"+product.getPacking_quantity();
            }
            else {
                return " Quantity not Allow and ";
            }
    }


}
