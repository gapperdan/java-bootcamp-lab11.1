package com.jits.core;

public class Address {
	String name;
	String street;
	String city;
	String state;
	String zip;
	
	public Address() {
		
	}
	
	public Address(String name, String street, String city, String state, String zip) {
		setName(name);
		setStreet(street);
		setCity(city);
		setState(state);
		setZip(zip);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public boolean isValid() {
		boolean isValid = false;
		if ("".equals(getName()) || getName() == null 
				|| "".equals(getStreet()) || getStreet() == null 
				|| "".equals(getCity()) || getCity() == null 
				|| "".equals(getState()) || getState() == null
				|| "".equals(getZip()) || getZip() == null) {
		} else {
			isValid = true;
		}
		return isValid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [name=");
		builder.append(name);
		builder.append(", street=");
		builder.append(street);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", zip=");
		builder.append(zip);
		builder.append("]");
		return builder.toString();
	}
}
