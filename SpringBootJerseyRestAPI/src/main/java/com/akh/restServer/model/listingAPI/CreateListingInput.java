package com.akh.restServer.model.listingAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateListingInput {
	private String id;
	private String title;
	private String description;
	private int numOfBeds;
	private double costPerNight;
	private Boolean closedForBookings;
	private List<String> amenities;
	private Boolean mockError;
}
