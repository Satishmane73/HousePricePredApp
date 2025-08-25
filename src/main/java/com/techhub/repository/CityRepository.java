package com.techhub.repository;

import com.techhub.model.CityModel;

public interface CityRepository {
	public boolean isAddNewCity(CityModel model);

	public int getCityidByCityName(String cityName);
}
