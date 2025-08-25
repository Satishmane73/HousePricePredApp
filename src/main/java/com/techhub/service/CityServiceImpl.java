package com.techhub.service;

import com.techhub.model.CityModel;
import com.techhub.repository.*;

public class CityServiceImpl implements CityService {

	CityRepository cityRepo = new CityRepositoryImpl();

	@Override
	public boolean isAddNewCity(CityModel model) {
		// TODO Auto-generated method stub
		return cityRepo.isAddNewCity(model);
	}

	@Override
	public int getCityidByCityName(String cityName) {
		// TODO Auto-generated method stub
		return cityRepo.getCityidByCityName(cityName);
	}

}
