package com.jits.core;

import com.jits.util.ICalculator;
import com.jits.util.ShippingCalculatorProxy;

public abstract class Delivery {
	private Parcel parcel;
	private DeliveryStatus deliveryStatus; 
	private double deliveryTime;
	private double shippingCost;
	boolean isInsured;

	abstract public void calculateDeliveryTime() ;
	abstract public void calculateShippingCost();
	
	public Delivery() {
		deliveryStatus = DeliveryStatus.INITIAL;
	}
	
	public Parcel getParcel() {
		return parcel;
	}

	public void setParcel(Parcel parcel) {
		this.parcel = parcel;
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
	
	public String getFromZip() {
		return getParcel().getOrigin().getZip();
		
	}
	public String getToZip() {
		return getParcel().getDestination().getZip();
	}
	
	public boolean isInsured() {
		return isInsured;
	}
	
	public void setInsured(boolean isInsured) {
		this.isInsured = isInsured;
	}
	
	public void applyInsurance(double insuranceRate) {
		ICalculator calc = new ShippingCalculatorProxy();
         		
		double costWithInsurance = calc.applyInsurance(getShippingCost(), insuranceRate);
		setShippingCost(costWithInsurance);
	}

	@Override
	public String toString() {
	
		StringBuilder builder = new StringBuilder();
		builder.append("Delivery [parcel=");
		builder.append(parcel);
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