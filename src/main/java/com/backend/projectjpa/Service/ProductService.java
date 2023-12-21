package com.backend.projectjpa.Service;

import com.backend.projectjpa.Entity.Product;
import com.backend.projectjpa.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository ;



    public List<Product> findAll(){

        return productRepository.findAll();
    }

    public List<Product>findByCategory(String category){

        return productRepository.findByCategory(category);
    }
    public Product findByName(String name){

        return productRepository.findByName(name);
    }
    public Product updatePackingQuantityByName(String name , int newQuantity){
        Product product = findByName(name);

        product.setPacking_quantity(findPackingQuantityByName(name)+newQuantity);
        product.setUnpacking_quantity(findUnPackingQuantityByName(name)-newQuantity);
        update(product);
        return product;
    }
    public Product updateUnPackingQuantityByName(String name , int newQuantity){
        Product product = findByName(name);

        product.setUnpacking_quantity(findUnPackingQuantityByName(name)+newQuantity);
        update(product);
        return product;
    }
    public int findPackingQuantityByName(String name){
        return productRepository.findByName(name).getPacking_quantity();
    }
    public int findUnPackingQuantityByName(String name){
        return productRepository.findByName(name).getUnpacking_quantity();
    }


    public Product findById(Long id ){
        return productRepository.findById(id).orElseThrow();
    }

//    public Product addPackingQuantity(String product_name , int quantity){
//
//        Product product =productRepository.findByName(product_name);
//        int oldQuantity = product.getPacking_quantity();
//        product.setPacking_quantity(oldQuantity + quantity);
//        product.setUnpacking_quantity(oldQuantity - quantity);
//       productRepository.save(product);
//       return product;
//    }
//    public Product addUnPackingQuantity(String product_name , int quantity){
//
//        Product product =productRepository.findByName(product_name);
//        int oldQuantity = product.getUnpacking_quantity();
//        product.setUnpacking_quantity(oldQuantity + quantity);
//        productRepository.save(product);
//        return product;
//    }

    public Product insert(Product product){
        return productRepository.save(product);
    }
    public Product update(Product product){
//        Date date =new Date();
//        User.(date);
        return  productRepository.save(product);
    }
    public void deleteByName(String name){
       Product product= productRepository.findByName(name);
          delete(product);

    }
    public void delete(Product product){
        productRepository.delete(product);

    }

    public void deleteAll(){
        productRepository.deleteAll();
    }

}
