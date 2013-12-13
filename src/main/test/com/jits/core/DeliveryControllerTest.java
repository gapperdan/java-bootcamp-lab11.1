package com.jits.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.jits.util.LoggingUtil;

public class DeliveryControllerTest {

	private Map<String, String> dataMap = new HashMap<String, String>();
	private Delivery delivery;
	private DeliveryController request;
	
	@Before
	public void setup() {
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
		dataMap.put("lType", "plain");
		dataMap.put("height", "1");
		dataMap.put("width", "2");
		dataMap.put("depth", "3");
		
		request = new DeliveryController(dataMap);
	}
	
	@Test
	public void testRequestHasADelivery() {
		delivery = request.getDelivery();
		assertNotNull(delivery);
	}
	
	@Test
	public void testRequestForLetter() {
		dataMap.put("type", "LA");
		request = new DeliveryController(dataMap);
		assertTrue(request.getDelivery().getParcel() instanceof Letter);
	}

	@Test
	public void testRequestForBox() {
		dataMap.put("type", "BA");
		request = new DeliveryController(dataMap);
		assertTrue(request.getDelivery().getParcel() instanceof Box);
	}

	@Test
	public void testRequestForLetterDeliveryByAir() {
		dataMap.put("type", "LA");
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		assertTrue(delivery instanceof AirDelivery);
	}
	
	@Test
	public void testRequestForLetterDeliveryByGround() {
		dataMap.put("type", "LG");
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		assertTrue(delivery instanceof GroundDelivery);
	}
	
	@Test
	public void testRequestForBoxDeliveryByAir() {
		dataMap.put("type", "BA");
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		assertTrue(delivery instanceof AirDelivery);		
	}
	
	@Test
	public void testRequestForBoxDeliveryByGround() {
		dataMap.put("type", "BG");
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		assertTrue(delivery instanceof GroundDelivery);
	}
	
	@Test
	public void testRequestForLetterDeliveryByRail() {
		dataMap.put("type", "LR");
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		assertTrue(delivery instanceof RailDelivery);
	}
	
	@Test
	public void testRequestForBoxDeliveryByRail() {
		dataMap.put("type", "BR");
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		assertTrue(delivery instanceof RailDelivery);
	}
	
	@Test
	public void testRequestForLetterType() {
		dataMap.put("ltype", LetterType.plain.toString());
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		Letter letter = (Letter) delivery.getParcel();
		assertEquals(LetterType.plain, letter.getType());
	}

	@Test
	public void testShowConfirmationForLetterDeliveryByAir() {
		dataMap.put("type", "LA");
		request = new DeliveryController(dataMap);
		Confirmation confirmation = request.getConfirmationForDelivery();
		request.approveDelivery(confirmation);
		delivery = request.getDelivery();
		assertEquals(DeliveryStatus.SHIPPED, delivery.getDeliveryStatus());
	}

	@Test
	public void testRequestForBoxDimension() {
		dataMap.put("type", "BG");
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		Box box = (Box) delivery.getParcel();
		assertEquals(1, box.getHeight(), 0);
		assertEquals(2, box.getWidth(), 0);
		assertEquals(3, box.getDepth(), 0);
	}

	@Test
	public void testDisplayDeliveryInfo() {
		dataMap.put("type", "BG");
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		Confirmation c = new Confirmation();
		c.setDelivery(delivery);
		LoggingUtil.log(c);
		assertTrue(delivery instanceof GroundDelivery);
	}
	
