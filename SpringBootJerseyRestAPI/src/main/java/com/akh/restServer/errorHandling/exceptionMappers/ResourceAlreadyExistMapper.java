package com.akh.restServer.errorHandling.exceptionMappers;

import com.akh.restServer.errorHandling.model.ErrorResponse;
import com.akh.restServer.errorHandling.customExceptions.ResourceAlreadyExistsException;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.*;

@Provider
public class ResourceAlreadyExistMapper implements ExceptionMapper<ResourceAlreadyExistsException> {
	@Override
	public Response toResponse(ResourceAlreadyExistsException ex) {
		ErrorResponse error = ErrorResponse.of(
				"RESOURCE_CONFLICT",
				ex.getMessage(),
				Response.Status.CONFLICT.getStatusCode(),
				null
		);

		return Response.status(Response.Status.CONFLICT)
				.entity(error)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
