package com.gypsee.poc.gypsee_poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gypsee.poc.gypsee_poc.entity.Alert;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
	
	//("SELECT COUNT(a) FROM Alert a WHERE a.driver.id = :driverId AND a.driver.km = :km");
    int countByDriverKmGreaterThan(int km);
    List<Alert> findByDriverId(Long driverId);
}
