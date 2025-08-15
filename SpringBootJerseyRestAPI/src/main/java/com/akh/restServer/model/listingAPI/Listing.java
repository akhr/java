package com.akh.restServer.model.listingAPI;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Listing {
	private String id;
	private String title;
	private String description;
	private int numOfBeds;
	private double costPerNight;
	private Boolean closedForBookings;
	private List<Amenity> amenities;
}
