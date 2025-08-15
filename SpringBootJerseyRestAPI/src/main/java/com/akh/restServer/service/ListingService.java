package com.akh.restServer.service;

import com.akh.restServer.model.listingAPI.Amenity;
import com.akh.restServer.model.listingAPI.CreateListingInput;
import com.akh.restServer.model.listingAPI.Listing;
import com.akh.restServer.repository.ListingRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ListingService {

	private final ListingRepository listingRepository;

	public ListingService(ListingRepository listingRepository) {
		this.listingRepository = listingRepository;
	}

	public Listing createListing(CreateListingInput createListingInput) throws Exception {
		Listing newListing = Listing.builder()
				.id(StringUtils.isNotBlank(createListingInput.getId()) ? createListingInput.getId() : UUID.randomUUID().toString())
				.title(createListingInput.getTitle())
				.description(createListingInput.getDescription())
				.numOfBeds(createListingInput.getNumOfBeds())
				.costPerNight(createListingInput.getCostPerNight())
				.closedForBookings(createListingInput.getClosedForBookings())
				.amenities(createAmenities(createListingInput))
				.build();
		return listingRepository.createListing(createListingInput.getTitle(), newListing, createListingInput.getMockError());
	}

	public List<Amenity> createAmenities(CreateListingInput createListingInput) throws Exception {
		return createListingInput.getAmenities().stream()
				.map(amenityId -> Amenity.builder()
					.id(amenityId)
					.name("NameOf-"+amenityId)
					.category("CategoryOf-"+amenityId)
					.build()
				)
				.collect(Collectors.toList());
	}
}
