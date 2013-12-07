package com.jits.core;

import java.util.Map;

public class DeliveryRequest {
	
	public enum DeliveryType { 
		LG, LA, BG, BA 
	}

	private DeliveryType type;
	private String id;
	private String toName;
	private String toStreet;
	private String toCity;
	private String toState;
	private String toZip;
	private String fromName;
	private String fromStreet;
	private String fromCity;
	private String fromState;
	private String fromZip;
	private String lType;
	private String height;
	private String width;
	private String depth;
	
	public DeliveryRequest(Map<String, String> dataMap) {
//		String t = m.get("type");
//		if (t.equalsIgnoreCase("LG")) {
//			setType(DELIVERY_TYPE.LG);
//		} else if (t.equalsIgnoreCase("LA")) {
//			setType(DELIVERY_TYPE.LA);
//		} else if (t.equalsIgnoreCase("BG")) {
//			setType(DELIVERY_TYPE.BG);
//		} else if (t.equalsIgnoreCase("BA")) {
//			setType(DELIVERY_TYPE.BA);
//		}
		
		setType(DeliveryType.valueOf(dataMap.get("type")));
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
	}
	
	public Object getId() {
		return this.id;
	}
	public DeliveryType getType() {
		return type;
	}
	public void setType(DeliveryType type) {
		this.type = type;
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
}
