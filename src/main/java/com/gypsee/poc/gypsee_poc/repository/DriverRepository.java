package com.gypsee.poc.gypsee_poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gypsee.poc.gypsee_poc.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    // You can add custom methods here if needed
}