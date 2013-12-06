package com.jits;

import javax.swing.JOptionPane;

import com.jits.core.Address;
import com.jits.core.Box;
import com.jits.core.Package;
import com.jits.core.Letter;
import com.jits.core.Package.DELIVERY_TYPE;
import com.jits.core.PackageFactory;

public class Jits {
	static private Box box;
	static private Letter letter;
	static private Address destination;
	static private Address origin;

	public static void displayInfo(Package pkg) {

		String dimensionString = "";

		if (pkg instanceof Box) {
			Box box = (Box) pkg;
			dimensionString = "dimension: " + box.getWidth() + " X "
					+ box.getHeight() + " X " + box.getHeight() + "\n\n";
		}

		int approved = JOptionPane.showConfirmDialog(null, "Shipment Details\n"
				+ "id = "
				+ box.getId()
				+ " | Delivery Type = "
				+ pkg.getDeliveryType()
				+ "\n"
				+ dimensionString
				+ "----- Destination ----- \n"
				+ pkg.getDestination().getName()
				+ "\n"
				+ pkg.getDestination().getStreet()
				+ "\n"
				+ pkg.getDestination().getZip()
				+ "\n"
				+

				"----- Origin ----- \n"
				+ pkg.getOrigin().getName()
				+ "\n"
				+ pkg.getOrigin().getStreet()
				+ "\n"
				+ pkg.getOrigin().getCity()
				+ " "
				+ pkg.getOrigin().getState()
				+ " " + pkg.getOrigin().getZip() + "\n\n" +

				"Click Yes to Approve"
				
				);
		
		if (approved == JOptionPane.YES_OPTION) {
			pkg.setPackageStatus(Package.PACKAGE_STATUS.SHIPPED);
		} else {
			pkg.setPackageStatus(Package.PACKAGE_STATUS.CANCELLED);
		}

	}

	public static void main(String[] args) {

		box = (Box) PackageFactory.createPackage("box");
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

		letter = (Letter) PackageFactory.createPackage("letter");
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