package com.gypsee.poc.gypsee_poc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gypsee.poc.gypsee_poc.entity.Driver;
import com.gypsee.poc.gypsee_poc.service.DriverService;

@RestController
@RequestMapping("/api")
public class DriverController {
	
	private final DriverService driverService;
	
	public DriverController(DriverService driverService) {
		this.driverService = driverService;
	}

	@PostMapping("/driver")
	public ResponseEntity<Driver> saveDriver(@RequestBody Driver driver){
		Driver d = driverService.saveDriver(driver);
		return new ResponseEntity<Driver>(d, HttpStatus.CREATED);} 
	

}
