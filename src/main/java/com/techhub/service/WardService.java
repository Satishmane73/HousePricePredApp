package com.techhub.service;

import java.util.List;

import com.techhub.model.WardModel;

public interface WardService {

	boolean isAddNewWard(WardModel wardModel, int cityId);

	List<WardModel> getAllWardByCityName(String cityName);

	int getWardIdByName(String wardName);
}
