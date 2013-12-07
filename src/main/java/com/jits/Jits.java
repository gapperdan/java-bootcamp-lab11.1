package com.jits;

import javax.swing.JOptionPane;

import com.jits.core.Address;
import com.jits.core.Box;
import com.jits.core.Parcel;
import com.jits.core.Letter;
import com.jits.core.Parcel.DeliveryMethod;
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
			parcel.setPackageStatus(Parcel.PackageStatus.SHIPPED);
		} else {
			parcel.setPackageStatus(Parcel.PackageStatus.CANCELLED);
		}

	}

	public static void main(String[] args) {

		box = (Box) ParcelFactory.createParcel("box");
		box.setId("Xmas Surprise!");
		box.setDeliveryType(DeliveryMethod.AIR);
		box.setHeight(1);
		box.setWidth(1);
		box.setDepth(1);

		origin = new Address("Some Person", "555 Terry Francois Blvd",
				"San Francisco", "CA", "94105");

		destination = new Address("Another Person", "555 Anywhere St",
				"San Francisco", "CA", "94101");

		box.setOrigin(origin);
		box.setDestination(destination);

		displayInfo(box);

		letter = (Letter) ParcelFactory.createParcel("letter");
		letter.setId("Xmas Surprise!");
		letter.setDeliveryType(DeliveryMethod.GROUND);

		origin = new Address("Some Person", "555 Terry Francois Blvd",
				"San Francisco", "CA", "94105");

		destination = new Address("Another Person", "555 Anywhere St",
				"San Francisco", "CA", "94101");

		letter.setOrigin(origin);
		letter.setDestination(destination);

		displayInfo(letter);

		System.exit(0);

	}
}