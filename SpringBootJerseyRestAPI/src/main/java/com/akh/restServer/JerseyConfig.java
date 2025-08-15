package com.akh.restServer;

import com.akh.restServer.errorHandling.exceptionMappers.BadRequestMapper;
import com.akh.restServer.errorHandling.exceptionMappers.GenericExceptionMapper;
import com.akh.restServer.errorHandling.exceptionMappers.ResourceAlreadyExistMapper;
import com.akh.restServer.errorHandling.exceptionMappers.ValidationExceptionMapper;
import com.akh.restServer.resource.GameResource;
import com.akh.restServer.resource.ListingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.validation.ValidationFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(GameResource.class);
        register(ListingResource.class);

        // Enable Jersey Bean Validation integration
        register(ValidationFeature.class);

        // Exception mappers
        register(ValidationExceptionMapper.class);
        register(BadRequestMapper.class);
        register(ResourceAlreadyExistMapper.class);
        register(GenericExceptionMapper.class);
    }
}
