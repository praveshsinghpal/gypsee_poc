package com.gypsee.poc.gypsee_poc.service;

import org.springframework.stereotype.Service;

import com.gypsee.poc.gypsee_poc.entity.Driver;
import com.gypsee.poc.gypsee_poc.repository.DriverRepository;

@Service
public class DriverService {
	
	private final DriverRepository driverRepository;

	public DriverService(DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}
	
	
	public Driver saveDriver(Driver driver) {
		return driverRepository.save(driver);
		
	}

}
