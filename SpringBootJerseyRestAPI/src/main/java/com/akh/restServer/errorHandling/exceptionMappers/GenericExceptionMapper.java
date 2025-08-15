package com.akh.restServer.errorHandling.exceptionMappers;

import com.akh.restServer.errorHandling.model.ErrorResponse;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.*;

import java.util.Arrays;
import java.util.List;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	@Override
	public Response toResponse(Throwable ex) {
		List<String> stackTrace = Arrays.stream(ex.getStackTrace())
				.map(StackTraceElement::toString)
				.toList();

		ErrorResponse error = ErrorResponse.of(
				"INTERNAL_SERVER_ERROR",
				ex.getMessage() != null ? ex.getMessage() : "Unexpected server error",
				Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
				stackTrace // optional: remove in prod
		);

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(error)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}