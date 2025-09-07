package com.techhub.repository;

import java.util.List;

import com.techhub.model.CityModel;

public interface CityRepository {

	boolean isAddNewCity(CityModel model);

	int getCityidByCityName(String cityName);

	List<CityModel> getCitiesFromDist(String stateName, String distName);
}
