package com.jits;

import java.util.HashMap;
import java.util.Map;

import com.jits.core.Confirmation;
import com.jits.core.DeliveryController;

public class JitsClient {

	Map<String, String> dataMap = new HashMap<String, String>();
	DeliveryController controller;
	Confirmation confirmation;
	
	public static void main(String[] args) {
		
		JitsClient jitsClient = new JitsClient();
		jitsClient.createDelivery();
		jitsClient.getDeliveryInfo();
		jitsClient.approveDelivery();
		jitsClient.cancelDelivery();
		
	}

	void createDelivery() {
		dataMap.put("id", "777");
		dataMap.put("type", "LA"); 
		dataMap.put("toName", "bob");
		dataMap.put("toStreet", "terry st");
		dataMap.put("toCity", "sf");
		dataMap.put("toState", "ca");
		dataMap.put("toZip", "94105");
		dataMap.put("fromName", "joe");
		dataMap.put("fromStreet", "mission blvd");
		dataMap.put("fromCity", "sb");
		dataMap.put("fromState", "ca");
		dataMap.put("fromZip", "94066");
		dataMap.put("lType", "PLAIN");
		dataMap.put("height", "1");
		dataMap.put("width", "2");
		dataMap.put("depth", "3");
		
		controller = new DeliveryController(dataMap);
	}
	
	Confirmation getDeliveryInfo() {
		return controller.getConfirmationForDelivery();
	}
	
	void approveDelivery() {
		controller.approveDelivery(getDeliveryInfo());
	}
	
	void cancelDelivery() {
		controller.cancelDelivery();
	}
	
}
