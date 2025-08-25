package com.techhub.model;

public class WardModel extends CityModel {
	private int wardId;
	private String wardName;
	private int pin;

	public WardModel() {
	}

	public WardModel(int wardId, String wardName, int pin) {
		this.wardId = wardId;
		this.wardName = wardName;
		this.pin = pin;
	}

	public int getWardId() {
		return wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

}
