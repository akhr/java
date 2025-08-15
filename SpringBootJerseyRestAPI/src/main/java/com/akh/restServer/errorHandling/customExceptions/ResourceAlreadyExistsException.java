package com.akh.restServer.errorHandling.customExceptions;

import jakarta.ws.rs.WebApplicationException;

public class ResourceAlreadyExistsException extends WebApplicationException {
	public ResourceAlreadyExistsException(String message) {
		super(message);
	}
}
