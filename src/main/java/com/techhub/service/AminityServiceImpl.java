package com.techhub.service;

import com.techhub.model.AminityModel;
import com.techhub.repository.*;

public class AminityServiceImpl implements AminityService {
	AminityRepository repo = new AminityRepositoryImpl();

	@Override
	public boolean isAddNewAminity(AminityModel model) {
		// TODO Auto-generated method stub
		return repo.isAddNewAminity(model);
	}

}
