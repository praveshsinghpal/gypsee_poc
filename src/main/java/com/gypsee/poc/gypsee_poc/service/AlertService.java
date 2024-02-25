package com.gypsee.poc.gypsee_poc.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gypsee.poc.gypsee_poc.entity.Alert;
import com.gypsee.poc.gypsee_poc.repository.AlertRepository;

@Service
public class AlertService {
	
	private final AlertRepository alertRepository;

	public AlertService(AlertRepository alertRepository) {
		this.alertRepository = alertRepository;
	}
	
	public Alert saveAlert(Alert alert) {
		return alertRepository.save(alert);
		
	}
	
	   
	   public Map<String, Long> countAlertsByType(Long driverId) {
		    List<Alert> alerts = alertRepository.findByDriverId(driverId);
		    return alerts.stream()
		            .collect(Collectors.groupingBy(Alert::getAlertType, Collectors.counting()));
		}
	
	

}
