package com.jits;

import javax.swing.JOptionPane;

import com.jits.core.Address;
import com.jits.core.Box;
import com.jits.core.Parcel;
import com.jits.core.Letter;
import com.jits.core.Parcel.DELIVERY_TYPE;
import com.jits.core.ParcelFactory;

public class Jits {
	static private Box box;
	static private Letter letter;
	static private Address destination;
	static private Address origin;

	public static void displayInfo(Parcel parcel) {

		String dimensionString = "";

		if (parcel instanceof Box) {
			Box box = (Box) parcel;
			dimensionString = "dimension: " + box.getWidth() + " X "
					+ box.getHeight() + " X " + box.getHeight() + "\n\n";
		}

		int approved = JOptionPane.showConfirmDialog(null, "Shipment Details\n"
				+ "id = "
				+ box.getId()
				+ " | Delivery Type = "
				+ parcel.getDeliveryType()
				+ "\n"
				+ dimensionString
				+ "----- Destination ----- \n"
				+ parcel.getDestination().getName()
				+ "\n"
				+ parcel.getDestination().getStreet()
				+ "\n"
				+ parcel.getDestination().getZip()
				+ "\n"
				+

				"----- Origin ----- \n"
				+ parcel.getOrigin().getName()
				+ "\n"
				+ parcel.getOrigin().getStreet()
				+ "\n"
				+ parcel.getOrigin().getCity()
				+ " "
				+ parcel.getOrigin().getState()
				+ " " + parcel.getOrigin().getZip() + "\n\n" +

				"Click Yes to Approve"
				
				);
		
		if (approved == JOptionPane.YES_OPTION) {
			parcel.setPackageStatus(Parcel.PACKAGE_STATUS.SHIPPED);
		} else {
			parcel.setPackageStatus(Parcel.PACKAGE_STATUS.CANCELLED);
		}

	}

	public static void main(String[] args) {

		box = (Box) ParcelFactory.createParcel("box");
		box.setId("Xmas Surprise!");
		box.setDeliveryType(DELIVERY_TYPE.AIR);
		box.setHeight(1.0);
		box.setWidth(1.0);
		box.setDepth(1.0);

		origin = new Address("Francis Leung", "550 Terry Francois Blvd",
				"San Francisco", "CA", "94105");

		destination = new Address("Danny Tizon", "550 Terry Francois Blvd",
				"San Francisco", "CA", "94105");

		box.setOrigin(origin);
		box.setDestination(destination);

		displayInfo(box);

		letter = (Letter) ParcelFactory.createParcel("letter");
		letter.setId("Xmas Surprise!");
		letter.setDeliveryType(DELIVERY_TYPE.GROUND);

		destination = new Address("Francis Leung", "550 Terry Francois Blvd",
				"San Francisco", "CA", "94105");

		origin = new Address("Danny Tizon", "550 Terry Francois Blvd",
				"San Francisco", "CA", "94105");

		letter.setOrigin(origin);
		letter.setDestination(destination);

		displayInfo(letter);

		System.exit(0);

	}
}