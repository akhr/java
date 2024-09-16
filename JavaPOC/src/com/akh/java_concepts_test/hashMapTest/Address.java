package com.akh.java_concepts_test.hashMapTest;

public class Address {

	String street;
	String city;
	String state;

	public Address(String street, String city, String state) {
		this.street = street;
		this.city = city;
		this.state = state;
	}

	@Override
	public int hashCode(){
		int hash = 0;
		hash = street.hashCode() + state.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object o){
		Address o1 = (Address)o;
		if(o1.street.equals(this.street) && o1.city == this.city && o1.state == this.state)
			return true;
		return false;
	}
}
