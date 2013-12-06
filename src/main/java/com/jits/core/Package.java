package com.jits.core;

public class Package {

	public enum DELIVERY_TYPE {
		AIR, GROUND
	}
	
	public enum PACKAGE_STATUS {
		APPROVED, CANCELLED, SHIPPED
	}
	
	private String id;
	private Address destination;
	private Address origin;
	private DELIVERY_TYPE deliveryType;
	private PACKAGE_STATUS packageStatus; 
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
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

	public DELIVERY_TYPE getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DELIVERY_TYPE deliveryType) {
		this.deliveryType = deliveryType;
	}
	
	public boolean isValid() {
		if (getId() == null) return false;
		return (!getId().equals(""));
	}

	public PACKAGE_STATUS getPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(PACKAGE_STATUS packageStatus) {
		this.packageStatus = packageStatus;
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
		builder.append(", deliveryType=");
		builder.append(deliveryType);
		builder.append(", packageStatus=");
		builder.append(packageStatus);
		builder.append("]");
		return builder.toString();
	}

}
