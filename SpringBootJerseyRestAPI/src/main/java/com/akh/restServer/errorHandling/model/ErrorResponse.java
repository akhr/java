package com.akh.restServer.errorHandling.model;

import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
public class ErrorResponse {
	private String code;
	private String message;
	private int status;
	private String traceId;
	private Instant timestamp;
	private List<String> details;

	public static ErrorResponse of(String code, String message, int status, List<String> details) {
		return new ErrorResponse(
				code, message, status,
				UUID.randomUUID().toString(),
				Instant.now(),
				details
		);
	}

	public ErrorResponse(String code, String message, int status, String traceId, Instant timestamp, List<String> details) {
		this.code = code;
		this.message = message;
		this.status = status;
		this.traceId = traceId;
		this.timestamp = timestamp;
		this.details = details;
	}
}
