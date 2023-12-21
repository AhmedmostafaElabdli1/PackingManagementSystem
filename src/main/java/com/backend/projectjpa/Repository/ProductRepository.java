package com.backend.projectjpa.Repository;

import com.backend.projectjpa.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product , Long> {

//    @Query("")
    public List<Product> findByCategory(String category);

//    :name --> @parm("name)
    @Query("SELECT p FROM Product p WHERE p.product_name =:name ")
    public Product findByName(@Param("name") String name);


}
