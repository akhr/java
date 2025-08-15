package com.akh.restServer.model.listingAPI;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Amenity {
	private String id;
	private String category;
	private String name;
}