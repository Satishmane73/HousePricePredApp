package com.techhub.repository;

import java.util.List;

import com.techhub.model.AminityModel;

public interface AminityRepository {

	boolean isAddNewAminity(AminityModel model);

	List<AminityModel> getAllAminities();
}
