package com.akh.restServer.errorHandling.exceptionMappers;

import com.akh.restServer.errorHandling.model.ErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.*;

import java.util.List;
import java.util.stream.Collectors;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	@Override
	public Response toResponse(ConstraintViolationException ex) {
		List<String> violations = ex.getConstraintViolations()
				.stream()
				.map(ConstraintViolation::getMessage)
				.collect(Collectors.toList());

		ErrorResponse error = ErrorResponse.of(
				"VALIDATION_ERROR",
				"Request validation failed",
				Response.Status.BAD_REQUEST.getStatusCode(),
				violations
		);

		return Response.status(Response.Status.BAD_REQUEST)
				.entity(error)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
