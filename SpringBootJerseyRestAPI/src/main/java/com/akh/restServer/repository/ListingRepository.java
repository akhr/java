package com.akh.restServer.repository;

import com.akh.restServer.model.listingAPI.CreateListingInput;
import com.akh.restServer.model.listingAPI.Listing;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ListingRepository {
	Map<String, Listing> listingsInMemDB = new HashMap<>();

	public Listing createListing(String title, Listing newListing, Boolean mockError) throws Exception {
		if(mockError)
			throw new IllegalArgumentException("Invalid input. Throwing error from ListingService");
		listingsInMemDB.put(title, newListing);
		return listingsInMemDB.get(title);
	}
}
