package com.techhub.service;

import com.techhub.model.CityModel;

public interface CityService {

	public boolean isAddNewCity(CityModel model);

	public int getCityidByCityName(String cityName);
}
