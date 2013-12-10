package com.jits.core;


public class Delivery {
	private Parcel parcel;
	private DeliveryMethod deliveryMethod;
	private DeliveryStatus deliveryStatus; 
	private double deliveryTime;
	private double shippingCost;

	public Delivery() {
		deliveryStatus = DeliveryStatus.INITIAL;
	}
	
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
	
	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public double getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(double deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public void approveDelivery() {
		this.deliveryStatus = DeliveryStatus.SHIPPED;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Delivery [parcel=");
		builder.append(parcel);
		builder.append(", deliveryMethod=");
		builder.append(deliveryMethod);
		builder.append(", deliveryStatus=");
		builder.append(deliveryStatus);
		builder.append(", deliveryTime=");
		builder.append(deliveryTime);
		builder.append(", shippingCost=");
		builder.append(shippingCost);
		builder.append("]");
		return builder.toString();
	}

}
