package com.techhub.service;

import com.techhub.model.PropertyModel;
import com.techhub.repository.PropertyRepository;
import com.techhub.repository.PropertyRepositoryImpl;

public class PropertyServiceImpl implements PropertyService {

	PropertyRepository repo = new PropertyRepositoryImpl();

	@Override
	public boolean isAddNewProperty(PropertyModel model) {
		// TODO Auto-generated method stub
		return repo.isAddNewProperty(model);
	}

}
