package com.jits.core;

public abstract class Parcel {

	private long id;
	private Address destination;
	private Address origin;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Address getDestination() {
		return destination;
	}

	public void setDestination(Address destination) {
		this.destination = destination;
	}

	public Address getOrigin() {
		return origin;
	}

	public void setOrigin(Address origin) {
		this.origin = origin;
	}

	public boolean hasValidId() {
		boolean valid = false;
		if (getId() > 0) {
			valid = true;
		} else {
			valid = false;
		}
			
		return valid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Package [id=");
		builder.append(id);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", origin=");
		builder.append(origin);
		builder.append(", deliveryMethod=");
		builder.append(", packageStatus=");
		builder.append("]");
		return builder.toString();
	}

}
