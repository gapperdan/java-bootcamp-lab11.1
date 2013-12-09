package com.jits.core;


public class Delivery {
	private Parcel parcel;
	private DeliveryMethod deliveryMethod;
	private DeliveryStatus deliveryStatus; 

	public Parcel getParcel() {
		return parcel;
	}

	public void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}
	
	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	
	public DeliveryStatus getPackageStatus() {
		return deliveryStatus;
	}

	public void setPackageStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

}
