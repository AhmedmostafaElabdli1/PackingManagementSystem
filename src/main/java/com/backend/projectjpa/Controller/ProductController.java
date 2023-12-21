package com.backend.projectjpa.Controller;

import com.backend.projectjpa.Entity.Product;
import com.backend.projectjpa.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/test")
    public String test(){
        return "it is good";
    }


    @GetMapping("/findByCategory")
    public List<Product> findByCategory(@RequestParam String category){
        return productService.findByCategory(category);
    }
    @GetMapping("/findByName")
    public Product findByName( String product_name){
        return productService.findByName(product_name);
    }

    @GetMapping("/findPackingQuantityByName")
    public int findPackingQuantityByName( String product_name){
        return productService.findPackingQuantityByName(product_name);
    }
    @GetMapping("/findUnPackingQuantityByName")
    public int findUnPackingQuantityByName( String product_name){
        return productService.findUnPackingQuantityByName(product_name);
    }



    @GetMapping("/findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }


    @PostMapping("/createNewProduct")
    public Product insert(@RequestBody  Product product){
        return productService.insert(product);
    }


    @PutMapping("/updatePackingQuantityByName")
    public Product updatePackingQuantityByName(@RequestParam String product_name , @RequestParam int packing_quantity){


        return  productService.updatePackingQuantityByName(product_name , packing_quantity);
    }

    @PutMapping("/updateUnPackingQuantityByName")
    public Product updateUnPackingQuantityByName(@RequestParam String product_name , @RequestParam int unpacking_quantity){


        return  productService.updateUnPackingQuantityByName(product_name , unpacking_quantity);
    }
    @PutMapping("/update")
    public Product update(@RequestBody Product product){
//        Date date =new Date();
//        User.(date);
        return  productService.update(product);
    }

    @GetMapping ("/deleteByName")
    public void deleteByName(@RequestParam("product_name") String product_name){
        productService.deleteByName(product_name);
    }




    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        productService.deleteAll();
    }



}
