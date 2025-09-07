package com.techhub.service;

import java.util.List;

import com.techhub.model.CityModel;

public interface CityService {

	boolean isAddNewCity(CityModel model);

	int getCityidByCityName(String cityName);

	List<CityModel> getCitiesFromDist(String stateName, String distName);
}
