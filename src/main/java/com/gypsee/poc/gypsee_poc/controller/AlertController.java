package com.gypsee.poc.gypsee_poc.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gypsee.poc.gypsee_poc.entity.Alert;
import com.gypsee.poc.gypsee_poc.service.AlertService;

@RestController
@RequestMapping("/api")
public class AlertController {
	

	private final AlertService alertService;
	
	public AlertController(AlertService alertService) {
	
		this.alertService = alertService;
	}


	@PostMapping("/alert")
	public ResponseEntity<Alert> saveAlert(@RequestBody Alert alert){
		Alert a = alertService.saveAlert(alert);
		return new ResponseEntity<Alert>(a, HttpStatus.CREATED);
	}
	
	@GetMapping("/{driverId}/alerts/count")
    public ResponseEntity<Map<String, Long>> countAlertsByType(@PathVariable Long driverId) {
        Map<String, Long> alertCounts = alertService.countAlertsByType(driverId);
        return ResponseEntity.ok(alertCounts);
    }


}
