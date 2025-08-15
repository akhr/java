package com.akh.restServer.resource;

import com.akh.restServer.model.listingAPI.CreateListingInput;
import com.akh.restServer.model.listingAPI.Listing;
import com.akh.restServer.service.ListingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.HashMap;
import java.util.Map;


@Component
@Path("/api/v1")
public class ListingResource {

	private final ListingService listingService;

	public ListingResource(ListingService listingService) {
		this.listingService = listingService;
	}

	@POST
	@Path("/listings")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createListing(CreateListingInput createListingInput) {
		if(ObjectUtils.isEmpty(createListingInput.getMockError())){
			createListingInput.setMockError(false);
		}
		try {
			String createListingInputStr = new ObjectMapper().writeValueAsString(createListingInput);
			System.out.println("createListingInputStr: "+createListingInputStr);
			//create listing
			Listing listing = listingService.createListing(createListingInput);

			String entityJsonString = new ObjectMapper().writeValueAsString(listing);
			System.out.println("entityJsonString: "+entityJsonString);
			return Response.status(Response.Status.CREATED).entity(listing).build();
		} catch (Exception e) {
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", "Unable to create listing");
			errorResponse.put("message", e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorResponse)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
	}
}
