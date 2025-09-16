package com.techhub.service;

import java.util.List;

import com.techhub.model.AminityModel;
import com.techhub.repository.*;

public class AminityServiceImpl implements AminityService {
	AminityRepository repo = new AminityRepositoryImpl();

	@Override
	public boolean isAddNewAminity(AminityModel model) {
		// TODO Auto-generated method stub
		return repo.isAddNewAminity(model);
	}

	@Override
	public List<AminityModel> getAllAminities() {
		// TODO Auto-generated method stub
		return repo.getAllAminities();
	}
}
