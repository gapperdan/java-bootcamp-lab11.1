package com.jits.core;


public abstract class Parcel {

	long id;
	Address destination;
	Address origin;
	double weight;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Address getDestination() {
		return destination;
	}

	public void setDestination(Address destination) {
		this.destination = destination;
	}

	public Address getOrigin() {
		return origin;
	}

	public void setOrigin(Address origin) {
		this.origin = origin;
	}

	public boolean hasValidId() {
		boolean valid = false;
		if (getId() > 0) {
			valid = true;
		} else {
			valid = false;
		}
			
		return valid;
	}


	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (weight == 0.0) {
			this.weight = 1.0;
		} else {
			this.weight = Math.ceil(weight);
		}
	}
	
	public double weighPackage() {
		return getWeight();
	}
	
	public void calculateWeight(Object object) {
		MailScaleAdapter scale = new MailScaleAdapter();
		double weight = scale.weighPackage(this);
		setWeight(weight);
	}

	public abstract double getVolume();

}
