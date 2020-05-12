package com.app.service.repository;

import com.app.service.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("from Item i where i.userId = :userId")
    List<Item> findAll(@Param("userId") Long userId);
}
