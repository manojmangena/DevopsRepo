package com.acelerit.service.api;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acelerit.model.entity.LoggingEntity;
import com.acelerit.service.exception.LoggingNotFoundExeception;

@Service
public interface LoggingService {
	//added by manoj mangena
	public List<LoggingEntity> getAllLoggingDetails();
	public Optional<LoggingEntity> getLoggerById(Long loggingId) throws LoggingNotFoundExeception;
	public LoggingEntity addLoggingDetails(LoggingEntity logging);
	public Map<String, Boolean> deleteLoggingDetils(Long loggingId)	throws LoggingNotFoundExeception; 
	public LoggingEntity updateLoggingDetails(Long loggingId,LoggingEntity loggingDetails) throws LoggingNotFoundExeception;
}
