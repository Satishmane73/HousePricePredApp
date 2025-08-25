package com.techhub.model;

public class CityModel extends DistModel {

	private int cityId;
	private String cityName;

	public CityModel() {
	}

	public CityModel(int cityId, String cityName) {
		this.cityId = cityId;
		this.cityName = cityName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cityId + "\t" + cityName;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return cityId * 10000;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		CityModel model = (CityModel) obj;
		if (model.getCityId() == this.cityId && model.getCityName().equals(this.cityName))
			return true;
		else
			return false;
	}
}
