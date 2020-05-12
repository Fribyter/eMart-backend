package com.app.service.repository;

import com.app.service.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("from Item i where i.name like '%:name%'")
    List<Item> findByName(@Param("name") String name);

    @Query("from Item i where i.price between :startPrice and :endPrice")
    List<Item> findByPrice(@Param("startPrice") double startPrice, @Param("endPrice") double endPrice);

}
