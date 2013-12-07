package com.jits.core;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.jits.core.DeliveryRequest.DeliveryType;

public class DeliveryRequestTest {
	private DeliveryRequest req;
	private Map<String, String> dataMap = new HashMap<String, String>();
	
	@Before
	public void setup() {
		dataMap.put("id", "id");
		dataMap.put("type", "LG");
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
		dataMap.put("lType", "plain");
		dataMap.put("height", "1");
		dataMap.put("width", "2");
		dataMap.put("depth", "3");
		
		req = new DeliveryRequest(dataMap);
	}

	@Test
	public void testDeliveryIdNotNull() {
		assertNotNull(req.getId());
	}
	
	@Test
	public void testDeliveryRequestToName() {
		assertEquals("bob", req.getToName());
	}
	
	@Test
	public void testDeliveryTypeLG() {
		assertEquals(DeliveryType.LG, req.getType());
	}

}
