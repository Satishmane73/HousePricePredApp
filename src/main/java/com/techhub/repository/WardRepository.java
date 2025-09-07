package com.techhub.repository;

import java.util.List;

import com.techhub.model.*;

public interface WardRepository {
	boolean isAddNewWard(WardModel wardModel, int cityId);

	List<WardModel> getAllWardByCityName(String cityName);

	int getWardIdByName(String wardName);

}
