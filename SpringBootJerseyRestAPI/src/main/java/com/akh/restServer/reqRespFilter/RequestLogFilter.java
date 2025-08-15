package com.akh.restServer.reqRespFilter;

import jakarta.ws.rs.container.*;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class RequestLogFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext ctx) throws IOException {
        System.out.println(">> " + ctx.getMethod() + " " + ctx.getUriInfo().getRequestUri());
    }
}