package com.akh.restServer.errorHandling.exceptionMappers;

import com.akh.restServer.errorHandling.model.ErrorResponse;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.*;

@Provider
public class BadRequestMapper implements ExceptionMapper<BadRequestException> {
	@Override
	public Response toResponse(BadRequestException ex) {
		ErrorResponse error = ErrorResponse.of(
				"BAD_REQUEST",
				ex.getMessage() != null ? ex.getMessage() : "Invalid request format",
				Response.Status.BAD_REQUEST.getStatusCode(),
				null
		);

		return Response.status(Response.Status.BAD_REQUEST)
				.entity(error)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}