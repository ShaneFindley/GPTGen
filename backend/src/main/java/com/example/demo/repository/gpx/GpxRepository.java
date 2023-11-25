package com.example.demo.repository.gpx;

import com.example.demo.model.gpx.GpxData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpxRepository extends JpaRepository<GpxData, Long> {
    // Add custom queries as needed
}
