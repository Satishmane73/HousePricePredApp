package com.techhub.service;

import java.util.List;

import com.techhub.model.WardModel;
import com.techhub.repository.*;

public class WardServiceImpl implements WardService {

	WardRepository repo = new WardRepositoryImpl();

	@Override
	public boolean isAddNewWard(WardModel wardModel, int cityId) {
		// TODO Auto-generated method stub
		return repo.isAddNewWard(wardModel, cityId);
	}

	@Override
	public List<WardModel> getAllWardByCityName(String cityName) {
		// TODO Auto-generated method stub
		return repo.getAllWardByCityName(cityName);
	}

	@Override
	public int getWardIdByName(String wardName) {
		// TODO Auto-generated method stub
		return repo.getWardIdByName(wardName);
	}

}
