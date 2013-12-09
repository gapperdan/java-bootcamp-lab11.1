package com.jits.core;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DeliveryRequestTest {

	private Map<String, String> dataMap = new HashMap<String, String>();
	private Delivery delivery;
	private DeliveryRequest request;
	
	@Before
	public void setup() {
		
		dataMap.put("id", "1");
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
		
		request = new DeliveryRequest(dataMap);
	}
	
	@Test
	public void testRequestHasADelivery() {
		delivery = request.getDelivery();
		assertNotNull(delivery);
	}
	
	@Test
	public void testRequestForLetter() {
		dataMap.put("type", "LA");
		request = new DeliveryRequest(dataMap);
		assertTrue(request.getDelivery().getParcel() instanceof Letter);
	}

	@Test
	public void testRequestForBox() {
		dataMap.put("type", "BA");
		request = new DeliveryRequest(dataMap);
		assertTrue(request.getDelivery().getParcel() instanceof Box);
	}

	@Test
	public void testRequestForLetterDeliveryByAir() {
		dataMap.put("type", "LA");
		request = new DeliveryRequest(dataMap);
		delivery = request.getDelivery();
		assertEquals(DeliveryMethod.AIR, delivery.getDeliveryMethod());
	}
	
	@Test
	public void testRequestForLetterDeliveryByGround() {
		dataMap.put("type", "LG");
		request = new DeliveryRequest(dataMap);
		delivery = request.getDelivery();
		assertEquals(DeliveryMethod.GROUND, delivery.getDeliveryMethod());
	}
	
	@Test
	public void testRequestForBoxDeliveryByAir() {
		dataMap.put("type", "BA");
		request = new DeliveryRequest(dataMap);
		delivery = request.getDelivery();
		assertEquals(DeliveryMethod.AIR, delivery.getDeliveryMethod());
	}
	
	@Test
	public void testRequestForBoxDeliveryByGround() {
		dataMap.put("type", "BG");
		request = new DeliveryRequest(dataMap);
		delivery = request.getDelivery();
		assertEquals(DeliveryMethod.GROUND, delivery.getDeliveryMethod());
	}
	
	@Test
	public void testRequestForLetterType() {
		dataMap.put("ltype", LetterType.PLAIN.toString());
		request = new DeliveryRequest(dataMap);
		delivery = request.getDelivery();
		Letter letter = (Letter) delivery.getParcel();
		assertEquals(LetterType.PLAIN, letter.getType());
	}

	public void testShowConfirmationForLetterDeliveryByAir() {
		dataMap.put("type", "LA");
		request = new DeliveryRequest(dataMap);
		request.getDelivery().setPackageStatus(DeliveryStatus.APPROVED);
		delivery = request.getDelivery();
		assertEquals(DeliveryStatus.APPROVED, delivery.getPackageStatus());
	}

	@Test
	public void testRequestForBoxDimension() {
		dataMap.put("type", "BG");
		request = new DeliveryRequest(dataMap);
		delivery = request.getDelivery();
		Box box = (Box) delivery.getParcel();
		assertEquals(1, box.getHeight(), 0);
		assertEquals(2, box.getWidth(), 0);
		assertEquals(3, box.getDepth(), 0);
	}

}
