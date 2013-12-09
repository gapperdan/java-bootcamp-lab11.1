package com.jits.core;

import java.util.Map;

public class DeliveryRequest {
	
	DeliveryType deliveryType;
	String id;
	String toName;
	String toStreet;
	String toCity;
	String toState;
	String toZip;
	String fromName;
	String fromStreet;
	String fromCity;
	String fromState;
	String fromZip;
	String lType;
	String height;
	String width;
	String depth;
	
	Delivery delivery;
	DeliveryMethod deliveryMethod;
	Parcel parcel;
	Address originAddress;
	Address destinationAddress;
	
	public DeliveryRequest(Map<String, String> dataMap) {
		setDeliveryType(DeliveryType.valueOf(dataMap.get("type")));
		setId(dataMap.get("id"));
		setToName(dataMap.get("toName"));
		setToStreet(dataMap.get("toStreet"));
		setToCity(dataMap.get("toCity"));
		setToState(dataMap.get("toState"));
		setToZip(dataMap.get("toZip"));
		setFromName(dataMap.get("fromName"));
		setFromStreet(dataMap.get("fromStreet"));
		setFromCity(dataMap.get("fromCity"));
		setFromState(dataMap.get("fromState"));
		setFromZip(dataMap.get("fromZip"));
		setlType(dataMap.get("lType"));
		setHeight(dataMap.get("height"));
		setWidth(dataMap.get("width"));
		setDepth(dataMap.get("depth"));
		
		setDeliveryMethod();
		setParcel();
		setDelivery();
	}
	
	public String getId() {
		return this.id;
	}
	public DeliveryType getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(DeliveryType type) {
		this.deliveryType = type;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getToStreet() {
		return toStreet;
	}
	public void setToStreet(String toStreet) {
		this.toStreet = toStreet;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getToState() {
		return toState;
	}
	public void setToState(String toState) {
		this.toState = toState;
	}
	public String getToZip() {
		return toZip;
	}
	public void setToZip(String toZip) {
		this.toZip = toZip;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getFromStreet() {
		return fromStreet;
	}
	public void setFromStreet(String fromStreet) {
		this.fromStreet = fromStreet;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getFromState() {
		return fromState;
	}
	public void setFromState(String fromState) {
		this.fromState = fromState;
	}
	public String getFromZip() {
		return fromZip;
	}
	public void setFromZip(String fromZip) {
		this.fromZip = fromZip;
	}
	public String getlType() {
		return lType;
	}
	public void setlType(String lType) {
		this.lType = lType;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public void setId(String id) {
		this.id = id;
	}

	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod() {
		
		if (getDeliveryType().toString().endsWith("G")) {
			this.deliveryMethod = DeliveryMethod.GROUND; 
		} else if (getDeliveryType().toString().endsWith("A")) {
			this.deliveryMethod = DeliveryMethod.AIR;
		}
		
	}

	public Parcel getParcel() {
		return parcel;
	}

	public void setParcel() {
		if (getDeliveryType().toString().startsWith("L")) {
			this.parcel = ParcelFactory.createParcel(Letter.LETTER);
			Letter letter = (Letter) parcel;
			letter.setType(LetterType.valueOf(getlType()));
		} else if (getDeliveryType().toString().startsWith("B")) {
			this.parcel = ParcelFactory.createParcel(Box.BOX);
			Box box = (Box) parcel;
			box.setHeight(Integer.parseInt(getHeight()));
			box.setWidth(Integer.parseInt(getWidth()));
			box.setDepth(Integer.parseInt(getDepth()));
		}
		
		Address address;
		address = createAddress(getFromName(), getFromStreet(),
				getFromCity(), getFromState(), getFromZip());

		this.parcel.setOrigin(address);
		
		address = createAddress(getToName(), getToStreet(),
				getToCity(), getToState(), getToZip());
		
		this.parcel.setDestination(address);
		
		this.parcel.setId(Long.parseLong(getId()));
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery() {
		Delivery delivery = new Delivery();
		delivery.setParcel(parcel);
		delivery.setDeliveryMethod(deliveryMethod);
		this.delivery = delivery;
	}
	
	private Address createAddress(String name, String street, String city, String state, String zip) {
		Address address = new Address(name, street, city, state, zip);
		return address;
	}
}
