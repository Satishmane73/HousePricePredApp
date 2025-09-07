//this interface for declare operations of destrict which is implemented in DistRepositoryImpl class 

package com.techhub.repository;

import java.util.List;

import com.techhub.model.DistModel;

public interface DistRepository {

	boolean isAddNewDist(String stateName, String distName);

	boolean isAddBulkDist(String stateName);

	List<DistModel> getDistListByStateName(String stateName);

	int getDistIdByDistName(String distName);

	int getDistIdByCityName(String cityName);
}
