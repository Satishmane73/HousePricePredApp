package com.techhub.service;

import java.util.List;

import com.techhub.model.DistModel;
import com.techhub.repository.*;

public class DistServiceImpl implements DistService {

	DistRepository repo = new DistRepositoryImpl();

	@Override
	public boolean isAddNewDist(String stateName, String distName) {
		// TODO Auto-generated method stub
		return repo.isAddNewDist(stateName, distName);
	}

	@Override
	public boolean isAddBulkDist(String stateName) {
		// TODO Auto-generated method stub
		return repo.isAddBulkDist(stateName);
	}

	@Override
	public List<DistModel> getDistListByStateName(String stateName) {
		// TODO Auto-generated method stub
		return repo.getDistListByStateName(stateName);
	}

	@Override
	public int getDistIdByDistName(String distName) {
		// TODO Auto-generated method stub
		return repo.getDistIdByDistName(distName);
	}

	@Override
	public int getDistIdByCityName(String cityName) {
		// TODO Auto-generated method stub
		return repo.getDistIdByCityName(cityName);
	}
}