	@Test
	public void testLetterDeliveryAirCost() {
		dataMap.put("type", "LA");
		dataMap.put("fromZip", "94066");
		dataMap.put("toZip", "84066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(2.0, delivery.getShippingCost(), 0.0);
	}
	
	@Test
	public void testLetterDeliveryRailCostOneZone() {
		dataMap.put("type", "LR");
		dataMap.put("fromZip", "24066");
		dataMap.put("toZip", "14066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(5.0, delivery.getShippingCost(), 0.0);
	}
	
	@Test
	public void testLetterDeliveryRailCostTwoZonesMiddleZones() {
		dataMap.put("type", "LR");
		dataMap.put("fromZip", "44066");
		dataMap.put("toZip", "54066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(10.0, delivery.getShippingCost(), 0.0);
	}

	@Test
	public void testLetterDeliveryRailCostTwoZonesCoastToCoast() {
		dataMap.put("type", "LR");
		dataMap.put("fromZip", "14066");
		dataMap.put("toZip", "94066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(10.0, delivery.getShippingCost(), 0.0);
	}
	
	@Test
	public void testLetterDeliveryRailCostTwoZones() {
		dataMap.put("type", "LR");
		dataMap.put("fromZip", "44066");
		dataMap.put("toZip", "94066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(10.0, delivery.getShippingCost(), 0.0);
	}
	
	@Test
	public void testLetterDeliveryRailTimeOneZone() {
		dataMap.put("type", "LR");
		dataMap.put("fromZip", "24066");
		dataMap.put("toZip", "14066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(2.5, delivery.getDeliveryTime(), 0.0);
	}
	
	@Test
	public void testLetterDeliveryRailTimeTwoZones() {
		dataMap.put("type", "LR");
		dataMap.put("fromZip", "44066");
		dataMap.put("toZip", "94066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(5.0, delivery.getDeliveryTime(), 0.0);
	}

	@Test
	public void testLetterDeliveryRailTimeTwoZonesCoastToCoast() {
		dataMap.put("type", "LR");
		dataMap.put("fromZip", "14066");
		dataMap.put("toZip", "94066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(5.0, delivery.getDeliveryTime(), 0.0);
	}

	@Test
	public void testLetterDeliveryRailTimeTwoZonesMiddleZones() {
		dataMap.put("type", "LR");
		dataMap.put("fromZip", "44066");
		dataMap.put("toZip", "54066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(5.0, delivery.getDeliveryTime(), 0.0);
	}
	
	@Test
	public void testLetterDeliveryGroundCost() {
		dataMap.put("type", "LG");
		dataMap.put("fromZip", "94066");
		dataMap.put("toZip", "84066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(2.0, delivery.getShippingCost(), 0.0);
	}
	
	@Test
	public void testBoxDeliveryAirCost() {
		dataMap.put("type", "BA");
		dataMap.put("fromZip", "94066");
		dataMap.put("toZip", "84066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(12.0, delivery.getShippingCost(), 0.0);
	}
	
	@Test
	public void testBoxDeliveryGroundCost() {
		dataMap.put("type", "BG");
		dataMap.put("fromZip", "94066");
		dataMap.put("toZip", "84066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(2.0, delivery.getShippingCost(), 0.0);
	}
	
	@Test
	public void testAcceptDelivery() {
		dataMap.put("type", "LA");
		dataMap.put("fromZip", "94066");
		dataMap.put("toZip", "84066");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		delivery.approveDelivery();
		assertEquals(DeliveryStatus.SHIPPED, delivery.getDeliveryStatus());
	}
	
	@Test
	public void testInsuredBox() {
		dataMap.put("type", "BG");
		dataMap.put("insured", "true");
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		assertTrue(delivery.isInsured());
	}

	@Test
	public void testBoxDeliveryGroundCostWithInsurance() {
		dataMap.put("type", "BG");
		dataMap.put("fromZip", "94066");
		dataMap.put("toZip", "84066");
		dataMap.put("insured", "true");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(2.2, delivery.getShippingCost(), 0.0);
	}
	
	@Test
	public void testBoxDeliveryGroundCostWithNoInsurance() {
		dataMap.put("type", "BG");
		dataMap.put("fromZip", "94066");
		dataMap.put("toZip", "84066");
		dataMap.put("insured", "false");
		
		request = new DeliveryController(dataMap);
		delivery = request.getDelivery();
		delivery.getParcel().setWeight(2.0);
		request.buildDelivery();
		assertEquals(2.0, delivery.getShippingCost(), 0.0);
	}
	
}
