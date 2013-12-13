package com.jits.core;

import com.jits.transfer.IConfirmation;

public class Confirmation implements IConfirmation {
	
	private Delivery delivery;
	
	@Override
	public String getStatus() {
		return delivery.getDeliveryStatus().toString();
	}
	@Override
	public Address getOrigin() {
		return delivery.getParcel().getOrigin();
	}
	
	@Override
	public Address getDest() {
		return delivery.getParcel().getDestination();
	}
	
	@Override
	public String getPackageType() {
		return delivery.getParcel().getClass().getSimpleName();
	}
	
	@Override
	public String getDeliveryType() {
		return delivery.getClass().getSimpleName();
	}
	
	@Override
	public double getWeight() {
		return delivery.getParcel().getWeight();
	}
	
	@Override
	public boolean isInsured() {
		return delivery.isInsured();
	}
	
	@Override
	public double getDeliveryTime() {
		return delivery.getDeliveryTime();
	}
	
	@Override
	public double getCost() {
		return delivery.getShippingCost();
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	
}
