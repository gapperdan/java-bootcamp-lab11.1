package com.jits.core;

public abstract class Parcel {

	public enum DeliveryMethod {
		AIR, GROUND
	}
	
	public enum PackageStatus {
		APPROVED, CANCELLED, SHIPPED
	}
	
	private String id;
	private Address destination;
	private Address origin;
	private DeliveryMethod deliveryMethod;
	private PackageStatus packageStatus; 
	
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

	public DeliveryMethod getDeliveryType() {
		return deliveryMethod;
	}

	public void setDeliveryType(DeliveryMethod deliveryType) {
		this.deliveryMethod = deliveryType;
	}
	
	public boolean hasValidId() {
		boolean valid = false;
		if (getId() == null || "".equals(getId())) {
			valid = false;
		} else {
			valid = true;
		}
			
		return valid;
	}

	public PackageStatus getPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(PackageStatus packageStatus) {
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
		builder.append(", deliveryMethod=");
		builder.append(deliveryMethod);
		builder.append(", packageStatus=");
		builder.append(packageStatus);
		builder.append("]");
		return builder.toString();
	}

}
