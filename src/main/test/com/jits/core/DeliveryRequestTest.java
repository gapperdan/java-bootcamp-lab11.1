package com.jits.core;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.jits.core.DeliveryRequest.DELIVERY_TYPE;

public class DeliveryRequestTest {
	private DeliveryRequest req;
	private HashMap m = new HashMap<String, String>();
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		m.put("id", "id");
		m.put("type", "LG");
		m.put("toName", "bob");
		m.put("toStreet", "terry st");
		m.put("toCity", "sf");
		m.put("toState", "ca");
		m.put("toZip", "94105");
		m.put("fromName", "joe");
		m.put("fromStreet", "mission blvd");
		m.put("fromCity", "sb");
		m.put("fromState", "ca");
		m.put("fromZip", "94066");
		m.put("lType", "plain");
		m.put("height", "1");
		m.put("width", "2");
		m.put("depth", "3");
		
		req = new DeliveryRequest(m);
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
		assertEquals(DELIVERY_TYPE.LG, req.getType());
	}
}
