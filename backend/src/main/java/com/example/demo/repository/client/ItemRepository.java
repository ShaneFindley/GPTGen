package com.example.demo.repository.client;

import com.example.demo.model.client.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Add custom queries as needed
}
