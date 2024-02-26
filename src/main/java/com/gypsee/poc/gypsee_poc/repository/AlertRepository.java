package com.gypsee.poc.gypsee_poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gypsee.poc.gypsee_poc.entity.Alert;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
	
	//@Query("SELECT COUNT(a) FROM Alert a WHERE a.driver.id = :driverId AND a.driver.km = :km");
    //int countByDriverKmGreaterThan(int km);
    List<Alert> findByDriverId(Long driverId);
    
    @Query("SELECT a.alertType, COUNT(a) FROM Alert a " +
            "INNER JOIN a.driver d " +
            "WHERE d.km <= :range " +
            "GROUP BY a.alertType")
    List<Object[]> findAlertCountByTypeWithinRange(@Param("range") int range);
}
