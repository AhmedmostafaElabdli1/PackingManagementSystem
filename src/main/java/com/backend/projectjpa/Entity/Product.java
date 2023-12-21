package com.backend.projectjpa.Entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column( nullable = false)
    private String product_name;


    @Column( nullable = false)
    private Double price;

    @Column( nullable = false)
    private Integer packing_quantity;

    @Column(nullable = false)
    private Integer unpacking_quantity;

    private String category;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }



    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPacking_quantity() {
        return packing_quantity;
    }

    public void setPacking_quantity(Integer packing_quantity) {
        this.packing_quantity = packing_quantity;
    }

    public Integer getUnpacking_quantity() {
        return unpacking_quantity;
    }

    public void setUnpacking_quantity(Integer unpacking_quantity) {
        this.unpacking_quantity = unpacking_quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

