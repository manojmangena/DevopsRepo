package com.acelerit.web.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acelerit.model.entity.LoggingEntity;
import com.acelerit.service.api.LoggingService;
import com.acelerit.service.exception.LoggingNotFoundExeception;

@RestController
@RequestMapping("/api/v1")
public class LoggingController {

	@Autowired
	LoggingService loggingService;

	@Value("${employee.not.found}")
	private String not_found;

	@GetMapping("/loggers")
	public List<LoggingEntity> getAllLoggingDetails() {
		return loggingService.getAllLoggingDetails();
	}

	@GetMapping("/loggers/{id}")
	public ResponseEntity<LoggingEntity> getLoggerById(@PathVariable(value = "id") @Min(1) Long loggingId)
			throws LoggingNotFoundExeception {
		LoggingEntity logging = loggingService.getLoggerById(loggingId)
				.orElseThrow(() -> new LoggingNotFoundExeception(not_found + " : " + loggingId));
		return ResponseEntity.ok().body(logging);
	}

	@PostMapping("/loggers")
	public LoggingEntity createEmployee(@Valid @RequestBody LoggingEntity loggingDetails) {
		return loggingService.addLoggingDetails(loggingDetails);
	}

	@PutMapping("/loggers/{id}")
	public ResponseEntity<LoggingEntity> updateEmployee(@PathVariable(value = "id") Long loggingId,

			@Valid @RequestBody LoggingEntity loggingDetails) throws LoggingNotFoundExeception {
		LoggingEntity loggingEntity = loggingService.updateLoggingDetails(loggingId, loggingDetails);
		return ResponseEntity.ok(loggingEntity);
	}

	@DeleteMapping("/loggers/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long loggingId)
			throws LoggingNotFoundExeception {
		return loggingService.deleteLoggingDetils(loggingId);
	}

}
