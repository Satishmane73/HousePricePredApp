package com.techhub.service;

import java.util.List;

import com.techhub.model.AminityModel;

public interface AminityService {

	public boolean isAddNewAminity(AminityModel model);

	List<AminityModel> getAllAminities();
}
