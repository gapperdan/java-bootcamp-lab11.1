package com.jits.core;

import java.util.Map;

import com.jits.transfer.IConfirmation;
import com.jits.util.LoggingUtil;

public class DeliveryController {//TODO: private

	private static final double INSURANCE_RATE = 0.10;
	
	Map<String, String> inputDataMap;

	Delivery delivery;
	Parcel parcel;
	Address originAddress;
	Address destinationAddress;
	double shippingCost;
	double deliveryTime;
	Confirmation confirmation;

	public DeliveryController(Map<String, String> dataMap) {
		
		setInputDataMap(dataMap);
		createParcel();
		createDelivery();
		buildDelivery();
	}

	public void buildDelivery() {
		delivery.calculateShippingCost();
		if (delivery.isInsured() && delivery.getParcel().isInsurable()) {
			delivery.applyInsurance(INSURANCE_RATE);
		}
		delivery.calculateDeliveryTime();
		Confirmation confirmation = getConfirmationForDelivery();
		setConfirmation(confirmation);
	}

	public void createParcel() {
		if (getInputDataMap().get("type").toString().startsWith("L")) {
			this.parcel = ParcelFactory.createParcel(Letter.LETTER);
			Letter letter = (Letter) parcel;
			letter.setType(LetterType.valueOf(getInputDataMap().get("lType")));
		} else if (getInputDataMap().get("type").toString().startsWith("B")) {
			this.parcel = ParcelFactory.createParcel(Box.BOX);
			Box box = (Box) parcel;
			box.setHeight(Integer.parseInt(getInputDataMap().get("height")));
			box.setWidth(Integer.parseInt(getInputDataMap().get("width")));
			box.setDepth(Integer.parseInt(getInputDataMap().get("depth")));
		}
		
		Address address;
		address = createAddress(getInputDataMap().get("fromName"), getInputDataMap().get("fromStreet"), getInputDataMap().get("fromCity"),
				getInputDataMap().get("fromState"), getInputDataMap().get("fromZip"));

		this.parcel.setOrigin(address);

		address = createAddress(getInputDataMap().get("toName"), getInputDataMap().get("toStreet"), getInputDataMap().get("toCity"),
				getInputDataMap().get("toState"), getInputDataMap().get("toZip"));

		this.parcel.setDestination(address);

		this.parcel.setId(Long.parseLong(getInputDataMap().get("id")));
		double weight = parcel.calculateWeight(this);
		this.parcel.setWeight(weight);
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void createDelivery() {
		if (getInputDataMap().get("type").toString().endsWith("A")) {
			delivery = new AirDelivery();
		} else if (getInputDataMap().get("type").toString().endsWith("G")) {
			delivery = new GroundDelivery();
		} else if (getInputDataMap().get("type").toString().endsWith("R")) {
			delivery = new RailDelivery();
		}
		
		delivery.setInsured(Boolean.valueOf(getInputDataMap().get("insured")));
		delivery.setParcel(this.parcel);
	}
	
	private Address createAddress(String name, String street, String city,
			String state, String zip) {
		Address address = new Address(name, street, city, state, zip);
		return address;
	}
	
	public Parcel getParcel() {
		return parcel;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public double getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(double deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	public Confirmation getConfirmationForDelivery() {
		Confirmation c = new Confirmation();
		c.setDelivery(delivery);
		return c;
	}

	public void approveDelivery(IConfirmation c) {
		LoggingUtil.log(c);
		delivery.approveDelivery();
	}
	
	public void cancelDelivery() {
		delivery.setDeliveryStatus(DeliveryStatus.CANCELLED);
	}
	
	public Map<String, String> getInputDataMap() {
		return inputDataMap;
	}

	public void setInputDataMap(Map<String, String> inputDataMap) {
		this.inputDataMap = inputDataMap;
	}

	public Confirmation getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(Confirmation confirmation) {
		this.confirmation = confirmation;
	}
}