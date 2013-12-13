package com.jits.kiosk.desktop;

import java.util.Map;

import com.jits.core.DeliveryController;
import com.jits.transfer.IConfirmation;

public class KioskRequestHandler {

	private DeliveryController controller;
	private IConfirmation conf;

	/**
	 * Called from UI after user has entered all data. UI will display the
	 * returned IConfirmation data via IConfirmation.toString() and prompt user
	 * for whether to proceed or cancel the shipment.
	 */
	public IConfirmation handleRequest(Map<String, String> request) {

		controller = new DeliveryController(request);
		conf = controller.getConfirmation();
		return conf;
	}

	/**
	 * Called from UI after user has chosen to proceed or cancel the shipment.
	 * UI will display the returned IConfirmation data via
	 * IConfirmation.toString(). After this call returns, shipment is now done
	 * or has been cancelled.
	 */
	public IConfirmation handleUserDecision(boolean proceedWithShipment) {
		if (proceedWithShipment) {
			controller.approveDelivery(conf);
		} else {
			controller.cancelDelivery();
		}
		return conf;
	}
}