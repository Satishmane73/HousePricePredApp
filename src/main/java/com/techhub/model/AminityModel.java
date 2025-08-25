package com.techhub.model;

public class AminityModel {
	private int aminity_Id;
	private String aminity_Name;

	public AminityModel() {
	}

	public AminityModel(int aminity_Id, String aminity_Name) {
		this.aminity_Id = aminity_Id;
		this.aminity_Name = aminity_Name;
	}

	public int getAminity_Id() {
		return aminity_Id;
	}

	public void setAminity_Id(int aminity_Id) {
		this.aminity_Id = aminity_Id;
	}

	public String getAminity_Name() {
		return aminity_Name;
	}

	public void setAminity_Name(String aminity_Name) {
		this.aminity_Name = aminity_Name;
	}

}
