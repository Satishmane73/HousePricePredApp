package com.techhub.service;

import com.techhub.model.WardModel;
import com.techhub.repository.*;

public class WardServiceImpl implements WardService {

	WardRepository repo = new WardRepositoryImpl();

	@Override
	public boolean isAddNewWard(WardModel wardModel, int cityId) {
		// TODO Auto-generated method stub
		return repo.isAddNewWard(wardModel, cityId);
	}

}
