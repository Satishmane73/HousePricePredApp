package com.techhub.service;

import java.util.*;

import com.techhub.model.DistModel;

public interface DistService {

	public boolean isAddNewDist(String stateName, String distName);

	public boolean isAddBulkDist(String stateName);

	public List<DistModel> getDistListByStateName(String stateName);

	public int getDistIdByDistName(String distName);

	public int getDistIdByCityName(String cityName);
}
