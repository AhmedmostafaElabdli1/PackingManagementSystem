package com.backend.projectjpa.Repository;

import com.backend.projectjpa.Entity.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraderRepository extends JpaRepository<Trader,Long> {

    @Query("SELECT t from Trader t where t.trader_name = :name")
    List<Trader> findByName(@Param("name") String name);

}
