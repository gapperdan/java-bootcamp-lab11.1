package com.jits.util;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.jits.core.Delivery;
import com.jits.transfer.IConfirmation;

public class LoggingUtil {
	public static void log(IConfirmation c) {

		try {
			FileOutputStream fos = new FileOutputStream(
					"/Users/da55296/Documents/delivery.xml",true);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			XMLEncoder xmlEncoder = new XMLEncoder(bos);
			xmlEncoder.writeObject(c);
			xmlEncoder.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void audit(double cost) {

		try {
			FileOutputStream fos = new FileOutputStream(
					"/Users/da55296/Documents/audit.log", true);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			String s =  cost + " " + new Date() + "\n"; 
			bos.write(s.getBytes());
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}