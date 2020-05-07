package com.acelerit.service.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.acelerit.model.entity.LoggingEntity;
import com.acelerit.repository.LoggingRepository;
import com.acelerit.service.exception.LoggingNotFoundExeception;


@Service
public class LoggingServiceImpl implements LoggingService {

	@Value("${employee.not.found}")
	private String not_found;

	@Autowired
	private LoggingRepository loggingRepository;

	public List<LoggingEntity> getAllLoggingDetails() {
		return loggingRepository.findAll();
	}

	public Optional<LoggingEntity> getLoggerById(Long loggingId) throws LoggingNotFoundExeception {
		return loggingRepository.findById(loggingId);
	}

	public LoggingEntity addLoggingDetails(LoggingEntity logging) {
		return loggingRepository.save(logging);
	}

	public LoggingEntity updateLoggingDetails(Long loggingId, LoggingEntity loggingDetails)
			throws LoggingNotFoundExeception {
		LoggingEntity employee = loggingRepository.findById(loggingId)
				.orElseThrow(() -> new LoggingNotFoundExeception(not_found + " :: " + loggingId));

		employee.setEmail(loggingDetails.getEmail());
		employee.setLast_name(loggingDetails.getLast_name());
		employee.setFirst_name(loggingDetails.getFirst_name());
		final LoggingEntity updatedEmployee = loggingRepository.save(employee);
		return updatedEmployee;
	}

	public Map<String, Boolean> deleteLoggingDetils(Long loggingId) throws LoggingNotFoundExeception {
		LoggingEntity employee = loggingRepository.findById(loggingId)
				.orElseThrow(() -> new LoggingNotFoundExeception(not_found + " :: " + loggingId));

		loggingRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
